/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

/**
 * 
 * @author Remynoschka
 */
public class ConfigMonitors {

	private static GraphicsConfiguration	gconfig;
	private static GraphicsEnvironment		genv;
	private static GraphicsDevice			gdev;
	private static int						nbConfig	= 0;

	private ConfigMonitors() {
		nbConfig = 1;
		genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
		gdev = genv.getDefaultScreenDevice();
		gconfig = gdev.getDefaultConfiguration();
	}

	/**
	 * Methode qui permet d'obtenir la configuration locale
	 * 
	 * @return la Configuration ou null si d�j� invoqu�
	 * 
	 */
	public static ConfigMonitors getConfiguration() {
		if (nbConfig == 0) {
			return new ConfigMonitors();
		} else {
			return null;
		}
	}

	/**
	 * @return le GraphicsEnvironment Local
	 */
	public static GraphicsEnvironment getGraphicsEnvironment() {
		return genv;
	}

	/**
	 * @return le GraphicsConfiguration
	 */
	public static GraphicsConfiguration getGraphicsConfiguration() {
		return gconfig;
	}

	/**
	 * @return le GraphicsDevice
	 */
	public static GraphicsDevice getGraphicsDevice() {
		return gdev;
	}
}
