package Jogos;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Iterator;

//import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class JogodaVelha extends JFrame{
	JButton [] botao = new JButton[9];
	boolean xo = false;
	boolean[] click = new boolean[9];
	JLabel placar = new JLabel("Placar");
	JLabel px = new JLabel("X = 0");
	JLabel po = new JLabel("O = 0");
	JLabel empate = new JLabel("Empate = 0");
	JButton novo = new JButton("Novo Jogo");
	JButton zerar = new JButton("Zerar Placar");
	int PX = 0;
	int PO = 0;
	int EMPATE = 0;
	
	
	public JogodaVelha() {
		
		//configurações da tela
		setVisible(true);
		setTitle("Trabalho de jogo em Matriz em Java");
		setDefaultCloseOperation(3);
		setLayout(null);
		setBounds(500,250,550,450);
		
		add(placar);
		add(px);
		add(po);
		add(empate);
		add(novo);
		add(zerar);
		placar.setBounds(380,100,300,30);
		placar.setFont(new Font("Arial", Font.BOLD, 25));
		placar.setForeground(Color.white);
		px.setBounds(380,150,150,30);
		px.setFont(new Font("Arial", Font.BOLD, 20));
		px.setForeground(Color.white);
		po.setBounds(380,175,150,30);
		po.setFont(new Font("Arial", Font.BOLD, 20));
		po.setForeground(Color.white);
		empate.setBounds(380,200,300,30);
		empate.setFont(new Font("Arial", Font.BOLD, 20));
		empate.setForeground(Color.white);
		novo.setBounds(370,250,140,30);
		novo.setForeground(Color.blue);
		zerar.setBounds(370,285,140,30);
		zerar.setForeground(Color.blue);
		getContentPane().setBackground(Color.blue);
		
		novo.addActionListener(new java.awt.event.ActionListener() { //atualiza os resultados
			@Override
			public void actionPerformed(ActionEvent e) {
				atualizar();
				limpar();
				}
			});
		zerar.addActionListener(new java.awt.event.ActionListener() {// zera os resultados
			@Override
			public void actionPerformed(ActionEvent e) {
				PO = 0;
				PX = 0;
				EMPATE = 0;
				atualizar();
				limpar();
				}
			});
		
		
		// laço simples começando com 1 matriz para receber os valores O e X
		// faz uma resolução de bug para não receber 2 valores
		int count = 0;
		for (int i = 0; i<3; i++) {
			for (int j = 0; j<3; j++) {
				
				botao[count] = new JButton();
				add(botao[count]);
				botao[count].setBounds((100 * i)+ 50, (100 * j)+ 50, 95, 95);
				botao[count].setFont(new Font("Arial", Font.BOLD, 40));
				count++;
			}
		}
		for (int i = 0; i< 9; i++) {
			click[i] = false;
			}
		
		botao[0].addActionListener(new java.awt.event.ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(click[0] == false) {
						click[0] = true;
					mudar(botao[0]);
					}
				}
			});
		botao[1].addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(click[1] == false) {
					click[1] = true;
				mudar(botao[1]);
				}
			}
		});
		botao[2].addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(click[2] == false) {
					click[2] = true;
				mudar(botao[2]);
				}
			}
		});
		botao[3].addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(click[3] == false) {
					click[3] = true;
					mudar(botao[3]);
				}
			}
		});
		botao[4].addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(click[4] == false) {
					click[4] = true;
					mudar(botao[4]);
				}
			}
		});
		botao[5].addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(click[5] == false) {
					click[5] = true;
					mudar(botao[5]);				
				}
			}
		});
		botao[6].addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(click[6] == false) {
					click[6] = true;
				mudar(botao[6]);
				}
			}
		});
		botao[7].addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(click[7] == false) {
					click[7] = true;
				mudar(botao[7]);
				}
			}
		});
		botao[8].addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(click[8] == false) {
					click[8] = true;
				mudar(botao[8]);
				}
			}
		});
		}
	public void atualizar() { //atualiza o placar para 0
		px.setText("X = "+PX);
		po.setText("O = "+PO);
		empate.setText("Empate = "+EMPATE);
		
	}
	public void ganhar() { // laço de repetição com as chances de ganhar
		int cont = 0;
		for (int i = 0; i < 9; i++) {
			if(click[i] == true) {
				cont++;
			}
		}
		if ((botao[0].getText() == "X" && botao[1].getText() == "X" && botao[2].getText() == "X")
			|| (botao[3].getText() == "X" && botao[4].getText() == "X" && botao[5].getText() == "X")
			|| (botao[6].getText() == "X" && botao[7].getText() == "X" && botao[8].getText() == "X")
			|| (botao[0].getText() == "X" && botao[3].getText() == "X" && botao[6].getText() == "X")
			|| (botao[1].getText() == "X" && botao[4].getText() == "X" && botao[7].getText() == "X")
			|| (botao[2].getText() == "X" && botao[5].getText() == "X" && botao[8].getText() == "X")
			|| (botao[0].getText() == "X" && botao[4].getText() == "X" && botao[8].getText() == "X")
			|| (botao[6].getText() == "X" && botao[4].getText() == "X" && botao[2].getText() == "X")){
				JOptionPane.showMessageDialog(null, "Jogador numero 1 ganhou");
				PX++;
				atualizar();
			limpar();
			
			}else if ((botao[0].getText() == "O" && botao[1].getText() == "O" && botao[2].getText() == "O")
				|| (botao[3].getText() == "O" && botao[4].getText() == "O" && botao[5].getText() == "O")
				|| (botao[6].getText() == "O" && botao[7].getText() == "O" && botao[8].getText() == "O")
				|| (botao[0].getText() == "O" && botao[3].getText() == "O" && botao[6].getText() == "O")
				|| (botao[1].getText() == "O" && botao[4].getText() == "O" && botao[7].getText() == "O")
				|| (botao[2].getText() == "O" && botao[5].getText() == "O" && botao[8].getText() == "O")
				|| (botao[0].getText() == "O" && botao[4].getText() == "O" && botao[8].getText() == "O")
				|| (botao[6].getText() == "O" && botao[4].getText() == "O" && botao[2].getText() == "O")){
				
					JOptionPane.showMessageDialog(null, "Jogador numero 2 ganhou");
					PO++;
					atualizar();
				limpar();
			} else if(cont == 9) {
				JOptionPane.showMessageDialog(null, "Empate");
				EMPATE++;
				atualizar();
				limpar();
			}
				
	}
	public void limpar() {//Limpa todo 
		for (int i = 0; i < 9; i++) {
			botao[i].setText("");
			click[i] = false;
		}
	}
	public void mudar(JButton botao) {
		if(xo) {
			botao.setText("O");
			botao.setForeground(Color.blue);
			xo = false;
		}else {
			botao.setText("X");
			botao.setForeground(Color.red);
			xo = true;
		}
		ganhar();
	}

	public static void main(String[] args) {
		new JogodaVelha(); // metodo construtor, é toda a aplicação do jogo
		
		
		JogodaVelha jogodaVelha = new JogodaVelha();
		jogodaVelha.setResizable(false);// não deixa maximizar
		
	}

}
