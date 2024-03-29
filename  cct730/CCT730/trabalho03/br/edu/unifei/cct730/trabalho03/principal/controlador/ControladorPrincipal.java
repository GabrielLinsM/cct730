package br.edu.unifei.cct730.trabalho03.principal.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.unifei.cct730.trabalho03.eventos.MyActionListener;
import br.edu.unifei.cct730.trabalho03.gui.janelas.JanelaImagemSintetica;
import br.edu.unifei.cct730.trabalho03.gui.painel.PainelDesenho;
import br.edu.unifei.cct730.trabalho03.principal.gui.JanelaPrincipal;
import br.edu.unifei.cct730.trabalho03.utils.MatrizCelula;
import br.edu.unifei.cct730.trabalho03.utils.Transformacao;
import br.edu.unifei.cct730.trabalho03.utils.Mensagem;
import br.edu.unifei.cct730.trabalho03.padroes.Controlador;

/**
 * Classe responsavel por intermediar as acoes
 * do usuario com o restante da aplicacao
 * 
 * @author fknappe
 *
 */
public class ControladorPrincipal extends Controlador {

	//Declaracao das variaveis de instancia
	private JanelaPrincipal janela = null;
	private JanelaImagemSintetica janelaImagem = null;

	/**
	 * Construtor 
	 * @param JanelaPrincipal j
	 */
	public ControladorPrincipal(JanelaPrincipal j) {
		super(j);
		this.janela = j;
	}

	/**
	 * Metodo responsavel por registrar todas as acoes da GUI
	 * 
	 * @return void
	 */
	@Override
	public void registraEventos() {

		// Inicializando o listener para captar os eventos da janela
		MyActionListener myListener = new MyActionListener();

		// Registrando as acoes dos botoes da GUI
		janela.getBtnAbrirPanel().addActionListener(myListener);
		janela.getBtnEspelhamentoH().addActionListener(myListener);
		janela.getBtnEspelhamentoV().addActionListener(myListener);
		janela.getBtnRotacao().addActionListener(myListener);
		janela.getBtnTranslacao().addActionListener(myListener);
		janela.getBtnSobre().addActionListener(myListener);
		janela.getBtnFinalizar().addActionListener(myListener);
	}

	/**
	 * Metodo responsavel por instanciar um painel para criacao
	 * das imagens sinteticas
	 * 
	 * @param void
	 * @return void
	 */
	public void abrirPanel() {
		// Verificando se ja existe uma imagem sintetica em aberto
		if(janelaImagem != null) {
			janelaImagem.dispose();
		}

		try {
			// Inicializando uma nova imagem sintetica
			janelaImagem = new JanelaImagemSintetica();
			PainelDesenho panelDesenho = new PainelDesenho(
					this.retornaValorAltura(), 
					this.retornaValorLargura()
			);
			janelaImagem.setPanelDesenho(panelDesenho);
			lancarFrame(janelaImagem);

			//Tratamento das acoes dos botoes da janela que contem a imagem sintetica
			janelaImagem.getBtnSair().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					janelaImagem.dispose();
					janelaImagem = null;
					janela.desabilitaFuncoesMenu();
				}
			});
		} catch(NumberFormatException e) {
			e.printStackTrace();
			Mensagem.mostraErro(
					this.janela, 
					"Numero deve ser um valor inteiro"
			);
		} finally {
			this.janela.habilitaFuncoesMenu();
		}
	}

	/**
	 * Metodo responsavel por tratar as operacoes de rotacao
	 * sobre a imagem sintetica
	 * 
	 * @param void
	 * @return void
	 */
	public void rotacao() {
		// Verifica a existencia da imagem sintetica
		if(validaTransformacao()){
			try {
				// Atualiza a imagem sintetica apos a realizacao da transformacao
				this.atualizaImagemSintetica(
						this.getTransformacao(janelaImagem.getPanelDesenho().getMatriz()).rotaciona(
								this.retornaValorTransformacao("Determine o angulo de rotacao: "), 5, 5
						)
				);
			} catch(NumberFormatException e) {
				e.printStackTrace();
				Mensagem.mostraErro(
						this.janela, 
				"O valor de entrada deve ser um numero inteiro");
			}
		}
	}

	/**
	 * Metodo responsavel por tratar as operacoes de translacao
	 * sobre a imagem sintetica
	 * 
	 * @param void
	 * @return void
	 */
	public void translacao() {
		// Verifica a existencia da imagem sintetica
		if(validaTransformacao()){
			try {
				// Atualiza a imagem sintetica apos a realizacao da transformacao
				this.atualizaImagemSintetica(
						this.getTransformacao(janelaImagem.getPanelDesenho().getMatriz()).translada(
								this.retornaValorTransformacao("Determine o valor do deslocamento em X: "), 
								this.retornaValorTransformacao("Determine o valor do deslocamento em Y: ")
						)
				);
			} catch(NumberFormatException e) {
				e.printStackTrace();
				Mensagem.mostraErro(
						this.janela, 
				"O valor de entrada deve ser um numero inteiro");
			}
		}
	}

	/**
	 * Metodo responsavel por tratar as operacoes de
	 * espelhamento horizontal
	 * 
	 * @param void
	 * @return void
	 */
	public void espelhamentoHorizontal() {
		// Verifica a existencia da imagem sintetica
		if(validaTransformacao()) {
			// Atualiza a imagem sintetica apos a realizacao da transformacao
			this.atualizaImagemSintetica(
					this.getTransformacao(janelaImagem.getPanelDesenho().getMatriz()).espelhamentoHorizontal()
			);
		}
	}

	/**
	 * Metodo responsavel por tratar as operacoes de
	 * espelhamento vertical
	 * 
	 * @param void
	 * @return void
	 */
	public void espelhamentoVertical() {
		// Verifica a existencia da imagem sintetica
		if(validaTransformacao()) {
			// Atualiza a imagem sinteitca apos a realizacao da transformacao
			this.atualizaImagemSintetica(
					this.getTransformacao(janelaImagem.getPanelDesenho().getMatriz()).espelhamentoVertical()
			);
		}
	}

	/**
	 * Metodo responsavel por tratar as acoes do botao que mostra as informacoes
	 * sobre o(s) autor(es) deste projeto
	 * 
	 * @return void
	 */
	public void sobre() {
		Mensagem.mostraMensagemSobre(
				janela,
				"Universidade Federal de Itajuba\n" + 
				"PDI - Processamento de Imagens \n" +
				"Professor: Dr. Edison Oliveira de Jesus\n" +
				"Aluno: Felipe Agostini Knappe - 12623"
		);
	}

	/**
	 * Metodo responsavel por finalizar o aplicativo
	 * 
	 * @param  void
	 * @return void
	 */
	public void sair() {
		if(Mensagem.confirmaMensagem(janela, "Deseja realmente sair do programa?")) {
			janela.dispose();
			System.exit(0);
		}
	}

	/**
	 * Metodo responsavel por receber o valor da altura
	 * das celulas do editor de imagem sintetica
	 * 
	 * @param void
	 * @return int
	 */
	private int retornaValorAltura() throws NumberFormatException {
		int altura = 0;

		altura = Mensagem.entradaDeDados("Determine o valor da altura: ");
		return altura;
	}

	/**
	 * Metodo responsavel por receber o valor da largura
	 * das celulas do editor de imagem sintetica
	 * 
	 * @param void
	 * @return int
	 */
	private int retornaValorLargura() throws NumberFormatException {
		int largura = 0;

		largura = Mensagem.entradaDeDados("Determine o valor da largura: ");
		return largura;
	}

	/**
	 * Metodo responsavel por receber o valor do deslocamento
	 * das celulas do editor de imagem sintetica
	 * 
	 * @param mensagem
	 * @return int
	 */
	private int retornaValorTransformacao(String mensagem) throws NumberFormatException {
		int transformacao = 0;

		transformacao = Mensagem.entradaDeDados(mensagem);
		return transformacao;
	}

	/**
	 * Metodo responsavel por atualizar o posicionamento da
	 * imagem sintetica no painel
	 * 
	 * @param void
	 * @return void
	 */
	private void atualizaImagemSintetica(int[][] matrizTransformacao) {
		// Obtendo as informacoes da imagem sintetica
		int altura = janelaImagem.getPanelDesenho().getMatriz().getNumLinhas();
		int largura = janelaImagem.getPanelDesenho().getMatriz().getNumColunas();

		// Instanciando a imagem sintetica
		PainelDesenho panelDesenho = new PainelDesenho(
				altura, 
				largura,
				matrizTransformacao
		);

		// Adicionando a nova imagem sintetica na GUI
		janelaImagem.dispose();
		janelaImagem = null;
		janelaImagem = new JanelaImagemSintetica();
		janelaImagem.setPanelDesenho(panelDesenho);
		lancarFrame(janelaImagem);

		// Tratamento das acoes dos botoes da GUI
		janelaImagem.getBtnSair().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				janelaImagem.dispose();
				janelaImagem = null;
				janela.desabilitaFuncoesMenu();
			}
		});
		janela.getDesktop().repaint();
	}

	/**
	 * Metodo responsavel por criar a transformacao sobre a matriz
	 * de celulas da imagem sintetica
	 * 
	 * @param MatrizCelula matriz
	 * @return Transformacao
	 */
	private Transformacao getTransformacao(MatrizCelula matriz) {
		Transformacao transformacao = new Transformacao(matriz);
		return transformacao;
	}

	/**
	 * Metodo responsavel por validar a existencia de uma imagem
	 * sintetica para realizar as transformacoes
	 * 
	 * @param void
	 * @return boolean
	 */

	private boolean validaTransformacao() {
		if(janelaImagem == null) {
			Mensagem.mostraErro(janela, "Nao foi possivel realizar a trasformacao (nenhuma imagem sintetica foi selecionada).");
			return false;
		}
		return true;
	}
}
