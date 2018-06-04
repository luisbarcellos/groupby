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
         Produto produto1 = new Produto("barra chocolate", BigDecimal.valueOf(5.99), "300g");
        Produto produto2 = new Produto("barra pequena chocolate", BigDecimal.valueOf(2), "100g");
        Produto produto3 = new Produto("sorvete", BigDecimal.valueOf(5.99), "1L");
        Produto produto4 = new Produto("barra chocolate", BigDecimal.valueOf(6), "1L");

        List<Produto> produtoList = Arrays.asList(produto1, produto2, produto3, produto4);

        Map<BigDecimal, List<Produto>> result =
                produtoList.stream().collect(
                        Collectors.groupingBy(Produto::getPreco));

        System.out.println("\n#########################");
        System.out.println(result);
        System.out.println("#########################\n");
    }
}