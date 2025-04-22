package com.willyan.springjpa.projection;

import org.springframework.beans.factory.annotation.Value;

public interface AutorInfoProjection {

    @Value("#{target.nome + ' ' + target.sobrenome}")
    String getNomeCompleto();

    String getCargo();

    String getBio();

}
