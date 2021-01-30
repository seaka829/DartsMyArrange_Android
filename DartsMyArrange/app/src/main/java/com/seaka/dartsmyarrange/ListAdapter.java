package com.seaka.dartsmyarrange;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends ArrayAdapter<ArrangeItem> {

    private int               resource;
    private List<ArrangeItem> items;
    private LayoutInflater    layoutInflater;

    private TextView totalPointTextView;    // 合計点数のテキストビュー
    private TextView firstPointTextView;    // 一投目点数のテキストビュー
    private TextView secondPointTextView;   // 二投目点数のテキストビュー
    private TextView thirdPointTextView;    // 三投目点数のテキストビュー


    public ListAdapter(Context context, int resource, List<ArrangeItem> items) {
        super(context, resource, items);

        this.resource  = resource;
        this.items     = items;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // ビューの取得
        View view;
        if (convertView != null) {
            view = convertView;
        } else {
            view = layoutInflater.inflate(resource, null);
        }

        // アイテムの取得
        ArrangeItem item = items.get(position);

        // UIの取得
        totalPointTextView  = view.findViewById(R.id.total_point_textview);
        firstPointTextView  = view.findViewById(R.id.first_point_textview);
        secondPointTextView = view.findViewById(R.id.second_point_textview);
        thirdPointTextView  = view.findViewById(R.id.third_point_textview);

        // UIの設定



        return view;
    }
}
