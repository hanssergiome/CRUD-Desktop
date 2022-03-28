package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField tfid;
	private JTextField tfuser;
	private JTextField tfsenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
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
	public TelaCadastro() {
		setResizable(false);
		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblid = new JLabel("ID");
		lblid.setBounds(35, 37, 34, 40);
		contentPane.add(lblid);
		
		JLabel lbluser = new JLabel("User");
		lbluser.setBounds(35, 78, 46, 14);
		contentPane.add(lbluser);
		
		JLabel lblsenha = new JLabel("Senha");
		lblsenha.setBounds(35, 114, 46, 14);
		contentPane.add(lblsenha);
		
		tfid = new JTextField();
		tfid.setEditable(false);
		tfid.setBounds(95, 47, 86, 20);
		contentPane.add(tfid);
		tfid.setColumns(10);
		
		tfuser = new JTextField();
		tfuser.setBounds(94, 78, 158, 20);
		contentPane.add(tfuser);
		tfuser.setColumns(10);
		
		tfsenha = new JTextField();
		tfsenha.setBounds(94, 111, 158, 20);
		contentPane.add(tfsenha);
		tfsenha.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(20, 330, 392, 48);
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					
					
				} catch (Exception e) {
				
				}
				
			}
		});
		panel.add(btnNewButton);
	}
}
