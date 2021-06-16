package com.example.peterpan;

public class Pengajuan {
    private String key;

    private String nim;
    private String nama;
    private String namaDosen;
    private String matkul;
    private String tgl;
    private String sesi;

    public Pengajuan(){
    }

    public Pengajuan(String nim, String nama, String namaDosen, String matkul, String tgl, String sesi) {
        this.nim = nim;
        this.nama = nama;
        this.namaDosen = namaDosen;
        this.matkul = matkul;
        this.tgl = tgl;
        this.sesi = sesi;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNamaDosen() {
        return namaDosen;
    }

    public void setNamaDosen(String namaDosen) {
        this.namaDosen = namaDosen;
    }

    public String getMatkul() {
        return matkul;
    }

    public void setMatkul(String matkul) {
        this.matkul = matkul;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public String getSesi() {
        return sesi;
    }

    public void setSesi(String sesi) {
        this.sesi = sesi;
    }
}
