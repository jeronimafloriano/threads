package parte1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class AcaoBotao implements ActionListener {

	private JTextField primeiro;
	private JTextField segundo;
	private JLabel resultado;

	public AcaoBotao(JTextField primeiro, JTextField segundo, JLabel resultado) {
		this.primeiro = primeiro;
		this.segundo = segundo;
		this.resultado = resultado;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Runnable tarefaMultiplicacao = new Multiplicacao(primeiro, segundo, resultado);
		Thread threadCalculadora = new Thread(tarefaMultiplicacao, "Thread Calculadora");
		threadCalculadora.start();


		Thread thread2 = new Thread(() -> System.out.println("Teste"));
		thread2.start();



	}

}