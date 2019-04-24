import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ResultsGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void dataScreen1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultsGUI frame = new ResultsGUI(1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		//-------------------------------------------------------------------------------------------------------------------//
		public void dataScreen2() {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						ResultsGUI frame = new ResultsGUI(1,2);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	}
		//--------------------------------------------------------------------------------------------------------------------//
		public void dataScreen3() {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						ResultsGUI frame = new ResultsGUI(1,2,3);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	}
		//--------------------------------------------------------------------------------------------------------------------//
	/**
	 * Create the frame.
	 */
	public ResultsGUI(int fake) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Different Traffic Types");
		lblNewLabel.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		lblNewLabel.setBounds(120, 0, 275, 53);
		contentPane.add(lblNewLabel);
		
		
		JList list = new JList();
		list.setBounds(102, 73, 0, 118);
		contentPane.add(list);
		
		JLabel lblNewLabel_1 = new JLabel("Background flows: "+ analyze.backgroundFlows);
		lblNewLabel_1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 73, 215, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Botnet Flows: " + analyze.botNets);
		lblNewLabel_2.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 113, 204, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Normal Flows: "+ analyze.normal);
		lblNewLabel_3.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 144, 265, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("TotalFlows: "+ analyze.totalFlows);
		lblNewLabel_4.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 177, 204, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Write to Excel For Reporting");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				writeToExcelv2 reports = new writeToExcelv2(analyze.backgroundFlows,analyze.normal,analyze.botNets,analyze.totalFlows);
			}
		});
		btnNewButton.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		btnNewButton.setBounds(102, 207, 248, 43);
		contentPane.add(btnNewButton);
	}
	
	//----------------------------------------------------------------------------------------------------------------------------------//
	
	
	
	public ResultsGUI(int fake,int secondFake) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Packets/FlowType");
		lblNewLabel.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		lblNewLabel.setBounds(120, 0, 275, 53);
		contentPane.add(lblNewLabel);
		
		
		JList list = new JList();
		list.setBounds(102, 73, 0, 118);
		contentPane.add(list);
		
		JLabel lblNewLabel_1 = new JLabel("Background Packets: "+ analyze.backgroundPackets);
		lblNewLabel_1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 73, 215, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Botnet Packets: " + analyze.botNetsPackets);
		lblNewLabel_2.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 113, 204, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Normal Packets: "+ analyze.normalPackets);
		lblNewLabel_3.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 144, 265, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("TotalPackets: "+ analyze.totalPackets);
		lblNewLabel_4.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 177, 204, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Write to Excel For Reporting");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				writeToExcelv2 reports = new writeToExcelv2(analyze.backgroundFlows,analyze.normal,analyze.botNets,analyze.totalFlows);
			}
		});
		btnNewButton.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		btnNewButton.setBounds(102, 207, 248, 43);
		contentPane.add(btnNewButton);
	}
	//----------------------------------------------------------------------------------------------------------------------------------//
	
	public ResultsGUI(int fake,int fake2,int fake3) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Different Traffic Types");
		lblNewLabel.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		lblNewLabel.setBounds(120, 0, 275, 53);
		contentPane.add(lblNewLabel);
		
		
		JList list = new JList();
		list.setBounds(102, 73, 0, 118);
		contentPane.add(list);
		
		JLabel lblNewLabel_1 = new JLabel("Background Bytes: "+ analyze.backgroundBytes);
		lblNewLabel_1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 73, 215, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Botnet Bytes: " + analyze.botNetsBytes);
		lblNewLabel_2.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 113, 204, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Normal Bytes: "+ analyze.normalBytes);
		lblNewLabel_3.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 144, 265, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("TotalBytes: "+ analyze.totalBytes);
		lblNewLabel_4.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 177, 204, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Write to Excel For Reporting");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				writeToExcelv2 reports = new writeToExcelv2(analyze.backgroundFlows,analyze.normal,analyze.botNets,analyze.totalFlows);
			}
		});
		btnNewButton.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		btnNewButton.setBounds(102, 207, 248, 43);
		contentPane.add(btnNewButton);
	}
	
	//----------------------------------------------------------------------------------------------------------------------------------//
	
}
