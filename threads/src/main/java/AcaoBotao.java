import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

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
		Multiplicacao tarefaMultiplicacao = new Multiplicacao(primeiro, segundo, resultado);
		Thread threadCalculadora = new Thread(tarefaMultiplicacao, "Thread Calculadora");
		threadCalculadora.start();


	}

}