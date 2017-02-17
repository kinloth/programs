package Menu;
import agenda.*;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Agenda {    
    public static void main(String[] args) {
        
        JLogin jlogin = new JLogin();
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
	jlogin.setLocation((tela.width - jlogin.getSize().width)/2,(tela.height - jlogin.getSize().height)/2);
        jlogin.show();
                
    }    
}