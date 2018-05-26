import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class ExGUIAWT_03 extends ExGUIAWT_02 implements MouseListener, MouseMotionListener{
    private int x_position;

    public void init(){
      super.init();
      addMouseListener(this);
      addMouseMotionListener(this);
    }

    public void mousePressed(MouseEvent me){
      x_position = me.getX();
    }

    public void mouseDragged(MouseEvent me){
      if(x_position > me.getX()){
        counter.setText(String.valueOf(--number));
      }
      if(x_position < me.getX()){
        counter.setText(String.valueOf(++number));
      }
    }

    public void mouseClicked(MouseEvent me){}
    public void mouseEntered(MouseEvent me){}
    public void mouseExited(MouseEvent me){}
    public void mouseReleased(MouseEvent me){}
    public void mouseMoved(MouseEvent me){}
}
