package br.edu.unifei.cct730.trabalho04.gui.componentes;

import br.edu.unifei.cct730.trabalho04.padroes.Command;
import br.edu.unifei.cct730.trabalho04.padroes.Controlador;

/**
 * Metodo responsavel pela implementacao do botao responsavel pela
 * criacao do histograma da imagem
 * 
 * @author fknappe
 *
 */
public class JButtonHistograma extends javax.swing.JButton implements Command {

	//Declaracao das variaveis de instancia
	private Controlador med = null;
	
	/**
	 * Construtor 
	 * 
	 * @param Stirng title
	 * @param Controlador m
	 */
	public JButtonHistograma(String title, Controlador m) {
		this.med = m;
		this.setText(title);
	}
	
	/**
	 * Metodo responsavel por executar a acao definida pelo listener
	 * 
	 * @return void
	 */
	
	@Override
	public void executar() {
		this.med.histograma();
	}
}