/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.semeru.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "endereco")
class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "idEndereco", nullable = false)
    private Integer idEndereco;

    @Column(name= "bairro", length = 80)
    private String bairro;
    
    @Column(name="nomeLogradouro", length = 100)
    private String nomeLogradouro;
    
    @Column(name= "nomeCep", length = 11)
    private String nomeCep;
    
    @Column(name="numero")
    private Integer numero; 
    
    @Column(name="complemento", length = 100)
    private String complemento;
    
    
//    @Column(name = "descricaoEndereco", nullable = false, length = 40)
//    private String descricaoEndereco;

    @OneToMany
    @ForeignKey(name = "enderecoTipoLogradouro")
    private List<Endereco> enderecos;
    
    public Endereco(){
        
    }
    
    
}
