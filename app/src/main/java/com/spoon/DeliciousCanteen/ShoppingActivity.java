package com.spoon.DeliciousCanteen;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.spoon.DeliciousCanteen.dao.DAO;
import com.spoon.DeliciousCanteen.entity.Food;

import java.util.ArrayList;

import java.util.List;

public class ShoppingActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    List<Food> list;
    DAO dao;
    BaseAdapter baseAdapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        dao=new DAO(getApplicationContext());
        list =new ArrayList<Food>();


        findViewById(R.id.buttonBuy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i= 0;i<list.size();i++)
                {
                    if(list.get(i).getIsCheck() == 1)
                    {
                        dao.updateData(list.get(i).getIsCheck(),list.get(i).getId());
                    }else{
                        dao.updateData(list.get(i).getIsCheck(),list.get(i).getId());
                    }
                }
             Intent intent=new Intent(ShoppingActivity.this,OrderActivity.class);
                startActivity(intent);


            }
        });



        baseAdapter=new BaseAdapter() {

            public int getCount() {
                return list.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }
            MyViewHolder holder;
            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {


                if(convertView == null) {
                    holder=new MyViewHolder();
                    convertView = getLayoutInflater().inflate(R.layout.item, null);
                     holder.imageViewFoodPicture = (ImageView) convertView.findViewById(R.id.imageViewFood);
                    holder.tvName = (TextView) convertView.findViewById(R.id.textViewName);
                    holder.tvPrice = (TextView) convertView.findViewById(R.id.textView);
                    holder. tvScore = (TextView) convertView.findViewById(R.id.textVeiwScore);
                    holder.cbISBy = (CheckBox) convertView.findViewById(R.id.checkBoxIsBuy);
                    convertView.setTag(holder);
                }
                else {
                    holder = (MyViewHolder) convertView.getTag();
                }
                final Food item1=list.get(position);
                holder.imageViewFoodPicture.setImageResource(item1.getFoodPicture());

                holder.tvName.setText(item1.getName());

                holder.tvPrice.setText(item1.getPrice()+"");
                holder.tvScore.setText(item1.getScore()+"");
                holder.imageViewFoodPicture.setTag(position);
                holder.imageViewFoodPicture.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String s=list.get(position).getName();
                        Intent intent = new Intent(ShoppingActivity.this, ScoreActivity.class);
                        intent.putExtra("ta", s);
                        startActivity(intent);
                    }
                });
                holder.cbISBy.setTag(position);
                if(list.get(position).getIsCheck()==1) {
                    holder.cbISBy.setChecked(true);
                }else{
                    holder.cbISBy.setChecked(false);
                }
                holder.cbISBy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        int index = (Integer) buttonView.getTag();
                        if (isChecked) {
//                            dao.updateData(list.get(position).getId(),1);
                            list.get(index).setIsCheck(1);
//                            System.out.println(list.get(position).getName());

                        }else{
//                            dao.updateData(list.get(position).getId(),0);
                            list.get(index).setIsCheck(0);
                        }
                    }
                });
                return convertView;
            }
            class MyViewHolder {
                ImageView imageViewFoodPicture;
                TextView tvName ;
                TextView tvPrice ;
                TextView tvScore ;
                CheckBox cbISBy ;
            }
        };
        updateList();
        ListView listView= (ListView) findViewById(R.id.listView);
        listView.setAdapter(baseAdapter);

    }

    private void updateList() {

        Cursor cursor=dao.select();
        while (cursor.moveToNext()){
            Food food=new Food();
            int id=cursor.getInt(cursor.getColumnIndex("id"));
            int foodPicture=cursor.getInt(cursor.getColumnIndex("foodPicture"));
            String name=cursor.getString(cursor.getColumnIndex("name"));
            Double price=cursor.getDouble(cursor.getColumnIndex("price"));
            double score=cursor.getDouble(cursor.getColumnIndex("score"));
            int isCheck=cursor.getInt(cursor.getColumnIndex("isCheck"));
            food.setFoodPicture(foodPicture);
            food.setId(id);
            food.setName(name);
            food.setPrice(price);
            food.setScore(score);
            food.setIsCheck(isCheck);
            list.add(food);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        baseAdapter.notifyDataSetChanged();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {

           finish();

        }
        return super.onKeyDown(keyCode, event);

    }

}
