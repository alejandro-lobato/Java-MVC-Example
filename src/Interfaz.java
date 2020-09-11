import javax.swing.*;
import java.awt.*;

public class Interfaz extends JFrame implements View {

    //Obtención de dimensiones de la pantalla para visualización uniforme en diferentes resoluciones.
    Dimension screen_size = Toolkit.getDefaultToolkit().getScreenSize();

    private Font fontDeLabel = new Font("Arial", Font.PLAIN, 13);
    private Font fontDeTextField = new Font("Arial", Font.PLAIN, 15);

    private int width = (int) screen_size.getWidth();
    private int height = (int) screen_size.getHeight();

    private JLabel jLabelID, jLabelNombre, jLabelDireccion, jLabelCP, jLabelTel, jLabelPeliculas;

    private JTextField jTextFieldID, jTextFieldNombre, jTextFieldDireccion, jTextFieldCP, jTextFieldTel,
            jTextFieldPeliculas;

    private JButton jButtonAnterior, jButtonSiguiente;

    private JMenuBar jMenuBarDeLaInterfaz;

    private JMenu jMenuCliente, jMenuSistema;

    private JMenuItem jMenuItemModificarDatosDelCliente, jMenuItemBorrarCliente, jMenuItemNuevoCliente,
            jMenuItemOrdenarEstructura, jMenuItemRentar, jMenuItemGuardarInformacion,
            jMenuItemVerAdeudo;


    public Interfaz() {

        construyeComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("BUSTERBLOCK v1.0");
        setLayout(null);
        setResizable(false);
        setBounds(width / 6, height / 10, 465, 400);
        setVisible(true);

    }

    public void construyeComponentes() {

        jMenuBarDeLaInterfaz = new JMenuBar();

        jMenuCliente = new JMenu("Cliente");
        jMenuSistema = new JMenu("Sistema");

        jMenuItemNuevoCliente = new JMenuItem("Dar de alta un cliente");
        jMenuItemBorrarCliente = new JMenuItem("Borrar este cliente");
        jMenuItemModificarDatosDelCliente = new JMenuItem("Modificar datos del cliente");
        jMenuItemRentar = new JMenuItem("Rentar película(s)");
        jMenuItemGuardarInformacion = new JMenuItem("Guardar cambios");
        jMenuItemVerAdeudo = new JMenuItem("Ver adeudo del cliente");

        jMenuItemOrdenarEstructura = new JMenuItem("Ordenar estructura");

        jLabelID = new JLabel("No. Cliente");
        jLabelID.setBounds(25, 25, 100, 13);
        jLabelID.setFont(fontDeLabel);
        add(jLabelID);

        jTextFieldID = new JTextField();
        jTextFieldID.setBounds(25, 40, 120, 26);
        jTextFieldID.setFont(fontDeTextField);
        jTextFieldID.setBackground(Color.WHITE);
        jTextFieldID.setEditable(false);
        add(jTextFieldID);

        jLabelNombre = new JLabel("Nombre");
        jLabelNombre.setBounds(175, 25, 100, 13);
        jLabelNombre.setFont(fontDeLabel);
        add(jLabelNombre);

        jTextFieldNombre = new JTextField();
        jTextFieldNombre.setBounds(175, 40, 250, 26);
        jTextFieldNombre.setFont(fontDeTextField);
        jTextFieldNombre.setBackground(Color.WHITE);
        add(jTextFieldNombre);

        jLabelDireccion = new JLabel("Dirección");
        jLabelDireccion.setBounds(25, 100, 100, 13);
        jLabelDireccion.setFont(fontDeLabel);
        add(jLabelDireccion);

        jTextFieldDireccion = new JTextField();
        jTextFieldDireccion.setBounds(25, 115, 400, 26);
        jTextFieldDireccion.setFont(fontDeTextField);
        jTextFieldDireccion.setBackground(Color.WHITE);
        add(jTextFieldDireccion);

        jLabelCP = new JLabel("Código Postal");
        jLabelCP.setBounds(25, 173, 100, 15);
        jLabelCP.setFont(fontDeLabel);
        add(jLabelCP);

        jTextFieldCP = new JTextField();
        jTextFieldCP.setBounds(25, 190, 120, 26);
        jTextFieldCP.setFont(fontDeTextField);
        jTextFieldCP.setBackground(Color.WHITE);
        add(jTextFieldCP);

        jLabelTel = new JLabel("Teléfono");
        jLabelTel.setBounds(175, 175, 100, 13);
        jLabelTel.setFont(fontDeLabel);
        add(jLabelTel);

        jTextFieldTel = new JTextField();
        jTextFieldTel.setBounds(175, 190, 250, 26);
        jTextFieldTel.setFont(fontDeTextField);
        jTextFieldTel.setBackground(Color.WHITE);
        add(jTextFieldTel);

        jLabelPeliculas = new JLabel("Películas");
        jLabelPeliculas.setBounds(25, 250, 120, 13);
        jLabelPeliculas.setFont(fontDeLabel);
        add(jLabelPeliculas);

        jTextFieldPeliculas = new JTextField();
        jTextFieldPeliculas.setBounds(25, 265, 120, 26);
        jTextFieldPeliculas.setFont(fontDeTextField);
        jTextFieldPeliculas.setBackground(Color.WHITE);
        jTextFieldPeliculas.setEditable(false);
        add(jTextFieldPeliculas);

        jButtonAnterior = new JButton("<< Anterior");
        jButtonAnterior.setBounds(175, 265, 120, 26);
        add(jButtonAnterior);

        jButtonSiguiente = new JButton("Siguiente >>");
        jButtonSiguiente.setBounds(305, 265, 120, 26);
        add(jButtonSiguiente);

        jMenuCliente.add(jMenuItemBorrarCliente);
        jMenuCliente.add(jMenuItemModificarDatosDelCliente);
        jMenuCliente.add(jMenuItemVerAdeudo);
        jMenuCliente.addSeparator();
        jMenuCliente.add(jMenuItemNuevoCliente);

        jMenuSistema.add(jMenuItemOrdenarEstructura);
        jMenuSistema.add(jMenuItemGuardarInformacion);
        jMenuSistema.addSeparator();
        jMenuSistema.add(jMenuItemRentar);

        jMenuBarDeLaInterfaz.add(jMenuCliente);
        jMenuBarDeLaInterfaz.add(jMenuSistema);
        setJMenuBar(jMenuBarDeLaInterfaz);
    }

    public void setActionListener(Controller theController) {

        jMenuSistema.addActionListener(theController);
        jMenuCliente.addActionListener(theController);
        jButtonAnterior.addActionListener(theController);
        jButtonSiguiente.addActionListener(theController);
        jMenuItemRentar.addActionListener(theController);
        jMenuItemVerAdeudo.addActionListener(theController);
        jMenuItemGuardarInformacion.addActionListener(theController);
        jMenuItemNuevoCliente.addActionListener(theController);
        jMenuItemBorrarCliente.addActionListener(theController);
        jMenuItemModificarDatosDelCliente.addActionListener(theController);
        jMenuItemOrdenarEstructura.addActionListener(theController);
    }

    public void setText(String textField, String texto){

        switch(textField)
        {
            case "ID":
                jTextFieldID.setText(texto);
                break;

            case "Nombre":
                jTextFieldNombre.setText(texto);
                break;

            case "Dirección":
                jTextFieldDireccion.setText(texto);
                break;

            case "CP":
                jTextFieldCP.setText(texto);
                break;

            case "Tel":
                jTextFieldTel.setText(texto);
                break;

            case "Películas":
                jTextFieldPeliculas.setText(texto);

            default:
                break;
        }

    }

    public String getText(String textField){

        String texto = null;

        switch(textField)
        {
            case "ID":
                texto = jTextFieldID.getText();
                break;

            case "Nombre":
                texto = jTextFieldNombre.getText();
                break;

            case "Dirección":
                texto = jTextFieldDireccion.getText();
                break;

            case "CP":
                texto = jTextFieldCP.getText();
                break;

            case "Tel":
                texto = jTextFieldTel.getText();
                break;

            case "Películas":
                texto = jTextFieldPeliculas.getText();

            default:
                break;
        }

        return texto;
    }


}//Fin de clase Interfaz.
