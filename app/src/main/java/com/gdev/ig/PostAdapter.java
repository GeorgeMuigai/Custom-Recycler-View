package com.gdev.ig;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    List<Hits> hitsList;

    public PostAdapter(List<Hits> hitsList) {
        this.hitsList = hitsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Hits hits = hitsList.get(position);
        try {
            Picasso.get().load(hits.getUserImageURL()).into(holder.img_user);
            Picasso.get().load(hits.getLargeImageURL()).into(holder.img_post);
        }catch (Exception e)
        {
            //Toast.makeText(holder.itemView.getContext(), e.toString(), Toast.LENGTH_LONG).show();
        }

        holder.txt_username.setText(hits.getUser());
        holder.txt_img_type.setText(hits.getType());
        holder.txt_likes.setText(hits.getLikes());
        holder.txt_comments.setText(hits.getComments());
        holder.txt_views.setText(hits.getViews());

        // downloading the image
        holder.ic_download.setOnClickListener(View ->{
            Toast.makeText(View.getContext(), "Downloading image posted by user " + hits.getUser() , Toast.LENGTH_LONG).show();
        });
    }

    @Override
    public int getItemCount() {
        return hitsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img_user, img_post, ic_download;
        TextView txt_username, txt_img_type, txt_likes, txt_comments, txt_views;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img_user = itemView.findViewById(R.id.img_user);
            img_post = itemView.findViewById(R.id.img_post);
            ic_download = itemView.findViewById(R.id.img_download);

            txt_username = itemView.findViewById(R.id.txt_username);
            txt_img_type = itemView.findViewById(R.id.txt_img_type);
            txt_likes = itemView.findViewById(R.id.txt_likes);
            txt_comments = itemView.findViewById(R.id.txt_comments);
            txt_views = itemView.findViewById(R.id.txt_views);
        }
    }
}
