package br.com.flatmap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Main.class);
        springApplication.addListeners(new ApplicationPidFileWriter());
        springApplication.run(args);

        run();
    }

    private static void run(){
        Fornecedor fornecedor = new Fornecedor("Nestle", "33174582", "Rua Amapá, 35");
        Fornecedor fornecedor2 = new Fornecedor("Garoto", "44568799", "Rua Brasil, 44");
         Produto produto1 = new Produto("barra chocolate", BigDecimal.valueOf(5.99), "300g", fornecedor2);
        Produto produto2 = new Produto("barra pequena chocolate", BigDecimal.valueOf(2), "100g", fornecedor);
        Produto produto3 = new Produto("sorvete", BigDecimal.valueOf(5.99), "1L", fornecedor2);
        Produto produto4 = new Produto("barra chocolate", BigDecimal.valueOf(6), "1L", fornecedor);

        List<Produto> produtoList = Arrays.asList(produto1, produto2, produto3, produto4);

        Map<BigDecimal, List<Produto>> collectByPreco =
                produtoList.stream().collect(
                        Collectors.groupingBy(Produto::getPreco));

        Map<Fornecedor, List<Produto>> collectByFornecedor =
                produtoList.stream().collect(
                        Collectors.groupingBy(Produto::getFornecedor));

        System.out.println("\n#########################");
        System.out.println(collectByPreco);
        System.out.println("#########################\n");

        System.out.println("\n#########################");
        System.out.println(collectByFornecedor);
        System.out.println("#########################\n");
    }
}