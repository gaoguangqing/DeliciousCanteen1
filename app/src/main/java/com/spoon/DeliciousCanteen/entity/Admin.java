package com.spoon.DeliciousCanteen.entity;

/**
 * Created by Administrator on 2015/7/23.
 */
public class Admin {
    private String AdmId;
    private String AdmName;
    private String AdmPassWord;

    public Admin(String admId, String admName, String admPassWord) {
        AdmId = admId;
        AdmName = admName;
        AdmPassWord = admPassWord;
    }

    public String getAdmId() {
        return AdmId;
    }

    public void setAdmId(String admId) {
        AdmId = admId;
    }

    public String getAdmName() {
        return AdmName;
    }

    public void setAdmName(String admName) {
        AdmName = admName;
    }

    public String getAdmPassWord() {
        return AdmPassWord;
    }

    public void setAdmPassWord(String admPassWord) {
        AdmPassWord = admPassWord;
    }
}
