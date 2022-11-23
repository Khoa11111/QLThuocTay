package com.google.qlthuoctay;

public class ThuocTay {
    public String ten,congdung,sl;
    public int hinhanh;

    public ThuocTay() {
    }

    public ThuocTay(String ten, String congdung, String sl) {
        this.ten = ten;
        this.congdung = congdung;
        this.sl = sl;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getCongdung() {
        return congdung;
    }

    public void setCongdung(String congdung) {
        this.congdung = congdung;
    }

    public String getSl() {
        return sl;
    }

    public void setSl(String sl) {
        this.sl = sl;
    }

    public int getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(int hinhanh) {
        this.hinhanh = hinhanh;
    }
}
