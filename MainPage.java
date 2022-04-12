import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class MainPage {

	private JFrame frmImageSteganography;
	private JTextField messageField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
					window.frmImageSteganography.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmImageSteganography = new JFrame();
		frmImageSteganography.setTitle("Image Steganography");
		frmImageSteganography.setBounds(100, 100, 450, 126);
		frmImageSteganography.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel optionsPanel = new JPanel();
		frmImageSteganography.getContentPane().add(optionsPanel, BorderLayout.SOUTH);
		optionsPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton encryptButton = new JButton("Encrypt");
		optionsPanel.add(encryptButton);
		
		JButton decryptButton = new JButton("Decrypt");
		optionsPanel.add(decryptButton);
		
		JPanel fieldsPanel = new JPanel();
		frmImageSteganography.getContentPane().add(fieldsPanel, BorderLayout.CENTER);
		fieldsPanel.setLayout(null);
		
		JLabel messageLabel = new JLabel("Message:");
		messageLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		messageLabel.setBounds(10, 11, 96, 37);
		fieldsPanel.add(messageLabel);
		
		messageField = new JTextField();
		messageField.setBounds(92, 21, 336, 20);
		fieldsPanel.add(messageField);
		messageField.setColumns(10);
		
		ActionListener encryptListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				File imageFile = FileChooser.MakeFileChooser();
				if(imageFile != null) {
					EncryptLSB.Encrypt(imageFile, messageField.getText());
				}
			}
		};
		encryptButton.addActionListener(encryptListener);
		
		ActionListener decryptListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DecryptLSB.Decrypt();
			}
		};
		decryptButton.addActionListener(decryptListener);
	}
}
