package edu.upb.lp.progra.adapterFiles;

public class Juego {
    public interface AppConnector {

        /**
         * This method is executed by the UPB android library every time that the
         * user presses a button
         *
         * @param name
         *            The name of the button pressed
         */
        void onButtonPressed(String name);

        /**
         * This method is executed by the UPB android library every time that the
         * user pressed a cell in the images matrix
         *
         * @param horizontal
         * @param vertical
         */
        void onCellPressed(int vertical, int horizontal);

        /**
         * This method is executed once by the UPB android library at the start of
         * the application. Clients should initialize all the graphical components
         * in this method.
         */
        void initialiseInterface();

    }

}
