package com.beec.ss08.entity;

public class ChkItem {
    private String title;
    private boolean isChecked;
    private String imgSrc;
    private String desc;
    private float qty;

    public ChkItem(String title, String imgSrc, String desc , float qty) {
        this.title = title;
        this.isChecked = false;
        this.imgSrc = imgSrc;
        this.desc = desc;
        this.qty = qty;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getQty() {
        return qty;
    }

    public void setQty(float qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "ChkItem{" +
                "title='" + title + '\'' +
                ", isChecked=" + isChecked +
                ", imgSrc='" + imgSrc + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
