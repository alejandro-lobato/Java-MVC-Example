
/*----------------------------------------------------------------------------*
 * Proyecto Model-View-Controller
 * Autor: Alejandro Lobato Molina
 *  ID: 154422
 *  Implementando las interfaces provistas por el Dr. Gerardo Ayala.
 *
 *  Ver README adjunto a la carpeta para información sobre el funcionamiento.
 *----------------------------------------------------------------------------*/

public class Main {
    public static void main(String [] args){

        Interfaz view = new Interfaz();
        Estructura model = new Estructura();
        Mediador controller = new Mediador(view, model);
        view.setActionListener(controller);
        controller.actualizaElView();

    }//Fin de método main.
}//Fin de clase Main.
