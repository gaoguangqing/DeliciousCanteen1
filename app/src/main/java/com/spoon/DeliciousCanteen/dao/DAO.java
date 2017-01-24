package com.spoon.DeliciousCanteen.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.spoon.DeliciousCanteen.entity.Food;
import com.spoon.DeliciousCanteen.DBHelper;

import java.util.List;

/**
 * Created by ggq on 2016/7/14.
 */
public class DAO {
    private Context mContext;
    private SQLiteDatabase db;//数据库操作对象
    private DBHelper dbHelper;
    public DAO(Context context){
        mContext=context;
        dbHelper=new DBHelper(context);
        db=dbHelper.getWritableDatabase();
    }
    public void addData(List<Food> list){

//        int id;
//        int foodPicture;
//        String name;
//        double price;
//        int amount;
//        double score;
        //相当于HashMap 由安卓提供
        for (int i=0;i<list.size();i++) {
            ContentValues values = new ContentValues();
            values.put("id", list.get(i).getId());
            values.put("foodPicture", list.get(i).getFoodPicture());
            values.put("name", list.get(i).getName());
            values.put("price", list.get(i).getPrice());
            values.put("score", list.get(i).getScore());
            values.put("isCheck",list.get(i).getIsCheck());
            //                   表名    列
            db.insert(DBHelper.tableName, null, values);//添加数据
        }
    }
    public Cursor select(String id){
        String[]columns={"id","foodPicture","name","price","score","isCheck"};
        //表名 查询的列（显示的列(字段)）查询条件 查询条件的参数 分组 having(分组条件) 排序
//        Cursor cursor=db.query(DBHelper.tableName,columns,"studentId="+studentId,null,"name","age>20","studentId desc");
        Cursor cursor=db.query(DBHelper.tableName,columns,"id="+id,null,null,null,null);
        return cursor;
    }
    public Cursor select(){
        String[]columns={"id","foodPicture","name","price","score","isCheck"};
        //表名 查询的列（显示的列(字段)）查询条件 查询条件的参数 分组 having(分组条件) 排序
//        Cursor cursor=db.query(DBHelper.tableName,columns,"studentId="+studentId,null,"name","age>20","studentId desc");
        Cursor cursor=db.query(DBHelper.tableName,columns,null,null,null,null,null);
        return cursor;
    }
    public Cursor select(int check){
        String[]columns={"id","foodPicture","name","price","score","isCheck"};
        //表名 查询的列（显示的列(字段)）查询条件 查询条件的参数 分组 having(分组条件) 排序
//        Cursor cursor=db.query(DBHelper.tableName,columns,"studentId="+studentId,null,"name","age>20","studentId desc");
        Cursor cursor=db.query(DBHelper.tableName,columns,"isCheck="+check,null,null,null,null);
        return cursor;
    }

    public boolean updateData(int isCheck,int id){
        ContentValues values=new ContentValues();
        values.put("isCheck",isCheck);
        int row=db.update(DBHelper.tableName,values,"id="+id,null);
        return row>0;
    }

}
