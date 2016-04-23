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
@Table(name = "tipoLogradouro")
public class TipoLogradouro implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "idTipoLogradouro", nullable = false)
    private Integer idSexo;

    @Column(name = "descricaoTipoLogradouro", nullable = false, length = 40)
    private String descricaoTipoLogradouro;

    @OneToMany
    @ForeignKey(name = "enderecoTipoLogradouro")
    private List<Endereco> enderecos;
    
    public TipoLogradouro(){
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.idSexo != null ? this.idSexo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoLogradouro other = (TipoLogradouro) obj;
        if (this.idSexo != other.idSexo && (this.idSexo == null || !this.idSexo.equals(other.idSexo))) {
            return false;
        }
        return true;
    }
    
    
}
