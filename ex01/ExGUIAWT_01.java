import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class ExGUIAWT_01 extends Applet{
    private int width = 400;
    private int height = 300;
    
    public void init(){
	setSize(width, height);
    }

    public void paint(Graphics g){
	g.setColor(Color.red);
	g.drawString("April 13, 2018", 150, 150);
	g.drawArc(100, 50, 200, 200, 0, 360);
    }
}
