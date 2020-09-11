import java.awt.event.ActionEvent;
import javax.swing.*;

public class Mediador implements Controller {

    Estructura model;
    Interfaz view;
    private int marcador;

    public Mediador(Interfaz i, Estructura e) {

        model = e;
        view = i;
        model.cargaDatosDelRepositorioALaEstructura();
        marcador = 0;
    }

    public Cliente obtieneDatoDelModel(int indice) {

        if (model.hayDatos()) {
            return model.get(indice);
        }
        return null;
    }

    public Cliente obtieneDatoDelView() {

        Cliente c;
        String nombre, direccion, cp, telefono;

        nombre = view.getText("Nombre");
        direccion = view.getText("Dirección");
        cp = view.getText("CP");
        telefono = view.getText("Tel");

        if(nombre.equals("") || direccion.equals("") || cp.equals("") || telefono.equals("")) {

            JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos.",
                    "Aviso", JOptionPane.PLAIN_MESSAGE);
            return null;
        }
        else{
            c = new Cliente(nombre, direccion, cp, telefono);
            return c;
        }
    }

    public void actualizaElView() {

        String id, nombre, dir, cp, tel, pelis;
        Cliente c = obtieneDatoDelModel(marcador);
            if (model.hayDatos() && c != null) {

                id = c.getID();
                nombre = c.getNombre();
                dir = c.getDir();
                cp = c.getCP();
                tel = c.getTel();
                pelis = c.getPeliculasRentadas().toString();

                view.setText("ID", id);
                view.setText("Nombre", nombre);
                view.setText("Dirección", dir);
                view.setText("CP", cp);
                view.setText("Tel", tel);
                view.setText("Películas", pelis);

            } else {
                JOptionPane.showMessageDialog(null, "No hay datos.",
                        "Información del sistema", JOptionPane.WARNING_MESSAGE);
            }

    } // Fin de método actualizaElView.

    //----------- Realiza las acciones correspondientes al model -------------------------
    public void solicitaActualizacionDelModel(String accion) {

        Cliente c;
        int valor;

        switch (accion) {

            case "Dar de alta un cliente":
                c = obtieneDatoDelView();
                if(c != null) {
                    model.agregaDatosALaEstructura(marcador, c);
                    System.out.println(model.size());
                    actualizaElView();
                }
                break;

            case "Modificar datos del cliente":

                c = obtieneDatoDelView();
                if(c != null) {
                    c.setID(Integer.parseInt(view.getText("ID")));
                    c.setPelis(Integer.parseInt(view.getText("Películas")));
                    model.modificaDatosEnLaEstructura(marcador, c);
                    actualizaElView();
                }
                break;

            case "Guardar cambios":
                    model.salvaDatosDeLaEstructuraAlRepositorio();
                    actualizaElView();
                break;

            case "Borrar este cliente":
                int respuesta;
                boolean bandera = ( view.getText("Nombre").equals("") &&
                        view.getText("Dirección").equals("") && view.getText("CP").equals("")
                        && view.getText("Tel").equals(""));

                System.out.println(bandera);

                respuesta = JOptionPane.showConfirmDialog(null, "Se eliminará el dato" +
                        " de manera permanente.\n Confirmar acción:", "Atención", JOptionPane.OK_CANCEL_OPTION);

                if(respuesta == 0 && !bandera && model.size() > 0) {
                    model.eliminaDatosDeLaEstructura(marcador);
                    view.setText("ID", "");
                    view.setText("Nombre", "");
                    view.setText("Dirección", "");
                    view.setText("CP", "");
                    view.setText("Tel", "");
                    view.setText("Películas", "");
                    actualizaElView();
                }
                else
                    actualizaElView();
                break;

            case "Siguiente >>":
                siguiente();
                actualizaElView();
                break;

            case "<< Anterior":
                anterior();
                actualizaElView();
                break;

            case "Ordenar estructura":
                model.ordenaLaEstructura();
                marcador = 0;
                actualizaElView();
                break;

            case "Rentar película(s)":

                c = obtieneDatoDelView();
                String pelis;
                if(c != null) {
                    pelis = JOptionPane.showInputDialog(null, "Ingrese la cantidad de películas:");

                    valor = Integer.parseInt(pelis);

                    c.rentarPeliculas(valor);

                    c.setID(Integer.parseInt(view.getText("ID")));

                    model.modificaDatosEnLaEstructura(marcador, c);

                    actualizaElView();
                }
                break;

            case "Ver adeudo del cliente":
                JOptionPane.showMessageDialog(null, "El cliente debe pagar -- $" +
                                model.procesa(marcador), "Sistema", JOptionPane.PLAIN_MESSAGE);
                break;


            default:
                break;
        }

    } // Fin de método solicitaActualizacionDelModel

    //----------- Incrementar apuntador cuidando excepción ListIndexOufOfBounds --------------------
    public void siguiente() {

        marcador++;
        if(marcador == model.size()){
            marcador = model.size() - 1;
        }
    } // Fin de método siguiente.

    public void anterior(){
        marcador--;
        if(marcador < 0){
            marcador = 0;
        }
    } //Fin de método anterior.
    //-----------------------------------------------------------------------------------------------

    //------------------- Event handler ----------------------
    public void actionPerformed(ActionEvent evento) {

        String opcion;

        opcion = evento.getActionCommand();

        switch (opcion) {

            case "Dar de alta un cliente":
                solicitaActualizacionDelModel(opcion);
                break;

            case "Modificar datos del cliente":
                solicitaActualizacionDelModel(opcion);
                break;

            case "Guardar cambios":
                solicitaActualizacionDelModel(opcion);
                break;

            case "Borrar este cliente":
                solicitaActualizacionDelModel(opcion);
                break;

            case "<< Anterior":
                solicitaActualizacionDelModel(opcion);
                break;

            case "Siguiente >>":
                solicitaActualizacionDelModel(opcion);
                break;

            case "Ordenar estructura":
                solicitaActualizacionDelModel(opcion);
                break;

            case "Rentar película(s)":
                solicitaActualizacionDelModel(opcion);
                break;


            case "Ver adeudo del cliente":
                solicitaActualizacionDelModel(opcion);
                break;

            default:
                break;
        }

    }
}
