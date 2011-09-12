package br.edu.unifei.cct730.trabalho04.eventos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import br.edu.unifei.cct730.trabalho04.gui.painel.PainelImagem;

public class PanelImagemListener extends MouseAdapter {

	private PainelImagem panel = null;
	
	public PanelImagemListener(PainelImagem p) {
		this.panel = p;
	}
	
	public void mouseReleased(MouseEvent e) {

		// Declaracao de variaveis
		int x, y = 0;

		/*
		 * Capturando o posicionamento
		 * da imagem
		 */
		x = e.getX();
		y = e.getY();

		if (x < panel.getNumeroColunas() && 
				y < panel.getNumeroLinhas()) {
			panel.repaint();
		}
	}
}