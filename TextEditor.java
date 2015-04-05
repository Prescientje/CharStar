import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import javax.swing.text.*;

public class TextEditor extends JFrame{
	
	JPanel p = new JPanel();
	JToolBar tb = new JToolBar();
	JTextArea t = new JTextArea();
	JButton save = new JButton("Save");
	JButton open = new JButton("Open");
	JScrollPane tscroll=new JScrollPane(t,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    	DefaultCaret caret = (DefaultCaret)t.getCaret();
	
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
		//textarea setup
		t.setLineWrap(true);
        	t.setWrapStyleWord(true);
        	caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        	p.add(tscroll, BorderLayout.CENTER);
		add(p);
		
		setVisible(true);
	}
}
