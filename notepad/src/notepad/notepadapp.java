package notepad;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage.*;
import java.awt.print.PrinterException;
import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class notepadapp extends JFrame implements ActionListener{
	final String a[]= {"txt","text"};
	JMenuBar menubar=new JMenuBar();
	JMenu file=new JMenu("File");
	JMenu edit=new JMenu("Edit");
	JMenu help=new JMenu("help");
	JMenuItem New=new JMenuItem("New");
	JMenuItem open=new JMenuItem("open");
	JMenuItem savefile=new JMenuItem("Savefile");
	JMenuItem print=new JMenuItem("Print");
	JMenuItem exit=new JMenuItem("Exit");
	
	
	JMenuItem cut=new JMenuItem("cut");
	JMenuItem copy=new JMenuItem("copy");
	JMenuItem paste=new JMenuItem("paste");
	JMenuItem selectall=new JMenuItem("selectall");
	
	
	JMenuItem about=new JMenuItem( "about");
	
	JTextArea area=new JTextArea();
public notepadapp() {
	
	setTitle("Notepad");
	setBounds(100,100,500,600);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	ImageIcon img=new ImageIcon("C:\\Users\\supes\\OneDrive\\Desktop\\download.png");
	setIconImage(img.getImage());
	setJMenuBar(menubar);;
	menubar.add(file);
	menubar.add(edit);
	menubar.add(help);
	file.add(New);
	file.add(open);
	file.add(savefile);
	file.add(print);
	file.add(exit);
	
	edit.add(cut);
	edit.add(copy);
	edit.add(paste);
	edit.add(selectall);
	
	help.add(about);
	area.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
	JScrollPane pane=new JScrollPane(area);
	area.setLineWrap(true);
	pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	add(pane);
	New.addActionListener(this);
	open.addActionListener(this);
	savefile.addActionListener(this);
	print.addActionListener(this);
	exit.addActionListener(this);
	
	cut.addActionListener(this);
	copy.addActionListener(this);
	paste.addActionListener(this);
	selectall.addActionListener(this);
	
	
	about.addActionListener(this);
	
	New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK));
	open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_DOWN_MASK));
	savefile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK));
	print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_DOWN_MASK));
	exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,KeyEvent.CTRL_DOWN_MASK));
	
	cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_DOWN_MASK));
	copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_DOWN_MASK));
	paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_DOWN_MASK));
	selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_DOWN_MASK));
	
	
	about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,KeyEvent.CTRL_DOWN_MASK));
	
}
public static void main(String args[]) {
	try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }catch (Exception e) { }
	new notepadapp().setVisible(true);
}
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getActionCommand().equalsIgnoreCase("New")) {
	 area.setText(null);
	}
	else if(e.getActionCommand().equalsIgnoreCase("Open")) {
		JFileChooser fc=new JFileChooser();
		fc.setAcceptAllFileFilterUsed(false);
		fc.addChoosableFileFilter(new FileNameExtensionFilter("txt files only", a));
		int action=fc.showOpenDialog(null);
		if(action!=JFileChooser.APPROVE_OPTION) {
			return;
		}
		else {
			try {
				BufferedReader r=new BufferedReader(new FileReader(fc.getSelectedFile()));
				area.read(r,null);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	else if (e.getActionCommand().equalsIgnoreCase("savefile")) {
		JFileChooser fc=new JFileChooser();
		FileNameExtensionFilter tf=new FileNameExtensionFilter("only text file(.txt)",a);
		fc.setAcceptAllFileFilterUsed(false);
		fc.addChoosableFileFilter(tf);
		int action=fc.showSaveDialog(null);
		if (action!=JFileChooser.APPROVE_OPTION)
		{
			return;
		}
		else {
			String fn=fc.getSelectedFile().getAbsolutePath().toString();
			if(!fn.contains(".txt")) {
				fn+=".txt";
			try {
				BufferedWriter w=new BufferedWriter(new FileWriter(fn));
				area.write(w);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		}
	}
	else if(e.getActionCommand().equalsIgnoreCase("print")) {
		try {
			area.print();
		} catch (PrinterException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	else if(e.getActionCommand().equalsIgnoreCase("exit")) {
		System.exit(0);
		
	}
	else if (e.getActionCommand().equalsIgnoreCase("cut")) {
		area.cut();
	}
	else if (e.getActionCommand().equalsIgnoreCase("copy")) {
		area.copy();
	}
	else if (e.getActionCommand().equalsIgnoreCase("paste")) {
		area.paste();
	}
	else if((e.getActionCommand().equalsIgnoreCase("selectall"))) {
		area.selectAll();
	}
	else  if((e.getActionCommand().equalsIgnoreCase("about"))) {
		new About2().setVisible(true);
	}
}
}