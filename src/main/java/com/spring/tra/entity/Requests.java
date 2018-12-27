/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.tra.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kaukanoer
 */
@Entity
@Table(name = "requests")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requests.findAll", query = "SELECT r FROM Requests r")
    , @NamedQuery(name = "Requests.findById", query = "SELECT r FROM Requests r WHERE r.id = :id")
    , @NamedQuery(name = "Requests.findByKeperluan", query = "SELECT r FROM Requests r WHERE r.keperluan = :keperluan")
    , @NamedQuery(name = "Requests.findByTransportBerangkat", query = "SELECT r FROM Requests r WHERE r.transportBerangkat = :transportBerangkat")
    , @NamedQuery(name = "Requests.findByTanggalBerangkat", query = "SELECT r FROM Requests r WHERE r.tanggalBerangkat = :tanggalBerangkat")
    , @NamedQuery(name = "Requests.findByTransportPulang", query = "SELECT r FROM Requests r WHERE r.transportPulang = :transportPulang")
    , @NamedQuery(name = "Requests.findByTanggalPulang", query = "SELECT r FROM Requests r WHERE r.tanggalPulang = :tanggalPulang")
    , @NamedQuery(name = "Requests.findByHotel", query = "SELECT r FROM Requests r WHERE r.hotel = :hotel")
    , @NamedQuery(name = "Requests.findByCekIn", query = "SELECT r FROM Requests r WHERE r.cekIn = :cekIn")
    , @NamedQuery(name = "Requests.findByCekOut", query = "SELECT r FROM Requests r WHERE r.cekOut = :cekOut")
    , @NamedQuery(name = "Requests.findByCatatan", query = "SELECT r FROM Requests r WHERE r.catatan = :catatan")
    , @NamedQuery(name = "Requests.findByStatus", query = "SELECT r FROM Requests r WHERE r.status = :status")
    , @NamedQuery(name = "Requests.findByIsDelete", query = "SELECT r FROM Requests r WHERE r.isDelete = :isDelete")})
public class Requests implements Serializable {

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
    @Column(name = "keperluan")
    private String keperluan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "transport_berangkat")
    private String transportBerangkat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tanggal_berangkat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tanggalBerangkat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "transport_pulang")
    private String transportPulang;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tanggal_pulang")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tanggalPulang;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "hotel")
    private String hotel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cek_in")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cekIn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cek_out")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cekOut;
    @Size(max = 255)
    @Column(name = "catatan")
    private String catatan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "is_delete")
    private String isDelete;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requestId", fetch = FetchType.LAZY)
    private List<Settlements> settlementsList;
    @JoinColumn(name = "account_nik", referencedColumnName = "nik")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Accounts accountNik;

    public Requests() {
    }

    public Requests(String id) {
        this.id = id;
    }

    public Requests(String id, String keperluan, String transportBerangkat, Date tanggalBerangkat, String transportPulang, Date tanggalPulang, String hotel, Date cekIn, Date cekOut, String note, String status, String isDelete, Accounts account) {
        this.id = id;
        this.keperluan = keperluan;
        this.transportBerangkat = transportBerangkat;
        this.tanggalBerangkat = tanggalBerangkat;
        this.transportPulang = transportPulang;
        this.tanggalPulang = tanggalPulang;
        this.hotel = hotel;
        this.cekIn = cekIn;
        this.cekOut = cekOut;
        this.catatan = note;
        this.status = status;
        this.isDelete = isDelete;
        this.accountNik = account;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKeperluan() {
        return keperluan;
    }

    public void setKeperluan(String keperluan) {
        this.keperluan = keperluan;
    }

    public String getTransportBerangkat() {
        return transportBerangkat;
    }

    public void setTransportBerangkat(String transportBerangkat) {
        this.transportBerangkat = transportBerangkat;
    }

    public Date getTanggalBerangkat() {
        return tanggalBerangkat;
    }

    public void setTanggalBerangkat(Date tanggalBerangkat) {
        this.tanggalBerangkat = tanggalBerangkat;
    }

    public String getTransportPulang() {
        return transportPulang;
    }

    public void setTransportPulang(String transportPulang) {
        this.transportPulang = transportPulang;
    }

    public Date getTanggalPulang() {
        return tanggalPulang;
    }

    public void setTanggalPulang(Date tanggalPulang) {
        this.tanggalPulang = tanggalPulang;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public Date getCekIn() {
        return cekIn;
    }

    public void setCekIn(Date cekIn) {
        this.cekIn = cekIn;
    }

    public Date getCekOut() {
        return cekOut;
    }

    public void setCekOut(Date cekOut) {
        this.cekOut = cekOut;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    @XmlTransient
    public List<Settlements> getSettlementsList() {
        return settlementsList;
    }

    public void setSettlementsList(List<Settlements> settlementsList) {
        this.settlementsList = settlementsList;
    }

    public Accounts getAccountNik() {
        return accountNik;
    }

    public void setAccountNik(Accounts accountNik) {
        this.accountNik = accountNik;
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
        if (!(object instanceof Requests)) {
            return false;
        }
        Requests other = (Requests) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.spring.tra.entity.Requests[ id=" + id + " ]";
    }
    
}
