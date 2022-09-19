package Snakegame;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class snakeWelcome implements KeyListener {

	protected static JProgressBar progressBar;
	protected static JFrame frame;
	protected static JLabel l1,l3;
	protected static JLabel number ;
	protected JButton Restart, Exit;
	protected JPanel buttonpanel;


	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//
//					snakeWelcome window = new snakeWelcome();
//
//					int x;
//
//		try {
//			for(x=0; x<=100;x++) {
//				snakeWelcome.progressBar.setValue(x);
//				Thread.sleep(65);
//				snakeWelcome.number.setText(Integer.toString(x)+" %");
//
//				if(x==100) {
//					window.frame.dispose();
//				}
//			}
//
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//
//	}

	/**
	 * Create the application.
	 */
	public snakeWelcome() {

		frame = new JFrame();
		frame.setSize(630,600);
		frame.setUndecorated(true);
		frame.setLocation(470,120);
		frame.getContentPane().setBackground(Color.green);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		
		JPanel p2 = new JPanel();
		p2.setBounds(0, 0, 630, 480);
		p2.setBorder(BorderFactory.createLineBorder(Color.magenta,7,true));
		p2.setBackground(new Color(0,0,0,0));
		p2.setLayout(null);
		
	    progressBar = new JProgressBar();
		progressBar.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		progressBar.setForeground(Color.ORANGE);
		progressBar.setBackground(Color.CYAN);
		progressBar.setBounds(75, 439, 311, 20);
		progressBar.setVisible(false);

		l3 = new JLabel();
		l3.setText("Press Space to Continue.");
		//l3.setText(l3.getText()+"heyy");
		l3.setFont(new Font("HP Simplified Light", Font.BOLD | Font.ITALIC, 20));
		l3.setBorder(new LineBorder(Color.yellow, 7, true));
		l3.setBackground(Color.pink);
		l3.setForeground(Color.BLACK);
		l3.setBounds(0, 480, 627, 120);

		frame.getContentPane().add(l3);

		number = new JLabel();
		number.setHorizontalAlignment(SwingConstants.CENTER);
		number.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		number.setForeground(Color.blue);
		number.setBackground(Color.blue);
		number.setBounds(0, 0, 5, 5);
		number.setVisible(true);


		p2.add(progressBar);
		p2.add(number);
		frame.add(p2);
		
		l1 = new JLabel();
		l1.setForeground(Color.WHITE);
		l1.setIcon(new ImageIcon(getClass().getResource("home.gif")));
	//	l1.setIcon(new ImageIcon(getClass().getResource("firstprize.gif")));
	//	l1.setIcon(new ImageIcon(getClass().getResource("loose.gif")));

		l1.setMinimumSize(new Dimension(630, 480));
		l1.setMaximumSize(new Dimension(630, 480));
		l1.setBounds(new Rectangle(0, 0, 630, 480));
		l1.setBackground(new Color(0, 0, 0));
		l1.setVisible(true);
		l1.setBorder(new LineBorder(new Color(255, 0, 255), 6, true));

		p2.add(l1);

        buttonpanel = new JPanel();
        buttonpanel.setBorder(BorderFactory.createLineBorder(Color.black, 5, true));
      //  buttonpanel.setBackground(new Color(0,0,0,0));
		buttonpanel.setBackground(Color.black);
        buttonpanel.setBounds(0,390,625,90);

		frame.addKeyListener(this);
		frame.setFocusable(true);
		frame.setFocusTraversalKeysEnabled(true);
	}


	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE){

			snakeWelcome.frame.dispose();

			Close window = new Close();
			window.frame.setVisible(true);


		}
	}


}
