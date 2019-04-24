import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class AnalyticalTypeGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 * @return 
	 */
	void analyticalscreen () {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnalyticalTypeGUI frame = new AnalyticalTypeGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AnalyticalTypeGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please Select data types");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		lblNewLabel.setBounds(0, 11, 434, 32);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Network Traffic");
		btnNewButton.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
		btnNewButton.setBounds(148, 54, 138, 32);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Packets/TrafficType");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				analyze read = new analyze();
				try {
					read.analyzePacketsPerFlow();
					ResultsGUI data = new ResultsGUI(1,2);
					data.dataScreen2();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(148, 97, 138, 32);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Bytes/TrafficType\r\n");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				analyze read = new analyze();
				try {
					read.analyzeBytesPerFlow();
					ResultsGUI data = new ResultsGUI(1,2,3);
					data.dataScreen3();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(148, 140, 138, 32);
		contentPane.add(btnNewButton_2);
		
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
			
					analyze read = new analyze();
					//read.analyzeBytesPerFlow();
					read.analyzeFlowTypes();
					//read.calcPercents();
					//read.calcPercents();
					ResultsGUI data = new ResultsGUI(1);
					data.dataScreen1();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		});
	}
}
