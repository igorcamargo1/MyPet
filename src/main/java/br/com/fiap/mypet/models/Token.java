package br.com.fiap.mypet.models;

public record Token(
    String token,
    String type,
    String prefix
    ){}
