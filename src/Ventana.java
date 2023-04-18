import javax.swing.JFrame;

import panamahitek.Arduino.PanamaHitek_Arduino;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*; 

public class Ventana extends JFrame{

    private int ancho = 400; 
    private int largo = 400;
    private JPanel p; 
    private JLabel e; 
    private JButton b,b1; 

    PanamaHitek_Arduino Arduino = new PanamaHitek_Arduino(); 

    public Ventana(){
        
        try {
            Arduino.arduinoTX("COM#", 9600);
        } catch (Exception e) {
            // TODO: handle exception
        }
        this.setSize(ancho, largo);
        this.setLocationRelativeTo(null);
        this.setTitle("Arduino");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        paneles(); 
    }
    public void paneles(){
        p = new JPanel(); 
        p.setLayout(null);
        this.getContentPane().add(p);
        etis(); 
        botones(); 
    }
    public void etis(){

      

    }
    public void botones(){
        b = new JButton("Encender"); 
        b.setBounds(150, 150, 120, 20);
        b.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Arduino.sendData("k");
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            
            }
            
        });
        p.add(b);
        
        b1 = new JButton(); 
        b1.setBounds(150, 250, 120, 20);
        b1.setText("apagar"); 
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Arduino.sendData("q");
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                
            }
            
        });
        p.add(b1); 

      

    }
    
}
