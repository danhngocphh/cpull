/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author TrungNguyen
 */
public class MatHang implements Serializable{
    private int id;
    private String ten;
    private String loai;
    private String ngaysx;
    private String handung;
    private float gia;
    private float soluong;
    private String mota;

    public MatHang() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getNgaysx() {
        return ngaysx;
    }

    public void setNgaysx(String ngaysx) {
        this.ngaysx = ngaysx;
    }

    public String getHandung() {
        return handung;
    }

    public void setHandung(String handung) {
        this.handung = handung;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public float getSoluong() {
        return soluong;
    }

    public void setSoluong(float soluong) {
        this.soluong = soluong;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
    
    public Object[] toObject(){
        return new Object[]{
            id,ten,loai,ngaysx,handung,gia,soluong,mota
        };
    }
}
