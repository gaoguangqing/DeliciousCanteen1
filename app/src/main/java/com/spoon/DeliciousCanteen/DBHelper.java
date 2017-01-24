package com.spoon.DeliciousCanteen;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2015/7/23.
 */
public class DBHelper extends SQLiteOpenHelper {
    public static String db_name="canteen.db";
    public static int version=1;
    public static String tableName="food";
    public DBHelper(Context context) {
        super(context, db_name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql="create table "+tableName+"(id integer primary key,foodPicture integer,name text,price double,score double,isCheck integer)";
        db.execSQL(sql);
        String insert1="insert into "+tableName+"(id,foodPicture,name,price,score,isCheck)values (?,?,?,?,?,?) ";//插入数据
        db.execSQL(insert1,new Object[]{1,R.drawable.f1,"红烧丸子",9.75,2.5,0});
        String insert2="insert into "+tableName+"(id,foodPicture,name,price,score,isCheck)values (?,?,?,?,?,?) ";//插入数据
        db.execSQL(insert2,new Object[]{2,R.drawable.f2,"豆芽",2.75,3.5,0});
        String insert3="insert into "+tableName+"(id,foodPicture,name,price,score,isCheck)values (?,?,?,?,?,?) ";//插入数据
        db.execSQL(insert3,new Object[]{3,R.drawable.f3,"水煮肉",6.75,4.5,0});
        String insert4="insert into "+tableName+"(id,foodPicture,name,price,score,isCheck)values (?,?,?,?,?,?) ";//插入数据
        db.execSQL(insert4,new Object[]{4,R.drawable.f4,"火腿肉",8.75,4.5,0});
        String insert5="insert into "+tableName+"(id,foodPicture,name,price,score,isCheck)values (?,?,?,?,?,?) ";//插入数据
        db.execSQL(insert5,new Object[]{5,R.drawable.f5,"鱼香肉丝",7.75,4.5,0});
        String insert6="insert into "+tableName+"(id,foodPicture,name,price,score,isCheck)values (?,?,?,?,?,?) ";//插入数据
        db.execSQL(insert6,new Object[]{6,R.drawable.f6,"冬瓜丸子",4.25,3.5,0});

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
