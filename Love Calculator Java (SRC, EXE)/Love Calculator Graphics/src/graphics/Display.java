package graphics;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Display extends JPanel implements ActionListener {
	Timer timer;
	JTextField input1;
	JTextField input2;
	JButton start;
	boolean flag = false;
	int result = 0;

	Display() {
		setLayout(null);
		addComponents();
	}

	public void initTimer() {
		timer = new Timer(10, this);
	}

	void drawTitle(Graphics2D g2d) {
		String title = "Love Calculator";
		Font titleFont = new Font("Edwardian Script ITC", Font.BOLD, 100);
		g2d.setFont(titleFont);
		FontMetrics fm = g2d.getFontMetrics(titleFont);
		fm.stringWidth(title);
		g2d.setColor(Color.GREEN);
		g2d.drawString(title, (800-fm.stringWidth(title))/2, fm.getHeight()-10);
		
		Font namesFont = new Font("Elephant", Font.BOLD, 30);
		g2d.setFont(namesFont);
		g2d.setColor(Color.MAGENTA);
		g2d.drawString("by Ashwin & Rahul", 160 , fm.getHeight()+40);
		
	}

	void addComponents() {
		input1 = new JTextField();
		input2 = new JTextField();
		start = new JButton();

		input1.setText("Enter Name 1");
		input1.setBounds(300, 600, 200, 40);
		input1.setFont(new Font("Century", Font.BOLD, 20));
		input1.addActionListener(this);

		input2.setText("Enter Name 2");
		input2.setBounds(300, 650, 200, 40);
		input2.setFont(new Font("Century", Font.BOLD, 20));
		input2.addActionListener(this);

		start.setText("Start");
		start.setBounds(300, 700, 200, 40);
		start.setFont(new Font("Century", Font.BOLD, 20));
		start.addActionListener(this);
		start.setBackground(Color.GREEN);

		add(input1);
		add(input2);
		add(start);

	}
	
	void removeComponents() {
		remove(input1);
		remove(input2);
		remove(start);
	}
	
	void drawResult(Graphics2D g2d) {
		Font resultFont = new Font("Elephant", Font.BOLD, 50);
		g2d.setFont(resultFont);
		g2d.setColor(Color.BLUE);
		g2d.drawString(result+"% Compatible!", 100, 500);
	}

	void drawDecorations(Graphics2D g2d) {
		 g2d.setColor(Color.red);
		 int[] xcoords = new int[4];
		 int[] ycoords = new int[4];
		 int shift = -100;
		 
		 xcoords[0] = 400;
		 ycoords[0] = 400 + shift;
		 
		 xcoords[1] = 460;
		 ycoords[1] = 460 + shift;
		 
		 xcoords[2] = 400;
		 ycoords[2] = 520 + shift;
		 
		 xcoords[3] = 340;
		 ycoords[3] = 460 + shift;
		 
		 Polygon diamond = new Polygon(xcoords,ycoords,4);
		 g2d.fillPolygon(diamond);
		 g2d.fillArc(330, 390 + shift, 85, 85, 45, 180);
		 g2d.fillArc(385, 390 + shift, 85, 85, -45, 180);
	   // g2d.fillOval(400, 400, 50, 50);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.BLACK);
		Graphics2D g2d = (Graphics2D) g;
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHints(rh);

		GradientPaint gp = new GradientPaint(0, 0, Color.pink, 900, 900, Color.red);
		g2d.setPaint(gp);
		g2d.fillRect(0, 0, 800, 800);


		drawTitle(g2d);
		drawDecorations(g2d);
		if(flag == true) {
			removeComponents();
			drawResult(g2d);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(start)) {
			flag = true;
			Project.writeNames(input1.getText(), input2.getText());
			Project.callPython();
			result = Project.getCompatibility();
		}
		repaint();
	}

}
