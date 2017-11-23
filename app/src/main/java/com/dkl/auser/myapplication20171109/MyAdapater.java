package com.dkl.auser.myapplication20171109;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

/**
 * Created by auser on 2017/11/9.
 */

public class MyAdapater extends BaseAdapter {

    Context context;
    String str[];
    boolean b[] ;
    public MyAdapater (Context context ,String[] str)
    {this.context = context;this.str=str;   b = new boolean[str.length];}
    @Override
    public int getCount() {
     return str.length;
        }






    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View converView, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        Log.d("GETVIEW", "position:" + position);
        ViewHolder vh= new ViewHolder();

        if(converView==null){
            converView = inflater.inflate(R.layout.myitem,null);

//        vh = new ViewHolder();

            vh.tv =  (TextView)converView.findViewById(R.id.textView);
            vh.bt = (Button)converView.findViewById(R.id.button);
            vh.cb =(CheckBox)converView.findViewById(R.id.checkBox);
            converView.setTag(vh);
        }else {
            vh = (ViewHolder)converView.getTag();

        }

//        View v = view.inflate(this.context,R.layout.myitem,null);
//        Log.d("GETVIEW","POSITION"+position);
//        TextView tv = new TextView(context);

        final String msg = str[position];
        vh.bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
            }
        });

        vh.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

b[position]=isChecked;
//                msg = new String.valueOf(boolean b);
                Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();

            }
        });
        vh.cb.setChecked(b[position]);
        vh.tv.setText(str[position]);
        return converView;
    }

    static class ViewHolder{
        TextView tv;
        Button bt;
        CheckBox cb;

    }


}
