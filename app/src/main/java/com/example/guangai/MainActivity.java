package com.example.guangai;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity
{
    private GridView gridView;
    //图片的文字标题
    private String[] titles = new String[]
            { "a_33","b-33","c_33",
                    "a_32","b-32","c_32",
                    "a_31","b-31","c_31",
                    "a_30","b-30","c_30",
                    "a_29","b-29","c_29",
                    "a_28","b-28","c_28",
                    "a_27","b-27","c_27",
                    "a_26","b-26","c_26",
                    "a_25","b-25","c_25",
                    "a_24","b-24","c_24",
                    "a_23","b-23","c_23",
                    "a_22","b-22","c_22",
                    "a_21","b-21","c_21",
                    "a_20","b-20","c_20",
                    "a_19","b-19","c_19",
                    "a_18","b-18","c_18",
                    "a_17","b-17","c_17",
                    "a_16","b-16","c_16",
                    "a_15","b-15","c_15",
                    "a_14","b-14","c_14",
                    "a_13","b-13","c_13",
                    "a_12","b-12","c_12",
                    "a_11","b-11","c_11",
                    "a_10","b-10","c_10",
                    "a_9","b-9","c_9",
                    "a_8","b-8","c_8",
                    "a_7","b-7","c_7",
                    "a_6","b-6","c_6",
                    "a_5","b-5","c_5",
                    "a_4","b-4","c_4",
                    "a_3","b-3","c_3",
                    "a_2","b-2","c_2",
                    "a_1","b-1","c_1"};
    //图片ID数组
    private int[] images = new int[]{
            R.drawable.a_33,R.drawable.b_33,R.drawable.c_33,
            R.drawable.a_32,R.drawable.b_32,R.drawable.c_32,
            R.drawable.a_31,R.drawable.b_31,R.drawable.c_31,
            R.drawable.a_30,R.drawable.b_30,R.drawable.c_30,
            R.drawable.a_29,R.drawable.b_29,R.drawable.c_29,
            R.drawable.a_28,R.drawable.b_28,R.drawable.c_28,
            R.drawable.a_27,R.drawable.b_27,R.drawable.c_27,
            R.drawable.a_26,R.drawable.b_26,R.drawable.c_26,
            R.drawable.a_25,R.drawable.b_25,R.drawable.c_25,
            R.drawable.a_24,R.drawable.b_24,R.drawable.c_24,
            R.drawable.a_23,R.drawable.b_23,R.drawable.c_23,
            R.drawable.a_22,R.drawable.b_22,R.drawable.c_22,
            R.drawable.a_21,R.drawable.b_21,R.drawable.c_21,
            R.drawable.a_20,R.drawable.b_20,R.drawable.c_20,
            R.drawable.a_19,R.drawable.b_19,R.drawable.c_19,
            R.drawable.a_18,R.drawable.b_18,R.drawable.c_18,
            R.drawable.a_17,R.drawable.b_17,R.drawable.c_17,
            R.drawable.a_16,R.drawable.b_16,R.drawable.c_16,
            R.drawable.a_15,R.drawable.b_15,R.drawable.c_15,
            R.drawable.a_14,R.drawable.b_14,R.drawable.c_14,
            R.drawable.a_13,R.drawable.b_13,R.drawable.c_13,
            R.drawable.a_12,R.drawable.b_12,R.drawable.c_12,
            R.drawable.a_11,R.drawable.b_11,R.drawable.c_11,
            R.drawable.a_10,R.drawable.b_10,R.drawable.c_10,
            R.drawable.a_9,R.drawable.b_9,R.drawable.c_9,
            R.drawable.a_8,R.drawable.b_8,R.drawable.c_8,
            R.drawable.a_7,R.drawable.b_7,R.drawable.c_7,
            R.drawable.a_6,R.drawable.b_6,R.drawable.c_6,
            R.drawable.a_5,R.drawable.b_5,R.drawable.c_5,
            R.drawable.a_4,R.drawable.b_4,R.drawable.c_4,
            R.drawable.a_3,R.drawable.b_3,R.drawable.c_3,
            R.drawable.a_2,R.drawable.b_2,R.drawable.c_2,
            R.drawable.a_1,R.drawable.b_1,R.drawable.c_1
    };

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        gridView = (GridView) findViewById(R.id.gridview);
        PictureAdapter adapter = new PictureAdapter(titles, images, this);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                Toast.makeText(MainActivity.this, "pic" + (position+1), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
//自定义适配器
class PictureAdapter extends BaseAdapter{
    private LayoutInflater inflater;
    private List<Picture> pictures;

    public PictureAdapter(String[] titles, int[] images, Context context)
    {
        super();
        pictures = new ArrayList<Picture>();
        inflater = LayoutInflater.from(context);
        for (int i = 0; i < images.length; i++)
        {
            Picture picture = new Picture(titles[i], images[i]);
            pictures.add(picture);
        }
    }

    @Override
    public int getCount()
    {
        if (null != pictures)
        {
            return pictures.size();
        } else
        {
            return 0;
        }
    }

    @Override
    public Object getItem(int position)
    {
        return pictures.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder viewHolder;
        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.picture_item, null);
            viewHolder = new ViewHolder();
            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(viewHolder);
        } else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.title.setText(pictures.get(position).getTitle());
        viewHolder.image.setImageResource(pictures.get(position).getImageId());
        return convertView;
    }

}

class ViewHolder
{
    public TextView title;
    public ImageView image;
}

class Picture
{
    private String title;
    private int imageId;

    public Picture()
    {
        super();
    }

    public Picture(String title, int imageId)
    {
        super();
        this.title = title;
        this.imageId = imageId;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public int getImageId()
    {
        return imageId;
    }

    public void setImageId(int imageId)
    {
        this.imageId = imageId;
    }
}