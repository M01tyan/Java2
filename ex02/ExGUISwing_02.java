import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.SwingConstants;

public class ExGUISwing_02 extends ExGUISwing_01{
    private String str[] = {"PW", "AM", "FM", "CD", "Up", "Down"};
    protected JButton button[] = new JButton[6];
    protected JPanel panel = new JPanel();
    protected JLabel label = new JLabel("Power off");
    private BevelBorder border = new BevelBorder(1);

  ExGUISwing_02(){
    super();
    Container container = this.getContentPane();
    //container,panel init
    container.setLayout(null);
    panel.setLayout(null);

    //button->word,size,location setting
    for(int i=0; i<6; i++){
	     button[i] = new JButton(str[i]);
	     button[i].setSize(70, 30);
	      if(i<3)
	        button[i].setLocation(0, 35*i+5);
	      else
	        button[i].setLocation(275, 35*(i-3)+5);
    }
    //panel size,location setting
    panel.setSize(200, 100);
    panel.setLocation(75, 2);
    //label location setting
    label.setBounds(25, 20, 300, 100);
    //panel frame setting
    panel.setBorder(border);
    //label size,thickness setting
    label.setFont(new Font(null, Font.BOLD, 30));
    //label color setting
    label.setForeground(new Color(0, 130, 00));


    //add button
    for(int i=0; i<6; i++)
	    container.add(button[i]);
    //add panel,label
    container.add(panel);
    panel.add(label);
  }

  public static void main(String argv[]){
    ExGUISwing_02 swing = new ExGUISwing_02();
    swing.setVisible(true);
  }
}
