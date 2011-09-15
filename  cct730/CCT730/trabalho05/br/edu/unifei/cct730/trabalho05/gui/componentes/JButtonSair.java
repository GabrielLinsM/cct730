package br.edu.unifei.cct730.trabalho05.gui.componentes;

import javax.swing.JInternalFrame;

import br.edu.unifei.cct730.trabalho05.padroes.Command;
import br.edu.unifei.cct730.trabalho05.padroes.Controlador;

/**
 * Classe responsavel por instanciar um botao encarregado de finalizar a aplicacao
 * @author fknappe
 *
 */
public class JButtonSair extends javax.swing.JButton implements Command {
	
	//Declaracao das variaveis de inst�ncia
	private Controlador med = null;
	private JInternalFrame internalFrame = null;
	
	/**
	 * Construtor
	 * @param String title
	 * @param JFrame j
	 */
	public JButtonSair(String title, Controlador m) {
		super(title);
		this.med = m;
	}
	
	/**
	 * Construtor
	 * @param String title
	 * @param JInternalFrame j
	 */
	public JButtonSair(String title, JInternalFrame j) {
		this.internalFrame = j;
		this.setText(title);
	}
	
	/**
	 * Metodo responsavel por executar a acao definida pelo listener
	 * 
	 * @return void
	 */
	@Override
	public void executar() {
		if(this.internalFrame != null) {
			this.internalFrame.dispose();
		} else {
			this.med.sair();
		}
	}
}
