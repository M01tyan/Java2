import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ExGUISwing_03 extends ExGUISwing_02 implements ActionListener{
  private JLabel mode = new JLabel("");
  private int pushMode = 0;
  private int cnt[] = {0, 0, 0};
  private String am[] = {"594 kHz", "954 kHz", "1134kHz", "1242kHz"};
  private String fm[] = {"76.1 MHz", "80.0 MHz", "81.3 MHz", "82.5 MHz"};
  private String cd[] = {"Track 1/20", "Track 2/20", "Track 3/20", "Track 4/20", "Track 5/20",
                         "Track 6/20", "Track 7/20", "Track 8/20", "Track 9/20", "Track 10/20",
                         "Track 11/20", "Track 12/20", "Track 13/20", "Track 14/20", "Track 15/20",
                         "Track 16/20", "Track 17/20", "Track 18/20", "Track 19/20", "Track 20/20"};
  ExGUISwing_03(){
    mode.setBounds(10, 5, 30, 30);
    panel.add(mode);
    for(int i=0; i<6; i++){
      button[i].addActionListener(this);
      if(i == 0 || i == 4 || i == 5)
        button[i].setEnabled(false);
    }
  }

  public void actionPerformed(ActionEvent e){
    Object o = e.getSource();

    if(o == button[0]){
      mode.setText("");
      label.setText("Power off");
      button[0].setEnabled(false);
      button[4].setEnabled(false);
      button[5].setEnabled(false);
    } else if(o == button[1]){
      pushMode = 0;
      mode.setText("AM");
      label.setText(am[cnt[pushMode]]);
      button[0].setEnabled(true);
      button[4].setEnabled(true);
      button[5].setEnabled(true);
    } else if(o == button[2]){
      pushMode = 1;
      mode.setText("FM");
      label.setText(fm[cnt[pushMode]]);
      button[0].setEnabled(true);
      button[4].setEnabled(true);
      button[5].setEnabled(true);
    } else if(o == button[3]){
      pushMode = 2;
      mode.setText("");
      label.setText(cd[cnt[pushMode]]);
      button[0].setEnabled(true);
      button[4].setEnabled(true);
      button[5].setEnabled(true);
    } else if(o == button[4]){
      button[5].setEnabled(true);
      cnt[pushMode]++;
      if(pushMode == 0){
        label.setText(am[cnt[pushMode]]);
      } else if(pushMode == 1){
        label.setText(fm[cnt[pushMode]]);
      } else {
        label.setText(cd[cnt[pushMode]]);
      }
    } else if(o == button[5]){
      button[4].setEnabled(true);
      cnt[pushMode]--;
      if(pushMode == 0){
        label.setText(am[cnt[pushMode]]);
      } else if(pushMode == 1){
        label.setText(fm[cnt[pushMode]]);
      } else {
        label.setText(cd[cnt[pushMode]]);
      }
    }

    if(pushMode == 0 || pushMode == 1){
      if(cnt[pushMode] == 3){
        button[4].setEnabled(false);
      }
    } else if(pushMode == 2){
      if(cnt[pushMode] == 19){
        button[4].setEnabled(false);
      }
    }
    if(cnt[pushMode] == 0){
      button[5].setEnabled(false);
    }
  }

  public static void main(String argv[]){
    ExGUISwing_03 swing = new ExGUISwing_03();
    swing.setVisible(true);
  }
}
