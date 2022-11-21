package org.thereachtrust.wallpaper.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.thereachtrust.wallpaper.Models.Photo;
import org.thereachtrust.wallpaper.R;
import org.thereachtrust.wallpaper.Utils.SquareImage;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.ViewHolder> {
    private Context context;
    private List<Photo> photos;
    public PhotosAdapter(Context context, List<Photo> photos){
      this.context= context;
      this.photos= photos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_photo, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Photo photo= photos.get(position);
        holder.username.setText(photo.getUser().getUsername());

//        GlideApp.with(context)
//                .load(photo.getUrl().getRegular())
//                .placeholder(R.drawable.placeholder)
//                .Override(600,600)
//                .into(holder.photo);

    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.item_photo_user)
        CircleImageView user;
        @BindView(R.id.item_photo_username)
        TextView username;
        @BindView(R.id.item_photo_photo)
        SquareImage photo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
