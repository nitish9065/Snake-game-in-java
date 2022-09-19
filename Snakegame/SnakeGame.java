package Snakegame;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SnakeGame  {

	protected static JFrame frame;

	public static void main(String[] args) {

		int x;
		Splash window = new Splash();
		try{
		//	SimpleAudioPlayer.filePath = "E:\\Java Programs\\Snakegame\\intro2.wav";
		//	SimpleAudioPlayer.filePath = "E:\\Java Programs\\Snakegame\\intro1.wav";
		//	SimpleAudioPlayer.filePath = "E:\\Java Programs\\Snakegame\\intro3.wav";
			SimpleAudioPlayer.filePath = "E:\\Java Programs\\Snakegame\\intro4.wav";
		//	SimpleAudioPlayer.filePath = "E:\\Java Programs\\Snakegame\\intro5.wav";

			SimpleAudioPlayer audioPlayer = new SimpleAudioPlayer();
            audioPlayer.play();

		}catch (Exception e){e.printStackTrace();}
		window.frame.setVisible(true);

		try {
			for(x=0; x<=100;x++) {
				Splash.progressBar.setValue(x);
				Thread.sleep(50);
				Splash.number.setText(Integer.toString(x)+" %");

				if(x==100) {
					window.frame.dispose();
					SnakeGame game = new SnakeGame();
				}
			}

		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Create the application.
	 */
	public SnakeGame() {

		try {
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			//  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			  UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			//  UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {

		frame = new JFrame();
		frame.setTitle("Snake Game ");
		frame.setBackground(Color.magenta);
		frame.getContentPane().setName("mainpanel");
		frame.getContentPane().setMinimumSize(new Dimension(800, 600));
		frame.getContentPane().setMaximumSize(new Dimension(800, 600));

		Image icon =Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png"));
		frame.setIconImage(icon);
		
		JPanel p1 = new JPanel();
		p1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		frame.getContentPane().add(p1, BorderLayout.CENTER);
		p1.setLayout(null);
		
		JPanel p2intro = new JPanel();
		p2intro.setForeground(new Color(255, 255, 0));
		p2intro.setBackground(new Color(51, 102, 102));
		//p2intro.setBackground(new Color(0,0,0,0));
		p2intro.setBorder(new LineBorder(new Color(0, 255, 255), 9, true));
		p2intro.setBounds(0, 0, 800, 93);
		p1.add(p2intro);
		p2intro.setLayout(null);
		
		JLabel snakegif_1 = new JLabel("");
		snakegif_1.setIcon(new ImageIcon(getClass().getResource("animation_200_kr3t5i8b.gif")));
		snakegif_1.setBounds(new Rectangle(562, 3, 235, 87));
		snakegif_1.setBackground(new Color(0, 0, 0, 0));
		snakegif_1.setBounds(10, 10, 235, 73);
		p2intro.add(snakegif_1);
		
		JLabel snakegif = new JLabel("");
		snakegif.setIcon(new ImageIcon(getClass().getResource("animation_200_kr3t5i8b.gif")));
		snakegif.setBackground(new Color(0,0,0,0));
		snakegif.setBounds(new Rectangle(562, 3, 235, 87));
		p2intro.add(snakegif);
		
		JLabel gametitle = new JLabel("SNAKE GAME");
		gametitle.setForeground(new Color(255, 255, 0));
		gametitle.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 41));
		gametitle.setBounds(255, 20, 273, 63);
		p2intro.add(gametitle);
		

		p1.add(new mainboard());
		
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setSize(802, 602);
        frame.setLocation(350,120);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

class mainboard extends JPanel implements ActionListener, KeyListener{


    ImageIcon image1, image2, image3;
    Image body, head, enemy;
   public  static boolean ReleaseGame = false;
   public static boolean gameover = false;
	public  static int score =0;

	 public static boolean leftD = false, rightD = true, upD = false, downD = false;

	 public static  int enemyx[] = { 25,50 ,75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600 ,625 ,650, 675, 700, 725, 750};
	 public static int enemyy[] = {75, 100, 125, 150 ,175 ,200 ,225 ,250 ,275 ,300,325 ,350 ,375 ,400 ,425 ,450 };

	 public static Random random = new Random();
	public  static  int randomposx =0, randomposy=0;

	public  static int x[]= new int[600];
	public  static int y[]= new int[600];
	public  static int snakelength = 4;
	 public static Timer t;

    mainboard() {

			x[0] = 100;
			y[0] = 50;
			x[1] = 75;
			y[1] = 50;
			x[2] = 50;
			y[2] = 50;
			x[3] = 25;
			y[3] = 50;


			image1 = new ImageIcon(getClass().getResource("body_snake.png"));
			body = image1.getImage();

			image2 = new ImageIcon(getClass().getResource("head_snake.png"));
			head = image2.getImage();

			image3 = new ImageIcon(getClass().getResource("rat_mouse.png"));
			enemy = image3.getImage();

		 if(score<=100){
			 t = new Timer(75, this);
			 t.start();
		 }

		 else if(score<=200 && score>100){
			 t = new Timer(50, this);
			 t.start();
		 }
		 else if(score<=300 && score>200){
			 t = new Timer(40, this);
			 t.start();
		 }
		 else if(score<=400 && score>300){
			 t = new Timer(30, this);
			 t.start();
		 }
		 else if(score>400 || score>=500){
			 t = new Timer(20, this);
			 t.start();
		 }



		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);

		Enemypos();

		setBackground(new Color(0, 0, 51));
		setBorder(new LineBorder(new Color(255, 255, 0), 6, true));
        setBounds(0, 93, 800, 509);

    }
     static void Enemypos(){

		randomposx = enemyx[random.nextInt(30)];
		randomposy = enemyy[random.nextInt(16)];

		for(int i= snakelength-1; i>=0; i--){
			if((x[i] == randomposx) && (y[i] == randomposy)) {
				Enemypos();
			}
		}

	}
	public void checkenemy(){

		if((x[0] == randomposx) && (y[0] == randomposy)){
			Enemypos();
			snakelength++;
			score+=5;
		}
	}
	public void Result() {

		for (int z = snakelength-1; z >= 0; z--) {
			if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
				t.stop();
				ReleaseGame = false;
				gameover = true;

				try {
					Thread.sleep(2000);
					resultframe();
				}
				catch (Exception ee){
					ee.printStackTrace();
				}
			}
		}
	}
	public void resultframe(){

    	SnakeGame.frame.dispose();
		snakeWelcome window = new snakeWelcome();

		if(score<=200) {

			snakeWelcome.l1.setIcon(new ImageIcon(getClass().getResource("loose.gif")));
			snakeWelcome.frame.setVisible(true);
			snakeWelcome.l3.setText("<html>"+"OOPS!! You were good Score : "+score+"<br><br>" + snakeWelcome.l3.getText()+"<html>");

		}

		else if(score>200 || score <=500) {

			snakeWelcome.l1.setIcon(new ImageIcon(getClass().getResource("firstprize.gif")));
			snakeWelcome.frame.setVisible(true);
			snakeWelcome.l3.setText("<html>"+"You Nailed it!!  Score : " +score+ "<br><br>" +snakeWelcome.l3.getText()+"<html>");

		}

//		g.setColor(Color.yellow);
//		g.setFont(new Font("Arial", Font.BOLD, 30));
//		g.drawString("Game Over !! Press Space to start",50,200);


	}



	@Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.drawImage(enemy, randomposx, randomposy,this);

        for(int i=0;i<snakelength; i++){

            if(i==0){
                g.drawImage(head,x[i],y[i], this);
            }
            else {
				g.drawImage(body, x[i], y[i], this);
			}
        }
                  if(score>=100) {
					  if (score % 100 == 0) {
						  g.setColor(Color.WHITE);
						  g.setFont(new Font("Arial", Font.BOLD, 20));
						  g.drawString("You Crossed a Score of " + score, 20, 480);
						  g.dispose();
					  }
				  }

    }

		@Override
	public void actionPerformed(ActionEvent ev) {

		if (ReleaseGame) {

			for (int i = snakelength; i > 0; i--) {
				x[i] = x[i - 1];
				y[i] = y[i - 1];
			}
			if(rightD) {
				x[0] = x[0]+25;
			}
			if(leftD) {
				x[0] = x[0] - 25;
			}
			if(upD) {
				y[0] = y[0] - 25;
			}
			if(downD) {
				y[0] = y[0] + 25;
			}

			if(x[0]>800){
				x[0]=0;
			}if(x[0]<0){
				x[0]=800;
			}
			if(y[0]>505){
				y[0]=0;
			}
			if(y[0]<0){
				y[0]=505;
			}


			checkenemy();
			Result();
		}
		repaint();


	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {

    	if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			ReleaseGame = true;
		}

		if(e.getKeyCode() == KeyEvent.VK_LEFT && (!rightD)){

			leftD = true;
			rightD = false;
			upD = false;
			downD = false;
		}

		if(e.getKeyCode() == KeyEvent.VK_RIGHT && (!leftD)){
			rightD = true;
			leftD = false;
			upD = false;
			downD = false;
		}

		if(e.getKeyCode() == KeyEvent.VK_UP && (!downD)){
			upD= true;
			leftD = false;
			downD = false;
			rightD = false;
		}

		if(e.getKeyCode() == KeyEvent.VK_DOWN && (!upD)){
			downD = true;
			upD = false;
			rightD = false;
			leftD = false;
		}
	}


}
