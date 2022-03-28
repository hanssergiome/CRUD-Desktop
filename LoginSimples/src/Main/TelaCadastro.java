package Main;

import java.awt.Color;
import java.awt.EventQueue;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import connectbanco.Conexão;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField tfid;
	private JTextField tfuser;
	private JTextField tfsenha;
	private JTextField tfbusca;
	private JTable tbdados;

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
		panel.setBounds(10, 277, 392, 55);
		contentPane.add(panel);

		JButton btnsalvar = new JButton("Salvar");
		btnsalvar.setBounds(10, 21, 91, 23);
		btnsalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (tfuser.getText().equals("") || tfsenha.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Usuário ou Senha Faltando");
				}

				else {

					try {
						Connection con = Conexão.conecta_banco();

						String sql = "insert into dados_senhas (user, senhas) value (?, ?) ";

						PreparedStatement statemt = con.prepareStatement(sql);

						statemt.setString(1, tfuser.getText());
						statemt.setString(2, tfsenha.getText());

						statemt.execute();

						statemt.close();
						con.close();

						JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");

						tfuser.setText("");
						tfsenha.setText("");

					} catch (SQLException e) {

						e.printStackTrace();

					}
				}
			}
		});
		panel.setLayout(null);
		panel.add(btnsalvar);

		JButton btnatualizar = new JButton("Atualizar");
		btnatualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tfid.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "informe um id válido");

				}
				try {
					Connection con = Conexão.conecta_banco();

					String sql = "update dados_senhas set user=?, senhas=? where id=?";

					PreparedStatement statemt = con.prepareStatement(sql);

					statemt.setString(1, tfuser.getText());

					statemt.setString(2, tfsenha.getText());

					statemt.setString(3, tfid.getText());

					statemt.execute();

					statemt.close();
					con.close();

					JOptionPane.showMessageDialog(null, "Atualizado com Sucesso");

				} catch (SQLException e1) {

					e1.printStackTrace();
				}

			}
		});
		btnatualizar.setBounds(111, 21, 89, 23);
		panel.add(btnatualizar);

		JButton btnexluir = new JButton("Excluir");
		btnexluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tfid.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Informe um id válido");

				} else {
					try {
						Connection con = Conexão.conecta_banco();

						String sql = "delete from dados_senhas where id=?";

						PreparedStatement statemt = con.prepareStatement(sql);

						statemt.setString(1, tfid.getText());

						statemt.execute();

						statemt.close();
						con.close();

						JOptionPane.showMessageDialog(null, "Excluido com Sucesso");
						
						tfid.setText("");
						tfuser.setText("");
						tfsenha.setText("");

					} catch (SQLException e1) {

						e1.printStackTrace();
					}
				}
			}
		});
		btnexluir.setBounds(210, 21, 89, 23);
		panel.add(btnexluir);

		JPanel Ações = new JPanel();
		Ações.setBorder(new TitledBorder(null, "Abrir Dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Ações.setBounds(10, 343, 392, 66);
		contentPane.add(Ações);
		Ações.setLayout(null);

		tfbusca = new JTextField();
		tfbusca.setBounds(109, 23, 86, 20);
		Ações.add(tfbusca);
		tfbusca.setColumns(10);

		JButton btnabrir = new JButton("Abrir");
		btnabrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (tfbusca.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Digite um id válido");
				}

				else {

					try {
						Connection con = Conexão.conecta_banco();

						String sql = "select *from dados_senhas where id=?";

						PreparedStatement statemt = con.prepareStatement(sql);

						statemt.setString(1, tfbusca.getText());

						ResultSet results = statemt.executeQuery();

						while (results.next()) {

							tfid.setText(results.getString("id"));

							tfuser.setText(results.getString("user"));

							tfsenha.setText(results.getString("senhas"));

						}

						results.close();
						con.close();

					} catch (SQLException e) {

						e.printStackTrace();
					}

				}
			}
		});
		btnabrir.setBounds(10, 22, 89, 23);
		Ações.add(btnabrir);

		JButton btnlistd = new JButton("Listar Dados");
		btnlistd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Connection con = Conexão.conecta_banco();

					String sql = "Select *from dados_senhas";

					PreparedStatement statemt = con.prepareStatement(sql);

					ResultSet results = statemt.executeQuery();

					DefaultTableModel model = (DefaultTableModel) tbdados.getModel();
					model.setNumRows(0);

					while (results.next()) {

						model.addRow(new Object[] { results.getString("id"), results.getString("user"),
								results.getString("senhas") });

					}

					results.close();
					con.close();

				} catch (SQLException e1) {

					e1.printStackTrace();
				}

			}
		});
		btnlistd.setBounds(232, 22, 150, 23);
		Ações.add(btnlistd);

		JScrollPane TabelaDados = new JScrollPane();
		TabelaDados.setBounds(10, 190, 392, 76);
		contentPane.add(TabelaDados);

		tbdados = new JTable();
		tbdados.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, },
				new String[] { "id", "user", "senha" }) {
			boolean[] columnEditables = new boolean[] { false, true, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		TabelaDados.setViewportView(tbdados);
	}
}
