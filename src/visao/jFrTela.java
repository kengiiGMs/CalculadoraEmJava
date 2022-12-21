package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.CalculadoraController;
import enums.EnumOperacao;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.awt.event.ActionEvent;

public class jFrTela extends JFrame {
	
	private CalculadoraController calculadoraController;
	private EnumOperacao ultimaOperacao;
	private JPanel contentPane;
	private JTextField tfValor;
	private JTextField tfConta;
	
	
	private void digita(String caractere) {
		if(tfValor.getText().equals("0,00")) {
			tfValor.setText(caractere);
		}else {
			if(caractere.equals(",") && tfValor.getText().contains(",")) {
				
			}else {
				tfValor.setText(tfValor.getText().concat(caractere));
			}
		}
	}
	
	private void limpa() {
		tfValor.setText("0,00");
	}
	
	private Double stringToDouble(String numero) {
		NumberFormat nf = NumberFormat.getInstance();
		Double dv = 0.0;
		try {
			dv = nf.parse(numero).doubleValue();
		}catch(ParseException ex) {
			
		}
		return dv;
	}
	
	private String doubleToString(Double numero) {
		if(numero != null) {
			DecimalFormat formato = new DecimalFormat("##,###,###,##0.00", new DecimalFormatSymbols(new Locale("pt","BR")));
			formato.setParseBigDecimal(true);
			return formato.format(numero);
		}
		return "";
	}
	
	private void imprimirConta(String tipoConta) {
		if(tipoConta != null) {
			tfConta.setText(tfConta.getText() + tfValor.getText() + tipoConta);
		}
	}
	
	
	
	public jFrTela() {
		setResizable(false);
		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 385, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfValor = new JTextField();
		tfValor.setEditable(false);
		tfValor.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		tfValor.setHorizontalAlignment(SwingConstants.RIGHT);
		tfValor.setText("0,00");
		tfValor.setBounds(10, 42, 349, 54);
		contentPane.add(tfValor);
		tfValor.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 107, 349, 318);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(5, 4, 0, 0));
		
		
		
		JButton btn_ac = new JButton("AC");
		btn_ac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpa();
				tfConta.setText("");
				calculadoraController.zerar();
			}
		});
		panel.add(btn_ac);
		
		
		JButton btn_maismenos = new JButton("+/-");
		panel.add(btn_maismenos);
		
		
		JButton btn_porcentagem = new JButton("%");
		panel.add(btn_porcentagem);
		
		
		JButton btn_dividir = new JButton("/");
		btn_dividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadoraController.realizarOperacao(EnumOperacao.DIVISAO,stringToDouble(tfValor.getText()));
				ultimaOperacao = EnumOperacao.DIVISAO;
				
				limpa();
			}
		});
		panel.add(btn_dividir);
		
		
		JButton btn_sete = new JButton("7");
		btn_sete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digita("7");
			}
		});
		panel.add(btn_sete);
		
		
		JButton btn_oito = new JButton("8");
		btn_oito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digita("8");
			}
		});
		panel.add(btn_oito);
		
		
		JButton btn_nove = new JButton("9");
		btn_nove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digita("9");
			}
		});
		panel.add(btn_nove);
		
		
		JButton btn_multiplicar = new JButton("*");
		btn_multiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadoraController.realizarOperacao(EnumOperacao.MULTIPLICACAO,stringToDouble(tfValor.getText()));
				ultimaOperacao = EnumOperacao.MULTIPLICACAO;
				if(tfConta.getText() == "") {
					tfConta.setText(tfValor.getText() + "*");
				}else {
					imprimirConta("*");
					
				}
				limpa();
			}
		});
		panel.add(btn_multiplicar);
		
		
		JButton btn_quatro = new JButton("4");
		btn_quatro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digita("4");
			}
		});
		panel.add(btn_quatro);
		
		
		JButton btn_cinco = new JButton("5");
		btn_cinco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digita("5");
			}
		});
		panel.add(btn_cinco);
		
		
		JButton btn_seis = new JButton("6");
		btn_seis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digita("6");
			}
		});
		panel.add(btn_seis);
		
		
		JButton btn_subtrair = new JButton("-");
		btn_subtrair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadoraController.realizarOperacao(EnumOperacao.SUBTRACAO,stringToDouble(tfValor.getText()));
				ultimaOperacao = EnumOperacao.SUBTRACAO;
				if(tfConta.getText() == "") {
					tfConta.setText(tfValor.getText() + "-");
				}else {
					imprimirConta("-");
					
				}
				limpa();
			}

		});
		panel.add(btn_subtrair);

		
		
		JButton btn_um = new JButton("1");
		btn_um.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digita("1");
			}
		});
		panel.add(btn_um);
		
		
		JButton btn_dois = new JButton("2");
		btn_dois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digita("2");
			}
		});
		panel.add(btn_dois);
		
		
		JButton btn_tres = new JButton("3");
		btn_tres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digita("3");
			}
		});
		panel.add(btn_tres);
		
		
		JButton btn_somar = new JButton("+");
		btn_somar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadoraController.realizarOperacao(EnumOperacao.SOMA,stringToDouble(tfValor.getText()));
				ultimaOperacao = EnumOperacao.SOMA;
				if(tfConta.getText() == "") {
					tfConta.setText(tfValor.getText() + "+");
				}else {
					imprimirConta("+");
					
				}
				
				limpa();
			}
		});
		panel.add(btn_somar);
		
		
		JButton btn_zero = new JButton("0");
		btn_zero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digita("0");
			}
		});
		panel.add(btn_zero);
		
		
		JButton btn_virgula = new JButton(",");
		btn_virgula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digita(",");
			}
		});
		panel.add(btn_virgula);
		
		
		JButton btn_fechar = new JButton("Fechar");
		btn_fechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel.add(btn_fechar);
		
		
		JButton btn_resultado = new JButton("=");
		btn_resultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imprimirConta("=");
				calculadoraController.realizarOperacao(ultimaOperacao, stringToDouble(tfValor.getText()));
				tfValor.setText(doubleToString(calculadoraController.getTotal()));
				calculadoraController.zerar();
			}
		});
		panel.add(btn_resultado);
		
		
		tfConta = new JTextField();
		tfConta.setEditable(false);
		tfConta.setHorizontalAlignment(SwingConstants.RIGHT);
		tfConta.setBounds(10, 11, 349, 20);
		contentPane.add(tfConta);
		tfConta.setColumns(10);
		calculadoraController = new CalculadoraController();
		
	}
}
