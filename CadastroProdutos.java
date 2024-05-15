import java.util.Scanner;
public class CadastroProdutos {
    public static void main(String[] args) {

        Produto[] produtos = new Produto[3];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < produtos.length; i++) {
            System.out.println("Informe o nome do produto " + (i + 1) + ":");
            String nome = scanner.nextLine();
            System.out.println("Informe o preço do produto " + (i + 1) + ":");
            double preco = Double.parseDouble(scanner.nextLine());
            System.out.println("Informe a quantidade do produto " + (i + 1) + ":");
            int quantidade = Integer.parseInt(scanner.nextLine());

            produtos[i] = new Produto(nome, preco, quantidade);
        }

        System.out.println("Lista de Produtos Cadastrados:");
        double maiorValorTotal = 0;
        Produto produtoMaiorValorTotal = null;
        double somaValoresTotais = 0;

        for (Produto produto : produtos) {
            double valorTotal = produto.calcularValorTotal();
            System.out.println("Produto: " + produto.getNome());
            System.out.println("Preço: R$" + produto.getPreco());
            System.out.println("Quantidade: " + produto.getQuantidade());
            System.out.println("Valor Total: R$" + valorTotal);
            System.out.println();

            if (valorTotal > maiorValorTotal) {
                maiorValorTotal = valorTotal;
                produtoMaiorValorTotal = produto;
            }

            somaValoresTotais += valorTotal;
        }

        System.out.println("Produto com o Maior Valor Total:");
        System.out.println("Produto: " + produtoMaiorValorTotal.getNome());
        System.out.println("Preço: R$" + produtoMaiorValorTotal.getPreco());
        System.out.println("Quantidade: " + produtoMaiorValorTotal.getQuantidade());
        System.out.println("Valor Total: R$" + maiorValorTotal);
        System.out.println();

        double mediaValoresTotais = somaValoresTotais / produtos.length;
        System.out.println("Média dos Valores Totais: R$" + mediaValoresTotais);

        scanner.close();
    }
}