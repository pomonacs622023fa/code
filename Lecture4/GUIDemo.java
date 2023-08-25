import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUIDemo extends JFrame {
	public GUIDemo() {
		// Container cp = getContentPane();
		// cp.setLayout(new FlowLayout());
		// cp.add(new JLabel("Demo"));
		// cp.add(new JButton("Button"));
		JPanel mainPanel = new JPanel(new FlowLayout());
		mainPanel.add(new JLabel("Demo"));
		mainPanel.add(new JButton("Button"));
		setContentPane(mainPanel);
		setSize(500, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		GUIDemo gd = new GUIDemo();
		gd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
