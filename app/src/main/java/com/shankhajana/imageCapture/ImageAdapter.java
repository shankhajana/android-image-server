package com.shankhajana.imageCapture;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.myviewholder>
{
    List<GalleryResponseBody> data;
    Context context;

    public ImageAdapter(List<GalleryResponseBody> galleryResponseBodies, Context context)
    {
        this.data = galleryResponseBodies;
        this.context = context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.singlerow,parent,false);
        return  new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position)
    {
         GalleryResponseBody imgMetadata= data.get(position);
         holder.tv.setText(imgMetadata.getTitle());
        // String fileUrl="http://192.168.0.106:8000/"+imgMetadata.getUploadedFileName();
        String fileUrl= EndpointUtil.getBaseURI(context.getApplicationContext())
                +"/"+imgMetadata.getUploadedFileName();

         Glide.with(holder.img.getContext()).load(fileUrl).into(holder.img);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Log.e("ITEM CLICK","item clicked !" +fileUrl);
               Intent intent= new Intent( context,FullScreenActivity.class);
                intent.putExtra("image_url",fileUrl);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder
   {
        ImageView img;
        TextView tv;
       public myviewholder(@NonNull View itemView)
       {
           super(itemView);
           img=(ImageView)itemView.findViewById(R.id.imageholder);
           tv=(TextView)itemView.findViewById(R.id.img_desc);
       }
   }
}
