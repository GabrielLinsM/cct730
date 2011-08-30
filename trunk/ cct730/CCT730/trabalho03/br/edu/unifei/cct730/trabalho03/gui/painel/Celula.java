package br.edu.unifei.cct730.trabalho03.gui.painel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;

/**
 * Classe celula: respons�vel por criar as c�lulas para a imagem sint�tica
 * @author fknappe
 *
 */
public class Celula extends javax.swing.JPanel {
	
	//Declara��o de vari�veis globais
	private int valor, linha, coluna = 0;
	private javax.swing.JLabel texto = null;
	private Color cor = null;

	/**
	 * Construtor
	 * @param linha
	 * @param coluna
	 * 
	 */
	public Celula(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
		this.valor = 0;
		this.cor = Color.WHITE;
		this.initComponents();
	}
	
	/**
	 * M�todo respons�vel pela inicializa��o dos componentes da GUI
	 *
	 * @return void
	 */
	public void initComponents() {
		
		this.setLayout(new BorderLayout());
		
		this.texto = new JLabel();
		this.texto.setForeground(Color.WHITE);
		this.texto.setHorizontalAlignment(JLabel.CENTER);
		this.add(texto, BorderLayout.CENTER);
		this.setToolTipText(this.toString());
	}

	/**
	 * M�todo respons�vel por definir a cor do painel 
	 * (BRANCO: c�lula n�o selecionado, PRETO: c�lula selecionada)
	 * 
	 * @return void
	 */
	public void trocaCor() {
		switch(valor) {
			case 0:
				this.cor = Color.BLACK;
				this.setBackground(this.cor);
				this.texto.setText("");
				valor = 1;
				break;
		
			case 1:
				this.cor = Color.WHITE;
				this.setBackground(this.cor);
				this.texto.setText("");
				valor = 0;
				break;
			
			default:
				return;
		}
	}

	//Getters e setters	
	public void setColuna(int c) {
		this.coluna = c;
	}
	
	public int getColuna() {
		return coluna;
	}
	
	public void setLinha(int l) {
		this.linha = l;
	}

	public int getLinha() {
		return linha;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
		this.cor = valor == 0 ? Color.WHITE : Color.BLACK;
		this.setBackground(this.cor);
	}
	
	public int getValor() {
		return valor;
	}	
	
	public String toString() {
		return "(" + linha + "," + coluna + ")";
	}

	public void setText(String string) {
		this.texto.setText(string);
	}

	public Color getCor() {
		return this.cor;
	}
	
	public void setCor(Color cor) {
		this.cor = cor;
		this.setBackground(this.cor);
	}
}
