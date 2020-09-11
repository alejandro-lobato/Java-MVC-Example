public class Cliente implements Comparable<Cliente>{

    private String nombre, direccion, telefono, codigoPostal;
    private Integer peliculasRentadas, id;
    private static Integer id_counter = 1000;

    private double adeudo;

    public Cliente(String n, String dir, String cp, String tel){

        id();
        nombre = n;
        direccion = dir;
        telefono = tel;
        codigoPostal = cp;
        peliculasRentadas = 0;
        adeudo = 0.0;

    } //Fin de constructor Cliente.

    /*----------------------------------------------------------
     * Getters para la recuperación de información.
     *---------------------------------------------------------*/

    public String getID() { return id.toString(); }

    public String getCP() { return codigoPostal; }

    public String getDir() { return direccion; }

    public String getNombre() { return nombre; }

    public String getTel() { return telefono; }

    public Integer getPeliculasRentadas() {  return peliculasRentadas; }

    public void rentarPeliculas(int pelis){
        peliculasRentadas = peliculasRentadas + pelis;
    }

    public void setAdeudo(double a){
        adeudo = a;
    }

    public void setID(Integer id){ this.id = id; }

    public void setPelis(Integer pelis){this.peliculasRentadas = pelis; }

    public int compareTo(Cliente otroCliente){

        int otroID = Integer.parseInt(otroCliente.getID());
        int esteID = id;
        int output = 0;

        //Código basado de la clase Estudiante del Dr. Ayala.
        //Implementa un criterio de comparación entre 2 valores.

        if(esteID > otroID)
            output = 1;
        else if(esteID < otroID)
            output = -1;
        else
            output = 0;

        return output;
    }

    private void id(){
        id = id_counter;
        id_counter++;
    }

} //Fin de clase Cliente.
