package MVC_Main;
import Vista.*;
import Controlador.*;
/**
 *
 * @author HP
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VistaPrincipal vp = new VistaPrincipal();
        ControladorPrincipal cp = new ControladorPrincipal(vp);
        cp.IniciaControlVP();
    }
    
}
