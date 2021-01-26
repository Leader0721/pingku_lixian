package com.example.ckxt_yezhan.database;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = MyDatabase.class)
public class WuziTable extends BaseModel {
    @Column
    @PrimaryKey(autoincrement = true)
    private int id_wuzi;
    @Column
    private String wuzimc;

    public int getId_wuzi() {
        return id_wuzi;
    }

    public void setId_wuzi(int id_wuzi) {
        this.id_wuzi = id_wuzi;
    }

    public String getWuzimc() {
        return wuzimc;
    }

    public void setWuzimc(String wuzimc) {
        this.wuzimc = wuzimc;
    }
}
