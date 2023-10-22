import java.util.Scanner;

class Pessoa {
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class PessoaFisica extends Pessoa {
    private String cpf;

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}

class PessoaJuridica extends Pessoa {
    private String cnpj;

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }
}

class Cadastro {
    private Pessoa[] pessoas;
    private int contador;

    public Cadastro(int tamanho) {
        pessoas = new Pessoa[tamanho];
        contador = 0;
    }

    public void cadastrarPessoa(Pessoa pessoa) {
        if (contador < pessoas.length) {
            pessoas[contador] = pessoa;
            contador++;
            System.out.println("Pessoa cadastrada com sucesso!");
        } else {
            System.out.println("Cadastro completo. Não é possível adicionar mais pessoas.");
        }
    }

    public void imprimirCadastro() {
        for (int i = 0; i < contador; i++) {
            System.out.println("Nome: " + pessoas[i].getNome());
            if (pessoas[i] instanceof PessoaFisica) {
                System.out.println("CPF: " + ((PessoaFisica) pessoas[i]).getCpf());
            } else if (pessoas[i] instanceof PessoaJuridica) {
                System.out.println("CNPJ: " + ((PessoaJuridica) pessoas[i]).getCnpj());
            }
            System.out.println("-------------");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cadastro cadastro = new Cadastro(100);

        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1 - Cadastrar Pessoa Física");
            System.out.println("2 - Cadastrar Pessoa Jurídica");
            System.out.println("3 - Imprimir Cadastro");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    PessoaFisica pessoaFisica = new PessoaFisica();
                    System.out.print("Digite o nome: ");
                    pessoaFisica.setNome(scanner.nextLine());
                    System.out.print("Digite o CPF: ");
                    pessoaFisica.setCpf(scanner.nextLine());
                    cadastro.cadastrarPessoa(pessoaFisica);
                    break;
                case 2:
                    PessoaJuridica pessoaJuridica = new PessoaJuridica();
                    System.out.print("Digite o nome: ");
                    pessoaJuridica.setNome(scanner.nextLine());
                    System.out.print("Digite o CNPJ: ");
                    pessoaJuridica.setCnpj(scanner.nextLine());
                    cadastro.cadastrarPessoa(pessoaJuridica);
                    break;
                case 3:
                    System.out.println("Cadastro:");
                    cadastro.imprimirCadastro();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 4);

        scanner.close();
    }
}
