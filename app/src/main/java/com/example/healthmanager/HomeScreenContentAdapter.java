package com.example.healthmanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HomeScreenContentAdapter extends RecyclerView.Adapter<HomeScreenContentAdapter.ContentVH> {

    List<HomeScreenContent> homeScreenContentList;

    public HomeScreenContentAdapter(List<HomeScreenContent> homeScreenContentList) {
        this.homeScreenContentList = homeScreenContentList;
    }

    @NonNull
    @Override
    public ContentVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_row, parent, false);
        return new ContentVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentVH holder, int position) {
        HomeScreenContent homeScreenContent = homeScreenContentList.get(position);
        holder.titleTxt.setText(homeScreenContent.getTitle());
        holder.contentTxt.setText(homeScreenContent.getContent());

        boolean isExpandable = homeScreenContentList.get(position).isExpandable();
        holder.expandableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return homeScreenContentList.size();
    }

    public class ContentVH extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;
        RelativeLayout expandableLayout;

        TextView titleTxt, contentTxt;

        public ContentVH(@NonNull View itemView) {
            super(itemView);

            titleTxt = itemView.findViewById(R.id.contentTitle);
            contentTxt = itemView.findViewById(R.id.content);

            linearLayout = itemView.findViewById(R.id.homeLinearLayout);
            expandableLayout = itemView.findViewById(R.id.expandableHomeAbout);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HomeScreenContent homeScreenContent = homeScreenContentList.get(getAdapterPosition());
                    homeScreenContent.setExpandable(!homeScreenContent.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
