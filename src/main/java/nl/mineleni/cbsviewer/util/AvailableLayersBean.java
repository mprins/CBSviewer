/*
 * Copyright (c) 2012-2013, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie.
 */
package nl.mineleni.cbsviewer.util;

import java.io.File;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import nl.mineleni.cbsviewer.util.xml.LayerDescriptor;
import nl.mineleni.cbsviewer.util.xml.LayersList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import flexjson.JSONSerializer;
import flexjson.transformer.AbstractTransformer;

/**
 * AvailableLayersBean maakt de beschikbare kaarten bekend in de applicatie op
 * basis van het xml configuratie bestand {@code AvailableLayers.xml}.
 * 
 * @author mprins
 * @since 1.6
 */
public class AvailableLayersBean {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AvailableLayersBean.class);

	/**
	 * lijst met beschikbare layers.
	 */
	private List<LayerDescriptor> layers = null;

	/**
	 * default constructor.
	 */
	public AvailableLayersBean() {
		try {
			final JAXBContext jc = JAXBContext
					.newInstance("nl.mineleni.cbsviewer.util.xml");
			final Unmarshaller u = jc.createUnmarshaller();
			final File f = new File(this.getClass().getClassLoader()
					.getResource("AvailableLayers.xml").getFile());
			@SuppressWarnings("unchecked")
			final JAXBElement<LayersList> element = (JAXBElement<LayersList>) u
					.unmarshal(f);
			final LayersList layerslist = element.getValue();
			this.layers = layerslist.getLayerdescriptor();
		} catch (final JAXBException e) {
			LOGGER.error(
					"Er is een fout opgetreden bij het inlezen van de layers.",
					e);
		}
	}

	/**
	 * accessor voor de lijst met layers.
	 * 
	 */
	public List<LayerDescriptor> getLayers() {
		return Collections.unmodifiableList(layers);
	}

	/**
	 * Geeft de kaarten als javascript variabele.
	 * 
	 * @return layers als json object
	 * @see #asJSON(boolean)
	 */
	public String asJSON() {
		return this.asJSON(true);
	}

	/**
	 * Geeft de kaarten als json object ({@code asVar == false}) of javascript
	 * variabele, ingepakt in een CDATA sectie. Het object is een array met
	 * LayerDescriptors. Null waarden worden niet geserialiseerd.
	 * 
	 * @param asVar
	 *            {@code true} als er een javascript variabele moet worden
	 *            gegeven.
	 * @return layers als json
	 * 
	 * @see #asJSON()
	 */
	public String asJSON(final boolean asVar) {
		final JSONSerializer serializer = new JSONSerializer();
		final String json = serializer.transform(new AbstractTransformer() {
			@Override
			public Boolean isInline() {
				return true;
			}

			@Override
			public void transform(Object object) {
				// null objecten niet serializeren.
				return;
			}
		}, void.class).exclude("class", "aliases", "attributes")
				.prettyPrint(LOGGER.isDebugEnabled()).serialize(this.layers);
		if (asVar) {
			return "\n/* <![CDATA[ */ var _layers=" + json + ";/* ]]> */";
		}
		return json;
	}

	/**
	 * geeft de eerste layerdescriptor met de gevraagde id.
	 * 
	 * @param id
	 *            de ID van de laag
	 * @return the layer by id
	 * @see LayerDescriptor#getId()
	 */
	public LayerDescriptor getLayerByID(final String id) {
		for (final LayerDescriptor desc : this.layers) {
			if (desc.getId().equalsIgnoreCase(id)) {
				return desc;
			}
		}
		return null;
	}

	/**
	 * geeft de eerste layerdescriptor met de gevraagde naam.
	 * 
	 * @param queryLyrName
	 *            de naam van de wms laag
	 * @param lyrUrl
	 *            de url van de wms
	 * 
	 * @return the layer by name and url
	 * @see LayerDescriptor#getLayers()
	 */
	public LayerDescriptor getLayerByLayers(final String queryLyrName,
			final String lyrUrl) {
		for (final LayerDescriptor desc : this.layers) {
			if ((desc.getLayers().replaceAll("\\s", ""))
					.equalsIgnoreCase(queryLyrName.replaceAll("\\s", ""))) {
				if (desc.getUrl().equalsIgnoreCase(lyrUrl)) {
					LOGGER.debug("Gevonden layer-id is: " + desc.getId());
					return desc;
				}
			}
		}
		return null;
	}

	/**
	 * geeft de eerste layerdescriptor met de gevraagde naam, url.
	 * 
	 * @param queryLyrName
	 *            de naam van de wms laag
	 * @param lyrUrl
	 *            de url van de wms
	 * @param styles
	 *            wms styles
	 * 
	 * @return the layer by name and url
	 * @see LayerDescriptor#getLayers()
	 */
	public LayerDescriptor getLayerByLayers(final String queryLyrName,
			final String lyrUrl, final String styles) {
		for (final LayerDescriptor desc : this.layers) {
			if ((desc.getLayers().replaceAll("\\s", ""))
					.equalsIgnoreCase(queryLyrName.replaceAll("\\s", ""))) {
				if (desc.getUrl().equalsIgnoreCase(lyrUrl)) {
					if (desc.getStyles().replaceAll("\\s", "")
							.equalsIgnoreCase(styles)) {
						LOGGER.debug("Gevonden layer-id is: " + desc.getId());
						return desc;
					}
				}
			}
		}
		return null;
	}

	/**
	 * geeft de eerste layerdescriptor met de gevraagde naam.
	 * 
	 * @param name
	 *            de naam van de laag
	 * @return the layer by name
	 * @see LayerDescriptor#getName()
	 */
	public LayerDescriptor getLayerByName(final String name) {
		for (final LayerDescriptor desc : this.layers) {
			if (desc.getName().equalsIgnoreCase(name)) {
				LOGGER.debug("Gevonden layer-id is: " + desc.getId());
				return desc;
			}
		}
		return null;
	}
}
