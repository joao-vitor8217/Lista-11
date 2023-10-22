import java.util.Scanner;

class Produto {
    private static int ultimoId = 1;
    private int id;
    private String nome;
    private double preco;

    // Construtor sem parâmetros
    public Produto() {
        this.id = ultimoId;
        ultimoId++;
        this.nome = "Nome não informado";
        this.preco = 0;
    }

    // Construtor com nome e preço
    public Produto(String nome, double preco) {
        this();
        this.nome = nome;
        setPreco(preco);
    }

    // Métodos get e set
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            this.preco = 0;
        } else {
            this.preco = preco;
        }
    }

    // Método para exibir as informações do produto
    public void exibe() {
        System.out.println("Produto: " + nome);
        System.out.println("Id: " + id);
        System.out.println("Nome: " + nome);
    }

    // Método para reajustar o preço do produto com base no percentual
    public void reajustaPreco(double percentual) {
        this.preco += this.preco * (percentual / 100);
    }

    // Método principal para testar a classe
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o nome do primeiro produto: ");
        String nome1 = scanner.nextLine();
        System.out.print("Informe o preço do primeiro produto: ");
        double preco1 = scanner.nextDouble();
        Produto produto1 = new Produto(nome1, preco1);

        System.out.print("Informe o nome do segundo produto: ");
        scanner.nextLine(); // Limpar o buffer do scanner
        String nome2 = scanner.nextLine();
        System.out.print("Informe o preço do segundo produto: ");
        double preco2 = scanner.nextDouble();
        Produto produto2 = new Produto(nome2, preco2);

        System.out.print("Informe o percentual de reajuste: ");
        double percentualReajuste = scanner.nextDouble();
        produto1.reajustaPreco(percentualReajuste);
        produto2.reajustaPreco(percentualReajuste);

        System.out.println("\nInformações do primeiro produto:");
        produto1.exibe();
        System.out.println("\nInformações do segundo produto:");
        produto2.exibe();
        System.out.println("\nÚltimo ID gerado: " + Produto.ultimoId);

        scanner.close();
    }
}
