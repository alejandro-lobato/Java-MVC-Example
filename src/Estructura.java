import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Estructura extends ArrayList<Cliente> implements Model{
    /*----------------------------------------------------------
     * Método que abre el archivo especificado para su lectura.
     *---------------------------------------------------------*/
    public void cargaDatosDelRepositorioALaEstructura(){
        try {

            int tamano, pelis;
            String id, nombre, dir, cp, tel;
            Cliente cliente;

            FileReader reader = new FileReader("clientes.txt");
            BufferedReader in = new BufferedReader(reader);

            tamano = Integer.parseInt(in.readLine());

            for(int i = 0; i < tamano; i++){

                in.readLine(); //Salto de línea.
                id = in.readLine();
                nombre = in.readLine();
                dir = in.readLine();
                cp = in.readLine();
                tel = in.readLine();
                pelis = Integer.parseInt(in.readLine());

                cliente = new Cliente(nombre, dir, cp, tel);
                cliente.setID(Integer.parseInt(id));
                cliente.setPelis(pelis);
                add(i, cliente);

            }//Fin del for.

            in.close();

        } //Fin de try.

        //Manejo de excepciones.
        catch(FileNotFoundException e){
            System.out.println("El archivo no se encuentra.");
            System.out.println("Revisar nombre de archivo y extensión.");
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(NumberFormatException e){
            System.out.println("El archivo está vacío.");
        }
    } //Fin de método.

    /*------------------------------------------------------------
     * Método que abre el archivo especificado para su escritura.
     *-----------------------------------------------------------*/

    public void salvaDatosDeLaEstructuraAlRepositorio(){
        try {
            Cliente cliente;
            FileWriter writer = new FileWriter("clientes.txt");
            BufferedWriter out = new BufferedWriter(writer);

            Integer size = size();
            Integer pelis;

            out.write(size.toString() + "\n");

            for(int i = 0; i < size(); i++) {

                cliente = get(i);
                pelis = cliente.getPeliculasRentadas();

                out.newLine();
                out.write(cliente.getID() + "\n");
                out.write(cliente.getNombre() + "\n");
                out.write(cliente.getDir() + "\n");
                out.write(cliente.getCP() + "\n");
                out.write(cliente.getTel() + "\n");
                out.write(pelis.toString() + "\n");

            }

            out.close();

        } //Fin de try.
        catch(FileNotFoundException e){
            System.out.println("El archivo no se encuentra.");
            System.out.println("Revisar nombre de archivo y extensión.");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    } //Fin de método.

    public void agregaDatosALaEstructura(int indice, Object dato){
        add(indice, (Cliente) dato);
    }

    public void modificaDatosEnLaEstructura(int indice, Object dato){
        set(indice, (Cliente) dato);
    }

    public void eliminaDatosDeLaEstructura(int indice){
        remove(indice);
    }

    public void ordenaLaEstructura(){
        Collections.sort(this);
    }

    public double procesa(int indice){
        double adeudo;
        double COSTO_RENTA = 15.75D;

        Cliente cliente = get(indice);

        int pelis = cliente.getPeliculasRentadas();

        adeudo = pelis * COSTO_RENTA;
        cliente.setAdeudo(adeudo);

        return adeudo;
    }
    public boolean hayDatos(){
        return !isEmpty();
    }

} //Fin de clase.
