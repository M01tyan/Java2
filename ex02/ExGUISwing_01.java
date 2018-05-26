import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ExGUISwing_01 extends JFrame{
  ExGUISwing_01(){
    super("ExGUISwing_01");
    setSize(355, 145);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void setVisible(){

  }

  public static void main(String argv[]){
    ExGUISwing_01 swing = new ExGUISwing_01();
    swing.setVisible(true);
  }
}
