package Modelo;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;

public class ConexionGmail {

    private static String emailFrom = "tecazuaynoreply@gmail.com";
    private static String passFrom = "ndzodvgdeqbrrguw";
    private String emailTo;
    private String encabezado;
    private String contenido;
    private Properties mProperties;
    private Session mSession;
    private MimeMessage mCorreo;

    private void createEmail(Cliente cliente, viaje_MD viaje, Camionero camionero) {
        mProperties  = new Properties();
        emailTo = cliente.getCorreo();
        encabezado = "AVISO DE ENVÍO DE PAQUETE";
        contenido = "Estimado "+ cliente.getNombre() + " " + cliente.getApellido() + ",\n"
                + "\n"
                + "Es un placer saludarte. Este correo electrónico es para informarte "
                + "que tienes un paquete que ha sido enviado en la siguiente fecha "+ viaje.getFecha_conduccion() + ".\n"
                + "\n"
                + "El paquete es llevado por " + camionero.getNombre() + " " + camionero.getApellido() + ".\n"
                + "\n"
                + "Por favor, dirígete al punto de entrega para reclamar tu paquete. Asegúrate de llevar una identificación válida para verificar tu identidad.\n"
                + "\n"
                + "Si tienes alguna pregunta adicional, no dudes en ponerte en contacto con nosotros.\n"
                + "\n"
                + "Gracias por elegirnos como tu servicio de entrega de paquetes.\n"
                + "\n"
                + "Atentamente,\n"
                + "Empresa Española";
        
        mProperties.put("mail.smtp.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user", emailFrom);
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");
        
        mSession = Session.getDefaultInstance(mProperties);
        
        mCorreo = new MimeMessage(mSession);
        try {
            mCorreo.setFrom(new InternetAddress(emailFrom));
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            mCorreo.setSubject(encabezado);
            mCorreo.setText(contenido, "ISO-8859-1", "html");
        } catch (AddressException ex) {
            Logger.getLogger(ConexionGmail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(ConexionGmail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sendEmail() {
        try {
            Transport mTransport = mSession.getTransport("smtp");
            mTransport.connect(emailFrom, passFrom);
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
            mTransport.close();
            
            JOptionPane.showMessageDialog(null, "SE HA ENVIADO UN CORREO AVISANDO AL USUARIO DEL ENVIO");
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(ConexionGmail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(ConexionGmail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enviarCorreo(Cliente cliente, viaje_MD viaje, Camionero camionero){
        createEmail(cliente, viaje, camionero);
        sendEmail();
    }
}
