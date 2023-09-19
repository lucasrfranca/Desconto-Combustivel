package br.com.visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.controle.Calculo;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela extends JFrame {
	
	Calculo calculo = new Calculo();

	private JPanel contentPane;
	private JTextField textLitros;
	private JLabel lblRes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
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
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quantidade de litros vendido:");
		lblNewLabel.setBounds(10, 11, 165, 19);
		contentPane.add(lblNewLabel);
		
		textLitros = new JTextField();
		textLitros.setBounds(185, 10, 35, 20);
		contentPane.add(textLitros);
		textLitros.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo de combustível: ");
		lblNewLabel_1.setBounds(10, 41, 131, 14);
		contentPane.add(lblNewLabel_1);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		JRadioButton rdbtnAlcool = new JRadioButton("Álcool ");
		rdbtnAlcool.setBounds(10, 62, 65, 23);
		contentPane.add(rdbtnAlcool);
		
		JRadioButton rdbtnGas = new JRadioButton("Gasolina");
		rdbtnGas.setBounds(77, 62, 75, 23);
		contentPane.add(rdbtnGas);
		
		buttonGroup.add(rdbtnAlcool);
		buttonGroup.add(rdbtnGas);
		
		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				calculo.setLitros(Double.valueOf(textLitros.getText()));
				
				if (rdbtnAlcool.isSelected()) {
					
					lblRes.setText(String.format("%.2f", calculo.descontoAlcool()));
					
				}
				
				else if (rdbtnGas.isSelected()) {
					
					lblRes.setText(String.format("%.2f", calculo.descontoGas()));
					
				}
			}
		});
		btnCalcular.setBounds(141, 105, 99, 23);
		contentPane.add(btnCalcular);
		
		lblRes = new JLabel("0.0");
		lblRes.setForeground(Color.RED);
		lblRes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRes.setBounds(86, 157, 134, 14);
		contentPane.add(lblRes);
		
		JLabel lblNewLabel_3 = new JLabel("Total:  R$");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 157, 75, 14);
		contentPane.add(lblNewLabel_3);
	}
}
