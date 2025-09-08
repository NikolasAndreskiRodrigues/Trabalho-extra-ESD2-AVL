public class Arvore {

    No raiz;

    public Arvore() {}

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    private int getAltura(No no) {
        if (no == null) {
            return 0;
        }
        return no.altura;
    }

    private int getFatorBalanceamento(No no) {
        if (no == null) {
            return 0;
        }
        return getAltura(no.filhoEsquerdo) - getAltura(no.filhoDireito);
    }

    private void atualizarAltura(No no) {
        if (no != null) {
            no.altura = 1 + Math.max(getAltura(no.filhoEsquerdo), getAltura(no.filhoDireito));
        }
    }

    private No rotacaoDireita(No noDesbalanceado) {
        No novaRaiz = noDesbalanceado.filhoEsquerdo;
        No subArvoreDireitaDaNovaRaiz = novaRaiz.filhoDireito;
        No paiOriginal = noDesbalanceado.pai;

        novaRaiz.pai = paiOriginal;
        if (paiOriginal != null) {
            if (paiOriginal.filhoEsquerdo == noDesbalanceado) {
                paiOriginal.filhoEsquerdo = novaRaiz;
            } else {
                paiOriginal.filhoDireito = novaRaiz;
            }
        }

        novaRaiz.filhoDireito = noDesbalanceado;
        noDesbalanceado.pai = novaRaiz;

        noDesbalanceado.filhoEsquerdo = subArvoreDireitaDaNovaRaiz;
        if (subArvoreDireitaDaNovaRaiz != null) {
            subArvoreDireitaDaNovaRaiz.pai = noDesbalanceado;
        }

        atualizarAltura(noDesbalanceado);
        atualizarAltura(novaRaiz);

        return novaRaiz;
    }

    private No rotacaoEsquerda(No noDesbalanceado) {
        No novaRaiz = noDesbalanceado.filhoDireito;
        No subArvoreEsquerdaDaNovaRaiz = novaRaiz.filhoEsquerdo;
        No paiOriginal = noDesbalanceado.pai;

        novaRaiz.pai = paiOriginal;
        if (paiOriginal != null) {
            if (paiOriginal.filhoEsquerdo == noDesbalanceado) {
                paiOriginal.filhoEsquerdo = novaRaiz;
            } else {
                paiOriginal.filhoDireito = novaRaiz;
            }
        }

        novaRaiz.filhoEsquerdo = noDesbalanceado;
        noDesbalanceado.pai = novaRaiz;
        
        noDesbalanceado.filhoDireito = subArvoreEsquerdaDaNovaRaiz;
        if (subArvoreEsquerdaDaNovaRaiz != null) {
            subArvoreEsquerdaDaNovaRaiz.pai = noDesbalanceado;
        }

        atualizarAltura(noDesbalanceado);
        atualizarAltura(novaRaiz);

        return novaRaiz;
    }

    public void adicionar(Integer valor) {
        this.raiz = adicionar(valor, this.raiz, null);
    }

    public No adicionar(Integer valor, No noAtual, No noPai) {
        if (noAtual == null) {
            No novoNo = new No(valor);
            novoNo.pai = noPai;
            return novoNo;
        }

        if (valor < noAtual.valor) {
            No novoNoEsquerdo = adicionar(valor, noAtual.filhoEsquerdo, noAtual);
            noAtual.setFilhoEsquerdo(novoNoEsquerdo);
        } else if (valor > noAtual.valor) {
            No novoNoDireito = adicionar(valor, noAtual.filhoDireito, noAtual);
            noAtual.setFilhoDireito(novoNoDireito);
        } else {
            return noAtual;
        }

        atualizarAltura(noAtual);

        return balancear(noAtual, valor);
    }
    
    private No balancear(No noAtual, int valor) {
        int fatorBalanceamento = getFatorBalanceamento(noAtual);

        if (fatorBalanceamento > 1 && valor < noAtual.filhoEsquerdo.valor) {
            return rotacaoDireita(noAtual);
        }

        if (fatorBalanceamento < -1 && valor > noAtual.filhoDireito.valor) {
            return rotacaoEsquerda(noAtual);
        }

        if (fatorBalanceamento > 1 && valor > noAtual.filhoEsquerdo.valor) {
            noAtual.filhoEsquerdo = rotacaoEsquerda(noAtual.filhoEsquerdo);
            return rotacaoDireita(noAtual);
        }

        if (fatorBalanceamento < -1 && valor < noAtual.filhoDireito.valor) {
            noAtual.filhoDireito = rotacaoDireita(noAtual.filhoDireito);
            return rotacaoEsquerda(noAtual);
        }

        return noAtual; 
    }


    public void imprimirArvore() {
        if (this.raiz == null) {
            System.out.println("Árvore vazia.");
            return;
        }
        imprimir(this.raiz, "", true);
    }

    private void imprimir(No no, String prefixo, boolean ehDireito) {
        if (no != null) {
            System.out.println(prefixo + (ehDireito ? "R----" : "L----") + no.valor + " (FB: " + getFatorBalanceamento(no) + ", h: " + no.altura + ")");
            imprimir(no.filhoEsquerdo, prefixo + (ehDireito ? "   " : "|  "), false);
            imprimir(no.filhoDireito, prefixo + (ehDireito ? "   " : "|  "), true);
        }
    }
}