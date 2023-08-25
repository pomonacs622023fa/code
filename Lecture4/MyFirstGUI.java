import javax.swing.JFrame;

public class MyFirstGUI extends JFrame {

	public MyFirstGUI() {
		super("First Frame");
		setSize(500, 300);
		setLocation(100, 100);
		setVisible(true);
	}

	public static void main(String[] args) {
		MyFirstGUI mfgui = new MyFirstGUI();
		//mfgui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}