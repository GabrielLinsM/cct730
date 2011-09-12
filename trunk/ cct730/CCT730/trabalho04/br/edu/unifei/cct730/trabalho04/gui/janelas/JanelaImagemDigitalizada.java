package br.edu.unifei.cct730.trabalho04.gui.janelas;

import br.edu.unifei.cct730.trabalho04.gui.painel.PainelImagem;

public class JanelaImagemDigitalizada extends javax.swing.JInternalFrame {
	
	// Declaracao das variaveis de instacia
	private static int openFrameCount = 0;
	private static final int xOffset = 15, yOffset = 50;
	
	/**
	 * Construtor
	 * 
	 * @param PainelImagem p
	 * 
	 */
	public JanelaImagemDigitalizada(PainelImagem p) {
		super("[Imagem#" + (++openFrameCount) + "]", 
				true, 
				true, 
				true,
				false
		);
		
		this.painelImagemDigitalizada = p;
		this.initComponents();
	}
	
	/**
	 * Metodo responsavel pela instanciacao e inicializacao
	 * dos componentes da GUI
	 * 
	 * @return void
	 */
	public void initComponents() {
		getContentPane().add(painelImagemDigitalizada);
		
		// Define o dimensionamento do painel
		this.setVisible(true);
		setResizable(false);
		setMaximizable(false);
		setLocation(xOffset * openFrameCount, yOffset * openFrameCount);
		
		pack();
	}
	
	// Declaracao das componentes da GUI
	private PainelImagem painelImagemDigitalizada;

	// Metodos getters e setters
	public PainelImagem getPainelImagemDigitalizada() {
		return painelImagemDigitalizada;
	}
}
