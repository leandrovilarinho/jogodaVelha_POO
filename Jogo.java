public class Jogo{

    private Tabuleiro tabuleiro;
    private Jogador jogador1;
    private Jogador jogador2;

    public Jogo(){
      this.tabuleiro = new Tabuleiro();
      this.jogador1 = new Jogador();
      this.jogador2 = new Jogador();
    }

    public Jogador getJogador(int jogador){
      if (jogador==1)
        return (this.jogador1);
      else
        return (this.jogador2);
    }

    public Tabuleiro getTabuleiro(){
      return (this.tabuleiro);
    }

    public void Jogar (int linha, int coluna, char simbolo){
      if (tabuleiro.getPosicoes()[linha][coluna].getSituacao()==true){
        throw new ExcecaoJogar();
      }
      else
      tabuleiro.getPosicoes()[linha][coluna].setSimbolo(simbolo);
      tabuleiro.getPosicoes()[linha][coluna].setSituacao(true);
    }

    public boolean checaJogo(){
      if (checaLinhas()==true | checaColunas()==true | checaDiagonais()==true | checaEmpate()==true)
        return (true);
      else
      return (false);
    }

  public boolean checaColunas(){
    int i=0;
      for (int j=0; j<tabuleiro.getTamanhoColunas(); j++){
        if (tabuleiro.getPosicoes()[i][j].getSituacao()==true){
          if ((tabuleiro.getPosicoes()[i][j].getSimbolo()==tabuleiro.getPosicoes()[i+1][j].getSimbolo())&&(tabuleiro.getPosicoes()[i][j].getSimbolo()==tabuleiro.getPosicoes()[i+2][j].getSimbolo()))
            return (true);
        }
      }
      return (false);
    }

  public boolean checaLinhas(){
    int j=0;
    for (int i=0; i<tabuleiro.getTamanhoLinhas(); i++){
      if (tabuleiro.getPosicoes()[i][j].getSituacao()==true){
          if ((tabuleiro.getPosicoes()[i][j].getSimbolo()==tabuleiro.getPosicoes()[i][j+1].getSimbolo())&&(tabuleiro.getPosicoes()[i][j+1].getSimbolo()==tabuleiro.getPosicoes()[i][j+2].getSimbolo()))
            return (true);
      }
    }
    return (false);
  }

  public boolean checaDiagonais(){
    int j=0;
    int i=0;
        if (tabuleiro.getPosicoes()[i+1][j+1].getSituacao()==true){
          if (((tabuleiro.getPosicoes()[i][j].getSimbolo()==tabuleiro.getPosicoes()[i+1][j+1].getSimbolo())&&
          (tabuleiro.getPosicoes()[i][j].getSimbolo()==tabuleiro.getPosicoes()[i+2][j+2].getSimbolo()))||
          ((tabuleiro.getPosicoes()[i+1][j+1].getSimbolo()==tabuleiro.getPosicoes()[i+2][j].getSimbolo())&&
          (tabuleiro.getPosicoes()[i+1][j+1].getSimbolo()==tabuleiro.getPosicoes()[i][j+2].getSimbolo())))
            return (true);
        }
        return (false);
      }

  public boolean checaEmpate(){
    int cont=0;
    for (int i=0; i<(getTabuleiro().getTamanhoLinhas()); i++){
        for (int j=0; j<(getTabuleiro().getTamanhoColunas()); j++){
          if (tabuleiro.getPosicoes()[i][j].getSituacao()==true)
            cont++;
        }
    }
    if (cont==9)
      return (true);
    else
      return (false);
  }
}