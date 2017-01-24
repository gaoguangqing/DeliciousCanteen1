package com.spoon.DeliciousCanteen;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.spoon.DeliciousCanteen.dao.DAO;
import com.spoon.DeliciousCanteen.entity.Cart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/7/19.
 */
public class OrderActivity extends Activity {

    DAO dao;
    LvCartAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);


        dao=new DAO(getApplicationContext());



        Cursor cursor=dao.select(1);
        List<Cart> list=new ArrayList<Cart>();
        while (cursor.moveToNext()){
            String name=cursor.getString(cursor.getColumnIndex("name"));
            Double price=cursor.getDouble(cursor.getColumnIndex("price"));
            Cart cartItem=new Cart();
            cartItem.setName(name);
            cartItem.setPrice(price);
            list.add(cartItem);
            System.out.println(1);
        }
        ListView listView= (ListView) findViewById(R.id.lvCart);
        adapter=new LvCartAdapter(list);
        listView.setAdapter(adapter);


        findViewById(R.id.buttonUnbock).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.buttonSure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OrderActivity.this,BuySucceedActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


    private class LvCartAdapter extends BaseAdapter{
        private List<Cart> lists;
        public LvCartAdapter(List<Cart> list) {
            lists=list;
        }

        @Override
        public int getCount() {
            return lists.size();
        }

        @Override
        public Object getItem(int i) {
            return lists.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder holder;
            if(view==null){
                holder=new ViewHolder();
                view=View.inflate(getApplicationContext(),R.layout.cart_item,null);
                holder.tvName= (TextView) view.findViewById(R.id.tvCName);
                holder.tvPrice= (TextView) view.findViewById(R.id.tvCPrice);
                view.setTag(holder);
            }else {
                holder=(ViewHolder) view.getTag();
            }
            holder.tvName.setText(lists.get(i).getName());
            holder.tvPrice.setText(lists.get(i).getPrice()+"");
            return view;
        }
        class ViewHolder {
            TextView tvName;
            TextView tvPrice;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}