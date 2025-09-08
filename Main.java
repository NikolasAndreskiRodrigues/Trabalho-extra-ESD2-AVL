public class Main {
    public static void main(String[] args) {
        Arvore arvore1 = new Arvore();
        Arvore arvore2 = new Arvore();
        Arvore arvore3 = new Arvore();

        System.out.println("-------------------------------------------Árvore 1-------------------------------------------");

        arvore1.adicionar(40);
        arvore1.adicionar(20);
        arvore1.adicionar(60); 
        arvore1.adicionar(10);
        arvore1.adicionar(30);
        arvore1.adicionar(25);
        arvore1.imprimirArvore();
        
        System.out.println("-------------------------------------------Árvore 2-------------------------------------------");

        arvore2.adicionar(60);
        arvore2.adicionar(40);
        arvore2.adicionar(80); 
        arvore2.adicionar(35);
        arvore2.adicionar(50);
        arvore2.adicionar(90);
        arvore2.adicionar(20);
        arvore2.adicionar(38);
        arvore2.adicionar(37);
        arvore2.imprimirArvore();

        System.out.println("-------------------------------------------Árvore 3-------------------------------------------");

        arvore3.adicionar(30);
        arvore3.adicionar(20);
        arvore3.adicionar(10); 
        arvore3.adicionar(25);
        arvore3.adicionar(40);
        arvore3.adicionar(50);
        arvore3.adicionar(5);
        arvore3.adicionar(35);
        arvore3.adicionar(45);
        arvore3.imprimirArvore();
    }
}