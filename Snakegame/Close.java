package Snakegame;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Close {

	protected static JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//
//		Close window = new Close();
//		window.frame.setVisible(true);
//
//	}

	/**
	 * Create the application.
	 */
	public Close() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setSize( 471, 411);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel mainpanel = new JPanel();
		mainpanel.setBackground(new Color(51, 255, 255));
		mainpanel.setBounds(0, 0, 471, 411);
		mainpanel.setBorder(new LineBorder(new Color(255, 255, 0), 6, true));
		frame.getContentPane().add(mainpanel);
		mainpanel.setLayout(null);
		
		JLabel l1 = new JLabel("");
		l1.setIcon(new ImageIcon("E:\\Java Programs\\Snakegame\\jer.gif"));
		l1.setBackground(Color.WHITE);
		l1.setBorder(new LineBorder(new Color(255, 0, 0), 9, true));
		l1.setBounds(67, 21, 500, 356);
		//mainpanel.add(l1);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				System.exit(0);
			}
		});
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(255, 255, 0));
		btnNewButton.setBorder(new LineBorder(new Color(255, 0, 0), 5, true));
		btnNewButton.setBounds(57, 320, 128, 40);
		mainpanel.add(btnNewButton);
		
		JButton btnRestart = new JButton("Restart");
		btnRestart.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				SnakeGame game = new SnakeGame();
//				mainboard bb = new mainboard();
				mainboard.gameover= false;
				mainboard.ReleaseGame=false;
				mainboard.snakelength =4;
				mainboard.score=0;
				mainboard.leftD=false;
				mainboard.rightD=true;
				mainboard.upD = false;
				mainboard.downD= false;
				mainboard.x[0] = 100;
				mainboard.y[0] = 50;
				mainboard.x[1] = 75;
				mainboard.y[1] = 50;
				mainboard.x[2] = 50;
				mainboard.y[2] = 50;
				mainboard.x[3] = 25;
				mainboard.y[3] = 50;
				mainboard.Enemypos();
				SimpleAudioPlayer.filePath = "E:\\Java Programs\\Snakegame\\intro4.wav";
//				mainboard.t.start();
//				new mainboard().repaint();
				Close.frame.dispose();
			}
		});
		btnRestart.setForeground(new Color(255, 0, 0));
		btnRestart.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnRestart.setBackground(new Color(255, 255, 0));
		btnRestart.setBorder(new LineBorder(new Color(255, 0, 0), 5));
		btnRestart.setBounds(294, 320, 128, 40);
		mainpanel.add(btnRestart);
		
		JLabel l2 = new JLabel("");
		l2.setIcon(new ImageIcon("E:\\Java Programs\\Snakegame\\l7.gif"));
		l2.setBounds(76, 10, 300, 300);
		mainpanel.add(l2);
	}
}
