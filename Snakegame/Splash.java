package Snakegame;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Splash {

	protected static JProgressBar progressBar;
	protected JFrame frame;
	protected static JLabel l1,l2,number ;


	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//
//		int x;
//					Splash window = new Splash();
//					window.frame.setVisible(true);
//
//					try {
//						for(x=0; x<=100;x++) {
//							Splash.progressBar.setValue(x);
//							Thread.sleep(90);
//							Splash.number.setText(Integer.toString(x)+" %");
//
//							if(x==100) {
//								window.frame.dispose();
//							}
//						}
//
//					}catch(Exception e) {
//						e.printStackTrace();
//					}
//
//
//	}
	
	/**
	 * Create the application.
	 */
	public Splash() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setSize( 645, 645);
		frame.setLocationRelativeTo(null);



		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel mainpanel = new JPanel();
		mainpanel.setBackground(Color.cyan);
//	mainpanel.setBackground(new Color(0,0,0,2));
		mainpanel.setForeground(Color.white);
		mainpanel.setSize(645,645);
		mainpanel.setBorder(new LineBorder(Color.red, 7,true));
		frame.getContentPane().add(mainpanel, BorderLayout.CENTER);
		mainpanel.setLayout(null);
		 
	    number = new JLabel();
	    number.setHorizontalAlignment(SwingConstants.CENTER);
	    number.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
	    number.setForeground(Color.black);
	    number.setBackground(Color.white);
	    number.setBounds(260, 559, 95, 33);
	    mainpanel.add(number);
		
		 progressBar = new JProgressBar();
		 progressBar.setBackground(Color.ORANGE);
		 progressBar.setAlignmentX(Component.CENTER_ALIGNMENT);
		 progressBar.setForeground(Color.red);
		 progressBar.setBounds(54, 590, 520, 30);
		 mainpanel.add(progressBar);
		
		l1 = new JLabel("");
		//l1.setHorizontalAlignment(SwingConstants.SOUTH);
		l1.setIcon(new ImageIcon("E:\\Java Programs\\Snakegame\\urwelcome.gif"));
		l1.setBackground(Color.white);
		l1.setForeground(Color.GREEN);
		l1.setBounds(21, 250, 640, 320);
		mainpanel.add(l1);

		l2 = new JLabel("");
		//l2.setHorizontalAlignment(SwingConstants.NORTH);
		l2.setIcon(new ImageIcon("E:\\Java Programs\\Snakegame\\star.gif"));
		l2.setBackground(Color.white);
		l2.setForeground(Color.GREEN);
		l2.setBounds(160, 30, 640, 320);
		mainpanel.add(l2);

		
		//frame.getContentPane().setBackground(Color.orange);
	}
}
