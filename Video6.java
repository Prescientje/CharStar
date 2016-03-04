package arendpeter;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class Video6 extends JFrame {

	JPanel pan = new JPanel();
	JToolBar tb = new JToolBar();
	JTextArea ta = new JTextArea(20, 20);
	JScrollPane sp = new JScrollPane(ta,
			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JButton open = new JButton("Open");
	JButton encrypt = new JButton("Encrypt");
	JButton decrypt = new JButton("Decrypt");
	JButton save = new JButton("Save");
	JFileChooser fc = new JFileChooser();
	String fname = "";

	public static void main(String[] args) {
		new Video6();
	}

	public Video6() {
		super("Encrypted Text Editor");
		setSize(800, 1000);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pan.setLayout(new BorderLayout());
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openFile();
			}
		});
		encrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				encryptText();
			}
		});
		decrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				decryptText();
			}
		});
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveFile();
			}
		});
		tb.add(open);
		tb.add(encrypt);
		tb.add(decrypt);
		tb.add(save);
		pan.add(tb, BorderLayout.NORTH);
		pan.add(sp, BorderLayout.CENTER);
		add(pan);
		setVisible(true);
	}

	void openFile() {
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int v = fc.showOpenDialog(Video6.this);
		if (v == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			fname = file.getName().substring(0, file.getName().length()-4);
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader(file));
				StringBuilder sb = new StringBuilder();
				String line = reader.readLine();
				while (line != null) {
					sb.append(line + "\n");
					line = reader.readLine();
				}
				ta.setText(sb.toString());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	void encryptText() {
		String data = ta.getText();
		StringBuilder sb = new StringBuilder();
		int len = data.length();
		for (int i = 0; i < len; i++) {
			char c = data.charAt(i);
			c += 5;
			sb.append(c);
		}
		ta.setText(sb.toString());
	}

	void decryptText() {
		String data = ta.getText();
		StringBuilder sb = new StringBuilder();
		int len = data.length();
		for (int i = 0; i < len; i++) {
			char c = data.charAt(i);
			c -= 5;
			sb.append(c);
		}
		ta.setText(sb.toString());
	}

	void saveFile() {
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int v = fc.showSaveDialog(Video6.this);
		if (v == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			try {
				PrintWriter writer = new PrintWriter(new File(file, fname
						+ "-enc.txt"));
				writer.write(ta.getText());
				writer.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	}
}