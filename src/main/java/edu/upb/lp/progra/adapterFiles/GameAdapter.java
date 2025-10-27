package edu.upb.lp.progra.adapterFiles;

import edu.upb.lp.progra.adapterFiles.AndroidLibrary;

public class GameAdapter {
	public static AppConnector selectGame(AndroidLibrary gui) {
		return new edu.upb.lp.progra.adapterFiles.ProyectoPrograIIConnector(gui);
	}
}
