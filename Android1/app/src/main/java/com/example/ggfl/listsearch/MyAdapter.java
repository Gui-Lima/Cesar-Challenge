package com.example.ggfl.listsearch;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<RecyclerListItem> fixedItems;
    private ArrayList<RecyclerListItem> filteredItems;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context, ArrayList<RecyclerListItem> al){
        this.fixedItems = al;
        this.filteredItems = (ArrayList<RecyclerListItem>) fixedItems.clone();
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.recycler_list_item, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
            myViewHolder.content_text.setText(String.valueOf(filteredItems.get(i).getContent()));
            myViewHolder.title_text.setText(filteredItems.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return this.filteredItems.size();
    }

    public void setList(ArrayList<RecyclerListItem> r){
        this.fixedItems = r;
        this.filteredItems = r;
    }

    public void filter(String filter){
        JumbledLetters jl = new JumbledLetters();
        CheckTypos ct = new CheckTypos();
        this.filteredItems.clear();
        for (RecyclerListItem r : this.fixedItems){
            Boolean found = false;
            for (String words : r.getTitle().split(" ")){
                words = words.toLowerCase();
                filter = filter.toLowerCase();
                if (words.equals(filter) ||  jl.isPartialPermutation(words, filter) || ct.isTypo(words, filter)){
                    this.filteredItems.add(r);
                    found = true;
                    break;
                }
            }
            if (found) continue;
            for(String words : r.getContent().split(" ")){
                boolean partialPermutation = jl.isPartialPermutation(words, filter);
                boolean typo = ct.isTypo(words, filter);
                if ((words.equals(filter) ||  partialPermutation || typo) && !(partialPermutation && typo)){
                    this.filteredItems.add(r);
                    break;
                }
            }
        }
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView content_text;
        TextView title_text;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title_text = itemView.findViewById(R.id.item_title);
            content_text = itemView.findViewById(R.id.item_content);
        }
    }
}
