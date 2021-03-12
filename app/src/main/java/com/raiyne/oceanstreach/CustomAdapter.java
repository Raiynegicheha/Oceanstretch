package com.raiyne.oceanstreach;

import android.content.Context;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context mcontext;
    ArrayList<Animals> data;

    public CustomAdapter(Context mcontext, ArrayList<Animals> data) {
        this.mcontext = mcontext;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            LayoutInflater inflater =((Activity) mcontext).getLayoutInflater();
            convertView = inflater.inflate(R.layout.animals_layout,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.mytvname = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.mytvemail = (TextView) convertView.findViewById(R.id.tv_email);
            viewHolder.mytvcontact = (TextView) convertView.findViewById(R.id.tv_contact);
            viewHolder.mytvdescription = (TextView) convertView.findViewById(R.id.tv_description);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Animals animals = data.get(position);
        viewHolder.mytvname.setText(animals.getName());
        viewHolder.mytvemail.setText(animals.getEmail());
        viewHolder.mytvcontact.setText(animals.getContact());
        viewHolder.mytvdescription.setText(animals.getDescription());
        return convertView;
    }

    static class ViewHolder{
        TextView mytvname,mytvemail,mytvcontact,mytvdescription;
    }
}
