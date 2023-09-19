package notepad;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class About2 extends JFrame {
	public About2() {
		setBounds(100,100,600,400);
		setTitle("About Notepad Application");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		ImageIcon img=new ImageIcon("C:\\Users\\supes\\OneDrive\\Desktop\\download.png");
		setIconImage(img.getImage());
		JLabel l=new JLabel();
		l.setIcon(new ImageIcon("C:\\Users\\supes\\OneDrive\\Desktop\\do.png"));
		l.setBounds(100,50,80,80);
		add(l);
		JLabel l1=new JLabel("<html>Welcome to Notepad.Notepad is a text editor,</br> i.e., an app specialized in editing plain text.</br> It can edit text files </br>and compatible formats, such as batch files, INI files, and log files.</br> </html>");
		l1.setBounds(100,20,400,300);
		l1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
		add(l1);
		
		setVisible(true);
		
	}
}
