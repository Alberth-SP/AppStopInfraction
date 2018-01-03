package MVP_main;

/**
 * Created by alberth on 24/12/2017.
 */

public interface MVP_Main {

    interface Vista{
        void notificarItemInsertado();
        void setVista(Vista vista);
    }


    interface Presentador{
        void setVista(Vista view);
    }
}


