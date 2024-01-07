package service;

import modelo.ListaCompras;
import java.math.BigDecimal;
import java.util.Scanner;

public class ListaComprasService {

    private final ListaCompras listaCompras;

    public ListaComprasService(ListaCompras listaCompras) {
        this.listaCompras = listaCompras;
    }

    public void exibirCabecalho() {
        System.out.println("=== Lista de Compras do Mes ===");
    }

    public void adicionarProdutoInterativo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o produto a adicionar na lista: ");
        String nome = scanner.nextLine();

        System.out.print("Informe o valor do produto: ");
        BigDecimal preco = scanner.nextBigDecimal();

        listaCompras.adicionarProdutos(nome, preco);
    }

    public BigDecimal executar() {
        exibirCabecalho();

        char adicionarMais;
        Scanner scanner = new Scanner(System.in);
        do {
            adicionarProdutoInterativo();

            System.out.print("Deseja adicionar mais produtos? (S para Sim, N para Nao): ");
            adicionarMais = scanner.next().charAt(0);
        } while (Character.toUpperCase(adicionarMais) == 'S');

        BigDecimal valorTotal = listaCompras.calcularTotal();

        System.out.println("Valor Total da Lista: R$" + valorTotal);

        return valorTotal;
    }

    public static void main(String[] args) {
        ListaCompras listaCompras = new ListaCompras();
        ListaComprasService service = new ListaComprasService(listaCompras);
        BigDecimal valorTotal = service.executar();
    }
}