package nl.mineleni.cbsviewer.util;

import java.io.File;
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

public class AvailableLayersBean {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AvailableLayersBean.class);

	/**
	 * lijst met beschikbare layers.
	 * 
	 */
	List<LayerDescriptor> layers = null;

	/**
	 * default constructor.
	 */
	public AvailableLayersBean() {
		try {
			JAXBContext jc = JAXBContext
					.newInstance("nl.mineleni.cbsviewer.util.xml");

			Unmarshaller u = jc.createUnmarshaller();
			File f = new File(this.getClass().getClassLoader()
					.getResource("AvailableLayers.xml").getFile());
			@SuppressWarnings("unchecked")
			JAXBElement<LayersList> element = (JAXBElement<LayersList>) u
					.unmarshal(f);
			LayersList layerslist = element.getValue();
			layers = layerslist.getLayerdescriptor();
		} catch (JAXBException e) {
			LOGGER.error(
					"Er is een fout opgetreden bij het inlezen van de layers.",
					e);
		}
	}

	/**
	 * geeft de eerste layerdescriptor met de gevraagde naam.
	 * 
	 * @param name
	 * @return
	 */
	public LayerDescriptor getLayerByName(String name) {
		for (LayerDescriptor desc : layers) {
			if (desc.getName().equalsIgnoreCase(name))
				return desc;
		}
		return null;
	}

	/**
	 * geeft de eerste layerdescriptor met de gevraagde naam.
	 * 
	 * @param name
	 * @return
	 */
	public LayerDescriptor getLayerByID(String name) {
		for (LayerDescriptor desc : layers) {
			if (desc.getId().equalsIgnoreCase(name))
				return desc;
		}
		return null;
	}

	public String asJSON() {
		JSONSerializer serializer = new JSONSerializer();
		String json = serializer.exclude("class")
				.prettyPrint(LOGGER.isDebugEnabled()).serialize(this.layers);
		return "var _layers=" + json + ";";
	}
}
