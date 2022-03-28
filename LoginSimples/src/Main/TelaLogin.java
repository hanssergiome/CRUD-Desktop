package Main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import connectbanco.Conexão;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField tfuser;
	private JPasswordField tfsenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setTitle("Tela de Acesso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 307, 213);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbluser = new JLabel("User");
		lbluser.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbluser.setBounds(27, 26, 77, 49);
		contentPane.add(lbluser);

		JLabel lblsenha = new JLabel("Senha");
		lblsenha.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblsenha.setBounds(20, 71, 67, 54);
		contentPane.add(lblsenha);

		tfuser = new JTextField();
		tfuser.setBounds(97, 42, 121, 20);
		contentPane.add(tfuser);
		tfuser.setColumns(10);

		tfsenha = new JPasswordField();
		tfsenha.setBounds(97, 90, 121, 20);
		contentPane.add(tfsenha);

		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Connection con = Conexão.conecta_banco();

					String sql = "Select *from dados_senhas where user=? and senhas=?";

					PreparedStatement statemt = con.prepareStatement(sql);

					statemt.setString(1, tfuser.getText());
					statemt.setString(2, new String(tfsenha.getPassword()));

					ResultSet results = statemt.executeQuery();

					if (results.next()) {

						TelaCadastro exibir = new TelaCadastro();
						exibir.setVisible(true);
						setVisible(false);
						
					} else {

						JOptionPane.showMessageDialog(null, "Usuário ou Senha Incorretos");

					}

					statemt.close();
					con.close();

				}

				catch (SQLException e) {

					e.printStackTrace();

				}
			}
		});
		btnNewButton.setBounds(111, 133, 89, 20);
		contentPane.add(btnNewButton);

	}

}
