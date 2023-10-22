import java.util.Scanner;

class Inteiro {
    public int multiplicacao(int a, int b) {
        int resultado = 0;
        for (int i = 0; i < Math.abs(b); i++) {
            resultado += a;
        }
        if (b < 0) {
            resultado = -resultado;
        }
        return resultado;
    }

    public int potencia(int a, int b) {
        int resultado = 1;
        for (int i = 0; i < b; i++) {
            resultado = multiplicacao(resultado, a);
        }
        return resultado;
    }

    public int divisao(int a, int b) {
        int quociente = 0;
        while (a >= b) {
            a = a - b;
            quociente++;
        }
        return quociente;
    }

    public int resto(int a, int b) {
        while (a >= b) {
            a = a - b;
        }
        return a;
    }

    public boolean par(int a) {
        return resto(a, 2) == 0;
    }

    public static void main(String[] args) {
        Inteiro calculadora = new Inteiro();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1 – Multiplicação.");
            System.out.println("2 – Potência.");
            System.out.println("3 – Divisão.");
            System.out.println("4 – Par.");
            System.out.println("5 – Sair.");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            int a, b, resultado;
            switch (opcao) {
                case 1:
                    System.out.print("Digite o primeiro número: ");
                    a = scanner.nextInt();
                    System.out.print("Digite o segundo número: ");
                    b = scanner.nextInt();
                    resultado = calculadora.multiplicacao(a, b);
                    System.out.println("Resultado: " + resultado);
                    break;
                case 2:
                    System.out.print("Digite a base: ");
                    a = scanner.nextInt();
                    System.out.print("Digite o expoente: ");
                    b = scanner.nextInt();
                    resultado = calculadora.potencia(a, b);
                    System.out.println("Resultado: " + resultado);
                    break;
                case 3:
                    System.out.print("Digite o dividendo: ");
                    a = scanner.nextInt();
                    System.out.print("Digite o divisor: ");
                    b = scanner.nextInt();
                    resultado = calculadora.divisao(a, b);
                    System.out.println("Quociente: " + resultado);
                    break;
                case 4:
                    System.out.print("Digite o número: ");
                    a = scanner.nextInt();
                    boolean par = calculadora.par(a);
                    System.out.println("É par? " + par);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (opcao != 5);

        scanner.close();
    }
}
