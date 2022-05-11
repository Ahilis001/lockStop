/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.jf;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Ahilis
 */
public class JfSat extends JFrame{

    public JfSat() {
    }
    
    public static void generirajObrazac(){

        JfSat jfS = new JfSat();
        jfS.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JTextField jTextField = new JTextField();
        jTextField.setEnabled(false);
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy. HH:mm");

        jfS.add(jTextField);

        jfS.setUndecorated(true);
        jfS.setVisible(true);

        while (true) {   
            try {             
            Robot robot = new Robot();

            Point point = MouseInfo.getPointerInfo().getLocation();
            robot.mouseMove(point.x, point.y);

            jTextField.setText(formatter.format(new Date(System.currentTimeMillis())));


            jfS.revalidate();
            jfS.pack();

            Thread.sleep(30*1000);
            } catch (Exception ex) {
                Logger.getLogger(JfSat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
    }
    
}
