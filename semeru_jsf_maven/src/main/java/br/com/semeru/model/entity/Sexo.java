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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Dih-DesktopW10
 */
@Entity
@Table(name = "sexo")
public class Sexo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "idSexo", nullable = false)
    private Integer idSexo;

    @Column(name = "descricao", nullable = false, unique = true, length = 9)
    private String descricao;

    @OneToMany(mappedBy = "sexo", fetch = FetchType.LAZY)//um sexo para cada pessoa, e varias pessoas podem ter 1 sexo
    @ForeignKey(name = "pessoaSexo")
    private List<PessoaEntity> pessoasEntity;

    public Sexo() {

    }

    public Integer getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(Integer idSexo) {
        this.idSexo = idSexo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<PessoaEntity> getPessoas() {
        return pessoasEntity;
    }

    public void setPessoas(List<PessoaEntity> pessoas) {
        this.pessoasEntity = pessoas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.idSexo != null ? this.idSexo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sexo other = (Sexo) obj;
        if (this.idSexo != other.idSexo && (this.idSexo == null || !this.idSexo.equals(other.idSexo))) {
            return false;
        }
        return true;
    }

}
