package com.kmtstudio.myrecyclerviewdemo6;

import android.view.View;

public interface ClickListener {

    void setOnItemClick(int position, View v);
    void setOnItemLongClick(int position,View v);
}
