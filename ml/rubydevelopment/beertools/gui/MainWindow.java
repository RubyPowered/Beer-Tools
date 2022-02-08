package ml.rubydevelopment.beertools.gui;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

import ml.rubydevelopment.beertools.calculator.ABVC;

public class MainWindow extends JFrame implements ActionListener {

	private JPanel p = new JPanel();
	private JPanel result = new JPanel();
	
	private JButton calculate = new JButton("Calculate");
	
	private TextField og = new TextField("Original gravity here");
	private TextField fg = new TextField("Final gravity here");
	
	private JLabel logo = new JLabel();
	private JLabel msg = new JLabel("Beer Tools Java ABV calculator");
	private JLabel rde = new JLabel("Ruby Development");
	private JLabel result1 = new JLabel("Result:");
	private JLabel result2 = new JLabel();
	
	ImageIcon icon = new ImageIcon("C:\\Program Files\\RubyDevelopment\\BeerTools\\frameIcon.png");
	
	public MainWindow() {
		super("Beer Tools - The best ABV calculator");
		this.setSize(450,400);
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setIconImage(icon.getImage());
		
		p.setVisible(true);
		p.setLayout(null);
		p.setBackground(new Color(222,216,220));
		p.setSize(450, 400);
		
		result.setVisible(true);
		result.setLayout(null);
		result.setBackground(new Color(222,216,220));
		result.setBounds(10,200,200,100);
		result.setBackground(Color.white);
		result.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		
		logo.setVisible(true);
		logo.setBounds(5,5,64,64);
		logo.setIcon(icon);
		
		msg.setVisible(true);
		msg.setBounds(75,20,400,30);
		msg.setFont(new Font("Arial", Font.ITALIC, 24));
		
		rde.setVisible(true);
		rde.setBounds(75,37,400,30);
		rde.setFont(new Font("Arial", Font.ITALIC, 12));
		rde.setForeground(Color.red);
		rde.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent m) {
				try {
					Desktop.getDesktop().browse(new URI("http://www.rubydevelopment.ml/java/bt.html"));
				} catch (IOException | URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		og.setVisible(true);
		og.setBounds(10,100,200,20);
		
		fg.setVisible(true);
		fg.setBounds(10,125,200,20);
		
		calculate.setVisible(true);
		calculate.setFocusable(false);
		calculate.setBounds(10,150,200,20);
		calculate.addActionListener(this);
		
		result1.setVisible(true);
		result1.setBounds(10,180,400,30);
		result1.setFont(new Font("Arial", Font.PLAIN, 12));
		
		result2.setVisible(true);
		result2.setBounds(30,40,200,20);
		result2.setFont(new Font("Arial", Font.ITALIC, 12));
		
		this.add(p);
		
		p.add(logo);
		p.add(msg);
		p.add(rde);
		p.add(fg);
		p.add(og);
		p.add(calculate);
		p.add(result);
		p.add(result1);
		
		result.add(result2);
		
		SwingUtilities.updateComponentTreeUI(this);
		SwingUtilities.updateComponentTreeUI(p);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==calculate) {
			double og1 = Double.parseDouble(og.getText());
			double fg1 = Double.parseDouble(fg.getText());
			
			double returned = new ABVC().calculateABV(og1, fg1);
			System.out.println(returned);
			
			result2.setText(String.valueOf(returned));
			
		}
		
	}

}
