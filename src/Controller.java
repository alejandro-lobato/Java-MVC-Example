
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public interface Controller extends ActionListener
{
    public Object obtieneDatoDelModel(int indice);
    public Object obtieneDatoDelView();
    public void actualizaElView();
    public void solicitaActualizacionDelModel(String accion);
    public void actionPerformed(ActionEvent evento);

}