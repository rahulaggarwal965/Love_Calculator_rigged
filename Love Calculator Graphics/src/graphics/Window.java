package graphics;
import java.awt.*;
import javax.swing.*;


public class Window extends JFrame {
	Window() {
		Display display = new Display(); 
		setTitle("Love Calculator by Ashwin & Rahul");
		setSize(800, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(display);
		setVisible(true);
		setResizable(false);
	}	
}