package modelo;

import produto.Produto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ListaCompras {

    private final List<Produto> produtos;

    public ListaCompras(){
        this.produtos = new ArrayList<>();
    }

    public void adicionarProdutos(String nome, BigDecimal preco){
        Produto produto = new Produto(nome, preco);
        produtos.add(produto);
    }

    public BigDecimal calcularTotal() {
        BigDecimal total = BigDecimal.ZERO;

        for (Produto produto : produtos) {
            total = total.add(produto.getPreco());
        }

        return total;
    }
}