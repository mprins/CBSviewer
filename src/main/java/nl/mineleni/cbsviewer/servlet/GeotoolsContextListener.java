/*
 * Copyright (c) 2012, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie.
 */
package nl.mineleni.cbsviewer.servlet;

import java.util.Set;

import javax.imageio.ImageIO;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.geotools.data.DataAccessFinder;
import org.geotools.data.DataStoreFinder;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.Hints;
import org.geotools.referencing.CRS;
import org.geotools.referencing.ReferencingFactoryFinder;
import org.geotools.referencing.factory.AbstractAuthorityFactory;
import org.geotools.referencing.factory.DeferredAuthorityFactory;
import org.geotools.util.WeakCollectionCleaner;
import org.opengis.referencing.AuthorityFactory;
import org.opengis.referencing.FactoryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Lifecycle Listener implementation class GeotoolsContextListener.
 * Initialize & cleanup van Geotools therads en lookups
 * 
 * @author Mark
 */
public class GeotoolsContextListener implements ServletContextListener {
    /** logger. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(GeotoolsContextListener.class);

    /*
     * (non-Javadoc)
     * 
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        try {
            org.geotools.util.logging.Logging.ALL
                    .setLoggerFactory("org.geotools.util.logging.Log4JLoggerFactory");
        } catch (ClassNotFoundException | IllegalArgumentException e1) {
            // ignore
        }
        System.setProperty("org.geotools.epsg.factory.timeout", "-1");
        ImageIO.scanForPlugins();

        // initialize geotools factories so that we don't make a spi lookup
        // every time a factory is needed
        Hints.putSystemDefault(Hints.FILTER_FACTORY,
                CommonFactoryFinder.getFilterFactory2(null));
        Hints.putSystemDefault(Hints.STYLE_FACTORY,
                CommonFactoryFinder.getStyleFactory(null));
        Hints.putSystemDefault(Hints.FEATURE_FACTORY,
                CommonFactoryFinder.getFeatureFactory(null));
    }

    /*
     * (non-Javadoc)
     * 
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        // unload all deferred authority factories so that we get rid of the
        // timer tasks in them
        try {
            this.disposeAuthorityFactories(ReferencingFactoryFinder
                    .getCoordinateOperationAuthorityFactories(null));
        } catch (final FactoryException e) {
            LOGGER.warn(
                    "Fout opgetreden tijden opruimen van authority factories.",
                    e);
        }

        try {
            this.disposeAuthorityFactories(ReferencingFactoryFinder
                    .getCRSAuthorityFactories(null));
        } catch (final FactoryException e) {
            LOGGER.warn(
                    "Fout opgetreden tijden opruimen van authority factories.",
                    e);
        }
        try {
            this.disposeAuthorityFactories(ReferencingFactoryFinder
                    .getCSAuthorityFactories(null));
        } catch (final FactoryException e) {
            LOGGER.warn(
                    "Fout opgetreden tijden opruimen van authority factories.",
                    e);
        }

        // kill the threads created by referencing
        WeakCollectionCleaner.DEFAULT.exit();
        DeferredAuthorityFactory.exit();
        CRS.reset("all");
        ReferencingFactoryFinder.reset();
        CommonFactoryFinder.reset();
        DataStoreFinder.reset();
        DataAccessFinder.reset();

        try {
            System.gc();
            System.runFinalization();
            System.gc();
            System.runFinalization();
            System.gc();
        } catch (final Throwable t) {
            LOGGER.error("Failed to perform closing up finalization", t);
        }
    }

    /**
     * Dispose authority factories.
     * 
     * @param factories
     *            the factories
     * @throws FactoryException
     *             the factory exception
     */
    private void disposeAuthorityFactories(
            Set<? extends AuthorityFactory> factories) throws FactoryException {
        for (final AuthorityFactory af : factories) {
            if (af instanceof AbstractAuthorityFactory) {
                LOGGER.debug("Opruimen referencing factory " + af);
                ((AbstractAuthorityFactory) af).dispose();
            }
        }
    }
}
