public class No {

    Integer valor;
    No filhoEsquerdo;
    No filhoDireito;
    No pai;
    int altura;

    public No(Integer valor) {
        this.valor = valor;
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
        this.pai = null;
        this.altura = 1;
    }

    public void setFilhoEsquerdo(No filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }

    public void setFilhoDireito(No filhoDireito) {
        this.filhoDireito = filhoDireito;
    }
}