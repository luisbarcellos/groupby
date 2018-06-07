package br.com.flatmap;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Fornecedor {
    private String nome;
    private String telefone;
    private String endereco;
}