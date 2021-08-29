package algoritmoMemoria;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Font;

public class FirstFit {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstFit window = new FirstFit();
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
	public FirstFit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

        int[] parteMemoria;             
        parteMemoria = new int[3];      
        parteMemoria[0] = 800; 
        parteMemoria[1] = 900; 
        parteMemoria[2] = 900; 
        //Arrays.sort(parteMemoria);
		
        int[] processo;             
        processo = new int[3];      
        
        int index;
        
        //processo[0] = entradaUsuario.nextInt();//aqui o algoritmo pega o primeiro valor de entrada
        //Arrays.sort(processo);
        
        Random r = new Random();
        int numeroAleatorio = r.nextInt(100);
        
        for(index = 0; index < 3; index++){//aqui ele já armazena do sugundo indice para frente
        	processo[index] = numeroAleatorio;
        	numeroAleatorio += 10;
        }
		
       
		frame = new JFrame();
		frame.setBounds(100, 100, 549, 404);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea area = new JTextArea();
		area.setBounds(54, 57, 409, 211);
		frame.getContentPane().add(area);
		
		 
		
		JButton btnProcesso = new JButton("Gerar Processos");
		btnProcesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				area.append("O Algoritmo gerou 3 processos aleatórios:\n ");
				for(int index = 0; index < 3; index++){//aqui ele já armazena do sugundo indice para frente
			        area.append(processo[+index]+"   ");
		        }
				area.append("\n");
		          for(int j=0; j<3;j++){
		              for(int i=0; i<3; i++){
		                  if(processo[j] <= parteMemoria[i]){
		                	  parteMemoria[i]=j;
		                	  area.append("Processo de tamanho " + processo[j] + " está em memoria na partição " + parteMemoria[i]);
		                	  area.append("\n");
		                      break;
		                      }
		                       else if(processo[j] > parteMemoria[i]){
		                    	   area.append("Processos de tamanho "+ processo[j]+" na fila de espera./ ");
		                    	   area.append("\n");
		                    }
		                    
		                }
		            }   
				
				
			}
		});
		
		btnProcesso.setBounds(188, 272, 138, 31);
		frame.getContentPane().add(btnProcesso);
		
		JLabel lblNewLabel = new JLabel("Algoritmo First-Fit");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(188, 11, 158, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal tp = new TelaPrincipal();
				tp.main(null);
			}
			
		});
		btnVoltar.setBounds(215, 331, 89, 23);
		frame.getContentPane().add(btnVoltar);
	}
}
