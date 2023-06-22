package Controlador;

import Vista.*;
import Modelo.*;

/**
 *
 * @author HP
 */
public class ControladorPrincipal {

    VistaPrincipal vp;

    public ControladorPrincipal(VistaPrincipal vp) {
        this.vp = vp;
        vp.setLocationRelativeTo(null);
        vp.setVisible(true);
    }

    public void IniciaControlVP() {
        vp.getBtnCamion().addActionListener(l -> CrudCamion());
        vp.getBtnTipoCamion().addActionListener(l -> CrudTipoCamion());
        vp.getBtnCamionero().addActionListener(l -> CrudClienteCamionero(1));
        vp.getBtnCliente().addActionListener(l -> CrudClienteCamionero(2));
        vp.getBtnPaquete().addActionListener(l->iniciarVistaPaquete());
        vp.getBtnProvincia().addActionListener(l->iniciarVistaProvincia());
        vp.getBtnPoblacion().addActionListener(l ->iniciarVistaPoblacion());
        vp.getBtnViaje().addActionListener(l -> CrudEnvio());
    }

    public void CrudCamion() {
        VistaCamion vc = new VistaCamion();
        ModeloCamion md = new ModeloCamion();
        ModeloTipoCam mtp = new ModeloTipoCam();
        VistaTipoCamion vtc = new VistaTipoCamion();
        
        vp.getdeskoptMain().add(vc);
        
        ControladorCamion cc = new ControladorCamion(md, vc, mtp, vtc);
        cc.IniciaControl();
    }
    
    public void CrudTipoCamion() {
        VistaTipoCamion vc = new VistaTipoCamion();
        ModeloTipoCam mtp = new ModeloTipoCam();
        
        vp.getdeskoptMain().add(vc);
        
        ControladorTipoCam cc = new ControladorTipoCam(vc, mtp);
        cc.IniciaControl();
    }
    
    public void CrudCamionero() {
        VistaPersona vper = new VistaPersona();
        ModeloCamionero mc = new ModeloCamionero();

        vp.getdeskoptMain().add(vper);

        ControladorCamionero cc = new ControladorCamionero(mc, vper);
        cc.iniciaControl();
    }

    private void CrudClienteCamionero(int ce) {
        String title;
        VistaPersona vper = new VistaPersona();
        ModeloCamionero mc = new ModeloCamionero();
        ModeloCliente mcli = new ModeloCliente();
        
        if (ce == 1) {
            title = "Crud Camionero";
            vper.setName("camionero");
        } else {
            title = "Crud Cliente";
            vper.setName("cliente");
        }
        
        vper.setTitle(title);
        
        vp.getdeskoptMain().add(vper);

        if(vper.getName().equals("camionero")){
            ControladorCamionero cc = new ControladorCamionero(mc, vper);
            cc.iniciaControl();
        }else if(vper.getName().equals("cliente")){
            ControladorCliente ccli = new ControladorCliente(mcli, vper);
            ccli.iniciaControl();
        }
    }
    
    private void iniciarVistaPaquete(){
        VistaPaquete vista=new VistaPaquete();
        ModeloPaquete modelo=new ModeloPaquete();
        
        vp.getdeskoptMain().add(vista);
        
        vista.setVisible(true);
        ControladorPaquete control=new ControladorPaquete(modelo,vista);
        control.iniciarControl();
    }
    
    private void iniciarVistaProvincia(){
        VistaProvincia vista=new VistaProvincia();
        ModeloProvincia modelo=new ModeloProvincia();
        
        vp.getdeskoptMain().add(vista);
        
        vista.setVisible(true);
        ControladorProvincia control=new ControladorProvincia(modelo,vista);
        control.iniciarControl();
    }
    
    private void iniciarVistaPoblacion(){
        VistaPoblacion vista=new VistaPoblacion();
        ModeloPoblacion modelo=new ModeloPoblacion();
        
        vp.getdeskoptMain().add(vista);
        
        vista.setVisible(true);
        ControladorPoblacion control=new ControladorPoblacion(modelo,vista);
        control.iniciarControl();
    }
    
    private void CrudEnvio(){
        VistaViaje vista=new VistaViaje();
        viaje_BD modelo=new viaje_BD();
        
        vp.getdeskoptMain().add(vista);
        
        vista.setVisible(true);
        C_viaje control=new C_viaje(modelo,vista);
        control.iniciarControl();
    }
}
