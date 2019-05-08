import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.eclipse.birt.report.engine.api.EngineException;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class printVersion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void versionScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					printVersion frame = new printVersion();
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
	public printVersion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblpleaseSelectThe = new JLabel("*Please select the button of what kind of report you would like\r\n");
		lblpleaseSelectThe.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblpleaseSelectThe.setBounds(10, 11, 398, 44);
		contentPane.add(lblpleaseSelectThe);
		
		JButton btnNewButton = new JButton("Print PDF Reports\r\n");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					executeReportV2 report = new executeReportV2();
					report.executeReportPDF(1);
					}
					catch (EngineException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 11));
		btnNewButton.setBounds(10, 78, 148, 44);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Print HTML Reports\r\n");
		btnNewButton_1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 11));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				executeReportV2 report2 = new executeReportV2();
				try {
					report2.executeReportHTML(1);
				} catch (EngineException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(10, 166, 148, 44);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(192, 66, 207, 184);
		lblNewLabel.setIcon(new ImageIcon("C:\\\\Users\\\\garre\\\\eclipse-workspace\\\\CSTool\\\\imgs\\\\3.JPG"));
		contentPane.add(lblNewLabel);
	}
}
