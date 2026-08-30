# EstudoJava-Aula02

Entrega dos exercicios de Java da Aula 02, com foco em programacao funcional usando a Stream API.

## Objetivo

O projeto cria uma classe `Produto` com os atributos:

- `nome`
- `preco`
- `categoria`

A classe principal monta uma lista de produtos e executa os itens pedidos no exercicio:

- filtrar produtos da categoria `Eletronicos` usando `forEach` com `if`;
- repetir o filtro usando `stream()` e `filter()`;
- criar uma lista apenas com os precos maiores que `500.0` usando `filter()` e `map()`;
- calcular o valor total dos produtos da categoria `Livros` usando `mapToDouble()` e `sum()`;
- buscar produto por nome retornando `Optional<Produto>`;
- usar `ifPresent()` para produto existente;
- usar `orElseThrow()` para produto inexistente;
- gerar uma lista de nomes usando lambda e referencia de metodo.

## Estrutura

```text
Exercicios/
  src/
    App.java
    Produto.java
```

## Como executar

Dentro da pasta `Exercicios`, compile os arquivos:

```bash
javac -encoding UTF-8 -d bin src/Produto.java src/App.java
```

Depois execute:

```bash
java -cp bin App
```

## Observacao

Os textos foram escritos sem acentuacao para evitar problemas de exibicao no terminal do Windows.
