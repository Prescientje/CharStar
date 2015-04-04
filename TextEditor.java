import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;

public class TextEditor extends JFrame{
	
	JPanel p = new JPanel();
	JToolBar tb = new JToolBar();
	JTextArea t = new JTextArea();
	JButton save = new JButton("Save");
	JButton open = new JButton("Open");
	
	public static void main(String args[]){
		new TextEditor();
	}

	public TextEditor(){
		super("CharStar");
		setSize(400,300);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		p.setLayout(new BorderLayout());
		
		tb.add(save);
		tb.add(open);
		p.add(tb, BorderLayout.NORTH);
		p.add(t, BorderLayout.CENTER);
		add(p);
		
		setVisible(true);
	}
}