package com.example.hussnain.listview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private RecyclerView recyclerView;
private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.context=this;
        recyclerView=findViewById(R.id.list_item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        OurAdapter ourAdapter=new OurAdapter();
        recyclerView.setAdapter(ourAdapter);
    }
    private class OurAdapter extends RecyclerView.Adapter<OurAdapter.ViewHolder>{
         String []names={
                 "pistol",
                  "rugr",
                 "daypockckt",
                 "rewalwer",
                 "moser"
         };
         Integer[]images={
                 R.drawable.archive,
                 R.drawable.daypocket,
                 R.drawable.engraving,
                 R.drawable.heckler,
                 R.drawable.handgun
         };
         String[]description={"d=1",
                 "d=2",
                 "d=3",
                 "d=4",
                 "d=5"
         };

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_view,parent,false
            ));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
        String name=names [position];
        holder.nametextview.setText(name);
        holder.descriptiontextview.setText(description[position]);
        holder.imageView.setImageResource(images[position]);

        }

        @Override
        public int getItemCount() {
            return names.length;
        }
        class ViewHolder extends RecyclerView.ViewHolder {
            TextView nametextview;
            TextView descriptiontextview;
            ImageView imageView;
            public ViewHolder(View itemView) {
                super(itemView);
                nametextview=itemView.findViewById(R.id.nameview);
                descriptiontextview=itemView.findViewById(R.id.descriptionview);
                imageView=itemView.findViewById(R.id.tvimageview);
            }
        }
    }
}
