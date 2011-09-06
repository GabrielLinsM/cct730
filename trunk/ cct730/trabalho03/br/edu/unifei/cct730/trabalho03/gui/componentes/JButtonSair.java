package br.edu.unifei.cct730.trabalho03.gui.componentes;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import br.edu.unifei.cct730.trabalho03.principal.gui.JanelaPrincipal;
import br.edu.unifei.cct730.trabalho03.padroes.Command;
import br.edu.unifei.cct730.trabalho03.padroes.Mediator;

/**
 * Classe responsavel por instanciar um botao encarregado de finalizar a aplicacao
 * @author fknappe
 *
 */
public class JButtonSair extends javax.swing.JButton implements Command {
	
	//Declaracao das variaveis de inst�ncia
	private Mediator med = null;
	private JInternalFrame internalFrame = null;
	
	/**
	 * Construtor
	 * @param String title
	 * @param JFrame j
	 */
	public JButtonSair(String title, Mediator m) {
		this.med = m;
		this.setText(title);
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
	
	@Override
	public void executar() {
		if(this.internalFrame != null) {
			this.internalFrame.dispose();
		} else {
			this.med.sair();
		}
	}
}
