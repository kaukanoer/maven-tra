/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.tra.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kaukanoer
 */
@Entity
@Table(name = "settlements")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Settlements.findAll", query = "SELECT s FROM Settlements s")
    , @NamedQuery(name = "Settlements.findById", query = "SELECT s FROM Settlements s WHERE s.id = :id")
    , @NamedQuery(name = "Settlements.findByNota", query = "SELECT s FROM Settlements s WHERE s.nota = :nota")
    , @NamedQuery(name = "Settlements.findByKeterangan", query = "SELECT s FROM Settlements s WHERE s.keterangan = :keterangan")
    , @NamedQuery(name = "Settlements.findByTransport", query = "SELECT s FROM Settlements s WHERE s.transport = :transport")
    , @NamedQuery(name = "Settlements.findByTanggal", query = "SELECT s FROM Settlements s WHERE s.tanggal = :tanggal")
    , @NamedQuery(name = "Settlements.findByIsDelete", query = "SELECT s FROM Settlements s WHERE s.isDelete = :isDelete")})
public class Settlements implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nota")
    private String nota;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "keterangan")
    private String keterangan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "transport")
    private String transport;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tanggal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tanggal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "is_delete")
    private String isDelete;
    @JoinColumn(name = "request_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Requests requestId;

    public Settlements() {
    }

    public Settlements(String id) {
        this.id = id;
    }

    public Settlements(String id, String nota, String keterangan, String transport, Date tanggal, String isDelete) {
        this.id = id;
        this.nota = nota;
        this.keterangan = keterangan;
        this.transport = transport;
        this.tanggal = tanggal;
        this.isDelete = isDelete;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public Requests getRequestId() {
        return requestId;
    }

    public void setRequestId(Requests requestId) {
        this.requestId = requestId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Settlements)) {
            return false;
        }
        Settlements other = (Settlements) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.spring.tra.entity.Settlements[ id=" + id + " ]";
    }
    
}
