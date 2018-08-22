package com.example.user.sensormanager;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class SensorAdapter extends RecyclerView.Adapter<SensorAdapter.ViewHolder> {
    public List<SensorDiscription> sensorList;
    private LayoutInflater mIflater;
    private Context mContext;

    public SensorAdapter(Context context, List<SensorDiscription> list) {
    this.mContext=context;
    this.sensorList=list;
    this.mIflater=LayoutInflater.from(context); }

    public SensorAdapter(List<Sensor> sensorslist) {
    }


    @Override
    public SensorAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view=mIflater.inflate(R.layout.adapter_item, parent,false);
        final ViewHolder viewHolder=new ViewHolder(view);
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int position=viewHolder.getAdapterPosition();
//                Intent intent=new Intent(mContext,TwoActivity.class);
//                System.out.println(position);
//                intent.putExtra(TwoActivity.SENSORS_ITEM, (Serializable) sensorDescriptionList.get(position));
//                mContext.startActivity(intent);
//
//            }
//        }
//        );
        return new ViewHolder(view);
        }
    @Override
    public void onBindViewHolder(SensorAdapter.ViewHolder viewHolder, final int position) {
        final SensorDiscription sensor=sensorList.get(position);
        viewHolder.name.setText(sensor.getName());
        viewHolder.type.setText(sensor.getType());
        viewHolder.vendor.setText(sensor.getVendor());
        viewHolder.version.setText(sensor.getVersion());
        viewHolder.max.setText(sensor.getMax());
        viewHolder.resolution.setText(sensor.getResolution());
        viewHolder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent=new Intent(mContext, AccelerometrActivity.class);
                System.out.println(position);
                intent.putExtra(AccelerometrActivity.SENSORS_ITEM, (Parcelable) sensor);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return
                (sensorList==null) ? 0 : sensorList.size();
    }
    public class ViewHolder  extends  RecyclerView.ViewHolder{
        TextView name;
        TextView type;
        TextView vendor;
        TextView version;
        TextView max;
        TextView resolution;
//       private List<Sensor> sensorDescriptionList;
        public ViewHolder(View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.name);
            type=(TextView) itemView.findViewById(R.id.type);
            vendor=(TextView)itemView.findViewById(R.id.vendor);
            version=(TextView) itemView.findViewById(R.id.version);
            max=(TextView) itemView.findViewById(R.id.max);
            resolution=(TextView) itemView.findViewById(R.id.resolution);
        }
    }
    }

