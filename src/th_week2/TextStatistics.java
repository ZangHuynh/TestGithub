package th_week2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextStatistics extends JFrame implements ActionListener{

	private JTextArea textArea;
	private JButton btnUpdate;
	private JLabel lbNum;
	private JLabel lbAVG;

	public TextStatistics() {
		setTitle("Text Statistics");
		setSize(450, 550);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		getContentPane().setBackground(new Color(.8f, 0.9f, 0.8f));
		
		JPanel panelTop = new JPanel();
		panelTop.setBorder(BorderFactory.createTitledBorder("Text Container"));
		add(panelTop);
		
		JPanel panelBot = new JPanel();
		panelBot.setBorder(BorderFactory.createTitledBorder("Text Statistics"));
		panelBot.setPreferredSize(new Dimension(240, 120));
		panelBot.setBackground(new Color(.8f, 0.9f, 0.8f));
		add(panelBot);
		
		textArea = new JTextArea("Paste any text here, I will update the statistics.");
		textArea.setWrapStyleWord(true);
		textArea.setPreferredSize(new Dimension(320, 300));
		textArea.setLineWrap(true);
		
		btnUpdate = new JButton("Update text statistics");
		btnUpdate.addActionListener(this);
		
		lbNum = new JLabel("number of words: ");
		lbAVG = new JLabel("average word length: ");
		
		panelTop.add(textArea);
		panelBot.add(btnUpdate);
		panelBot.add(lbNum);
		panelBot.add(lbAVG);
		
	}
	
	public static void main(String[] args) {
		new TextStatistics().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = textArea.getText();
		StringTokenizer tkn = new StringTokenizer(text);
		int count = tkn.countTokens();
		lbNum.setText("number of words: " + count);
		
		int totalChar = 0;
        while (tkn.hasMoreTokens()) {
            String word = tkn.nextToken();
            totalChar += word.length();
        }

        double avgChar = (double) totalChar / count;
        DecimalFormat df = new DecimalFormat("#.##");
        lbAVG.setText("average word length: " + df.format(avgChar));
	}
	
}
