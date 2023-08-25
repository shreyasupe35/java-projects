package swinglearn;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class MyFrame extends JFrame implements ActionListener{
	private Container c;
	private JLabel l1,l2;
	private JTextField t1,t2;
	private JButton add,sub,mul,div;
	private JLabel res;
	MyFrame(){
		setTitle("calculator");
		setBounds(100,100,300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		c=getContentPane();
		c.setLayout(null);
		l1=new JLabel("FIRST NUMBER");
		l1.setBounds(10,20,100,20);
		c.add(l1);
		
		t1=new JTextField();
		t1.setBounds(120,20,100,20);
		c.add(t1);
		
		
		l2=new JLabel("SECOND  NUMBER");
		l2.setBounds(10,50,100,20);
		c.add(l2);
		
		t2=new JTextField();
		t2.setBounds(120,50,100,20);
		c.add(t2);
		
		add=new JButton("+");
		add.setBounds(10,80,50,30);
		c.add(add);
		
		
		
		sub=new JButton("-");
		sub.setBounds(70,80,50,30);
		c.add(sub);
		
		
		mul=new JButton("*");
		mul.setBounds(130,80,50,30);
		c.add(mul);
		
		
		div=new JButton("/");
		div.setBounds(190,80,50,30);
		c.add(div);
		
		
		res=new JLabel("result");
		res.setBounds(10,120,150,20);
		c.add(res);
		
		add.addActionListener(this);
		sub.addActionListener(this);
		mul.addActionListener(this);
		div.addActionListener(this);
		
		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		try {
		// TODO Auto-generated method stub
		if(e.getSource()==add) {
			int a=Integer.parseInt(t1.getText());
			int b=Integer.parseInt(t2.getText());
			int c=a+b;
			res.setText("RESULT: "+c);
		}
		
		
		if(e.getSource()==sub) {
			int a=Integer.parseInt(t1.getText());
			int b=Integer.parseInt(t2.getText());
			int c=a-b;
			res.setText("RESULT: "+c);
		}
		if(e.getSource()==mul) {
			int a=Integer.parseInt(t1.getText());
			int b=Integer.parseInt(t2.getText());
			int c=a*b;
			res.setText("RESULT: "+c);
		}
		
		if(e.getSource()==div) {
			int a=Integer.parseInt(t1.getText());
			int b=Integer.parseInt(t2.getText());
			int c=a/b;
			res.setText("RESULT: "+c);
		}
		}catch(NumberFormatException e1) {
			res.setText("please enter the integer value");
		}
		catch(ArithmeticException e2) {
			res.setText("can not divide by zero");
		}
	}
}

public class calulator {
	public static void main(String args[]) {
		MyFrame f=new MyFrame();
	}

}
