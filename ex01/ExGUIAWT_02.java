import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class ExGUIAWT_02 extends ExGUIAWT_01 implements ActionListener{
    private Button plus_button = new Button("Plus");
    private Button minus_button = new Button("Minus");
    protected int number = 0;
    protected Label counter = new Label("0");

    public void init(){
      plus_button.addActionListener(this);
      minus_button.addActionListener(this);
	    add(plus_button);
      add(counter);
      add(minus_button);
    }

    public void actionPerformed(ActionEvent e){
      Object o = e.getSource();

      if(o == plus_button){
        counter.setText(String.valueOf(++number));
      }
      if(o == minus_button){
        counter.setText(String.valueOf(--number));
      }
    }
}
