package nl.mineleni.cbsviewer.servlet.wms.cache;

import java.awt.image.BufferedImage;

/**
 * Cachable image implementatie.
 * 
 * @author prinsmc
 * @since 1.6
 */
class CacheImage implements CachableImage<BufferedImage> {

	/** image. */
	private BufferedImage image = null;

	/** bestandsnaam. */
	private final String fName;

	/**
	 * Maak een nieuwe cache afbeelding aan.
	 * 
	 * @param image
	 *            de afbeelding
	 * @param filename
	 *            de bestandsnaam
	 */
	public CacheImage(BufferedImage image, String filename) {
		this.image = image;
		this.fName = filename;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.eleni.gcc.vpziek.cache.CachableImage#getImage()
	 */
	@Override
	public BufferedImage getImage() {
		return this.image;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.eleni.gcc.vpziek.cache.CachableImage#getName()
	 */
	@Override
	public String getName() {
		return this.fName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.eleni.gcc.vpziek.cache.CachableImage#isValid()
	 */
	@Override
	public boolean isValid() {
		return ((this.image != null) && (this.fName != null));
	}
}
