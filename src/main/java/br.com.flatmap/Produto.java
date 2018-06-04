package br.com.flatmap;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Produto {
    private String nome;
    private BigDecimal preco;
    private String peso;
}