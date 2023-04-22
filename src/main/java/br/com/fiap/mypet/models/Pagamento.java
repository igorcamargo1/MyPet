package br.com.fiap.mypet.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Pagamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String tp_pagamento;

    @NotBlank
    private String tp_cartao;

    public Pagamento(String tp_pagamento, String tp_cartao){
        this.tp_pagamento = tp_pagamento;
        this.tp_cartao = tp_cartao;
    }

    protected Pagamento(){
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }


    public String getTp_pagamento(){
        return tp_pagamento;
    }

    public void setTp_pagamento(String tp_pagamento){
        this.tp_pagamento = tp_pagamento;
    }

    public String getTp_cartao(){
        return tp_cartao;
    }

    public void setTp_cartao(String tp_cartao){
        this.tp_cartao = tp_cartao;
    }
}
