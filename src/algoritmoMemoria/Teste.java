package algoritmoMemoria;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.OptionPaneUI;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class Teste {
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Teste window = new Teste();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});				
		
	}

	/**
	 * Create the application.
	 */
	public Teste() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ArrayList<PaginaMemoria>lista = new ArrayList<PaginaMemoria>();//Criei uma ArrayList do tipo PaginaMemoria
		PaginaMemoria pag = new PaginaMemoria();//criei um objeto pag do tipo PaginaMemoria

		frame = new JFrame();
		frame.setBounds(100, 100, 531, 412);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 60, 320, 200);
		frame.getContentPane().add(scrollPane);
		
		JTextArea area = new JTextArea();
		scrollPane.setViewportView(area);
		area.setFont(new Font("Arial", 1, 12));
		
		 UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial", Font.BOLD, 20))); 
		
		JOptionPane.showMessageDialog(area, "Este Algoritmo de substituição de páginas, é um modelo baseado em uma lista circular e uma melhoria do\n"
				+ "algoritmo de segunda chance. Se o bit de referência for igual a 0, a página é removida e uma\n"
				+ "nova é inserida na lista, se o bit de referência for igual a 1, ele continua na lista e o ponteiro avança para\n"
				+ "a próxima chamada até todos estarem iguais a 1.");
		
		for(int i=1; i<11; i++) {
			lista.add(new PaginaMemoria(i, (int) (Math.random() * (1-0+1)+0), (int) (Math.random() * (1-0+1)+0)));
		}
		//Aqui a fila é impressa
		for(int i=0; i< lista.size(); i++) {
			if(i==0) {
				area.append(lista.get(0) + " <---Ponteiro");
			}else if(lista.get(i).ref==0){
				area.append(lista.get(i)+" <-Ref = 0, a substituir");
			}else {
				area.append(lista.get(i)+"");
			}
			area.append("\n");
		}
		
		JButton btnSubstituirPagina = new JButton("Substituir P\u00E1gina");
		btnSubstituirPagina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i < 11; i++) {
					//Caso o ponteiro apontar para uma pagina com referencia=0
					//O algoritmo irá substituir a pagina por uma nova
					if(lista.get(0).ref == 0) {
						lista.remove(0);
						//Adiciona uma pagina no final da lista 
						lista.add(new PaginaMemoria(pag.idMaior(lista) + 1, (int) (Math.random() * (1-0+1)+0), (int) (Math.random() * (1-0+1)+0)));
						//Aqui a fila é impressa
						area.append("     \nNova Página criada\n");
						for(int j=0; j< lista.size(); j++) {
							if(lista.get(i).ref==1) {
								int g = 1;
								if(g==10)
								area.append("mensagem");
							}
							if(j==0) {
								area.append(lista.get(0) + " <---Ponteiro");
							}else if(lista.get(j).ref==0){
								area.append(lista.get(j)+" <-Ref = 0, a substituir");
							}else {
								area.append(lista.get(j)+"");
								
							}
							area.append("\n");
							
						}
						break;
						
					}else {
						//Caso o ponteiro
						lista.add(lista.remove(0));
					}
					
					
				}
				
			}
		});
		btnSubstituirPagina.setBounds(69, 299, 148, 23);
		frame.getContentPane().add(btnSubstituirPagina);
		
		
		JButton btnFinalizar = new JButton("Finalizar Programa");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(area, "Algoritmo Finalizado!\n"
						+ "Todos os bits de referencia são iguais a 1. Isso se deu pois o ponteiro da lista, a cada interrupção,\n"
						+ "aponta sempre para a próxima página e verifica seu valor de referência (R), caso seja igual a 0 a página é\n"
						+ " retirada e vai para o disco, caso seja 1 significa que foi referenciada recentemente, com isso tem\n"
						+ "uma segunda chance e continua na lista.");
				lista.removeAll(lista);
				
			}
		});
		btnFinalizar.setBounds(312, 299, 154, 23);
		frame.getContentPane().add(btnFinalizar);
		
		JLabel lblNewLabel = new JLabel("Algoritmo de substitui\u00E7\u00E3o de p\u00E1ginas, lista circular.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(83, 0, 365, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("P\u00E1ginas  |");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(100, 36, 74, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Refer\u00EAncias |");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(166, 36, 89, 23);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Modificador |");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(248, 36, 95, 23);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal tp = new TelaPrincipal();
				tp.main(null);
				
			}
		});
		btnVoltar.setBounds(218, 339, 89, 23);
		frame.getContentPane().add(btnVoltar);
		
		
	}
}
