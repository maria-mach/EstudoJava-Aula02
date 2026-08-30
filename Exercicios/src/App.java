import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<Produto> produtos = Arrays.asList(
                new Produto("Notebook", 3500.0, "Eletronicos"),
                new Produto("Smartphone", 2200.0, "Eletronicos"),
                new Produto("Fone de ouvido", 250.0, "Eletronicos"),
                new Produto("Java: Como Programar", 180.0, "Livros"),
                new Produto("Clean Code", 210.0, "Livros"),
                new Produto("Monitor", 900.0, "Eletronicos"),
                new Produto("Cadeira de escritorio", 750.0, "Moveis"),
                new Produto("O Senhor dos Aneis", 120.0, "Livros"));

        System.out.println("a. Produtos da categoria Eletronicos usando forEach e if:");
        produtos.forEach(produto -> {
            if (produto.getCategoria().equals("Eletronicos")) {
                System.out.println(produto.getNome());
            }
        });

        System.out.println("\na. Produtos da categoria Eletronicos usando stream e filter:");
        produtos.stream()
                .filter(produto -> produto.getCategoria().equals("Eletronicos"))
                .forEach(produto -> System.out.println(produto.getNome()));

        System.out.println("\nb. Precos dos produtos maiores que 500.0:");
        List<Double> precosMaioresQue500 = produtos.stream()
                .filter(produto -> produto.getPreco() > 500.0)
                .map(produto -> produto.getPreco())
                .collect(Collectors.toList());
        System.out.println(precosMaioresQue500);

        System.out.println("\nc. Valor total do estoque da categoria Livros:");
        double totalLivros = produtos.stream()
                .filter(produto -> produto.getCategoria().equals("Livros"))
                .mapToDouble(produto -> produto.getPreco())
                .sum();
        System.out.println(totalLivros);

        System.out.println("\nd/e. Busca por produto existente:");
        Optional<Produto> produtoEncontrado = buscarProdutoPorNome(produtos, "Notebook");
        produtoEncontrado.ifPresent(produto -> System.out.println(produto));

        System.out.println("\nd/e. Busca por produto inexistente:");
        try {
            Produto produtoInexistente = buscarProdutoPorNome(produtos, "Tablet")
                    .orElseThrow(() -> new RuntimeException("Produto nao encontrado!"));
            System.out.println(produtoInexistente);
        } catch (RuntimeException erro) {
            System.out.println(erro.getMessage());
        }

        System.out.println("\nf. Lista de nomes usando lambda:");
        List<String> nomesComLambda = produtos.stream()
                .map(produto -> produto.getNome())
                .collect(Collectors.toList());
        System.out.println(nomesComLambda);

        System.out.println("\nf. Lista de nomes usando referencia de metodo:");
        List<String> nomesComReferencia = produtos.stream()
                .map(Produto::getNome)
                .collect(Collectors.toList());
        System.out.println(nomesComReferencia);
    }

    public static Optional<Produto> buscarProdutoPorNome(List<Produto> produtos, String nome) {
        return produtos.stream()
                .filter(produto -> produto.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }
}
