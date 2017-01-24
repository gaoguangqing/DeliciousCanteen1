package com.spoon.DeliciousCanteen.entity;

/**
 * Created by Administrator on 2015/7/23.
 */
public class StudentAccount {
    private String StuAccountNumber ;
    private String StuName;
    private String StuPassWord;
    private float StuBalance;



    public float getStuBalance() {
        return StuBalance;
    }

    public void setStuBalance(float stuBalance) {
        StuBalance = stuBalance;
    }
}
