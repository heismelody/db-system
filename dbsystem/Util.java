package dbsystem;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Util extends JFrame{
	
	public static Date getFirstDayOfWeek(Date date) {
		  Calendar c = new GregorianCalendar();
		  c.setFirstDayOfWeek(Calendar.MONDAY);
		  c.setTime(date);
		  c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
		  return c.getTime ();
		  } 
	
	public void  exit() {
	    Object[] options = { "ȷ��", "ȡ��" };
	    JOptionPane pane2 = new JOptionPane("�����˳���?", JOptionPane.QUESTION_MESSAGE,
	        JOptionPane.YES_NO_OPTION, null, options, options[1]);
	    JDialog dialog = pane2.createDialog(this, "����");
	    dialog.setVisible(true);
	    Object selectedValue = pane2.getValue();
	    if (selectedValue == null || selectedValue == options[1]) {
	      setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // ����ǹؼ�
	    } else if (selectedValue == options[0]) {
	      setDefaultCloseOperation(EXIT_ON_CLOSE);
	    }
	  }
	
	public static void messageDialog(String message,int flag){
				JDialog newFrame =new JDialog();
				if(flag>4){System.out.println("flag must less than 5");}
				else
					switch(flag){
					case 1:
						JOptionPane.showMessageDialog(newFrame.getContentPane(),
						 message,"��Ϣ��ʾ��!", JOptionPane.INFORMATION_MESSAGE);
						break;
					case 2:
						JOptionPane.showMessageDialog(newFrame.getContentPane(),
						message,"������ʾ��!",  JOptionPane.WARNING_MESSAGE);
						break;
					case 3:
						JOptionPane.showMessageDialog(newFrame.getContentPane(),
						 message,"������ʾ��!", JOptionPane.ERROR_MESSAGE);
						break;
					case 4:
						JOptionPane.showMessageDialog(newFrame.getContentPane(),
						message,"ѯ����ʾ��!", JOptionPane.QUESTION_MESSAGE);
					}
	}
	
	
}
