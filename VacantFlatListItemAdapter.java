package project.android.com.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import project.android.com.R;
import project.android.com.model.Flat;

public class VacantFlatListItemAdapter extends ArrayAdapter<Flat> {
    private Activity context;
    List<Flat> flatList;
    LayoutInflater inflater;

    public VacantFlatListItemAdapter(Activity context, int resourceId)
    {
        super(context, resourceId);
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    private class ViewHolder
    {
        TextView flatNumberTV;
    }

    public View getView(int position, View view, ViewGroup parent) {

        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.allvacantflatlist_item, null);
            holder.flatNumberTV = view.findViewById(R.id.flat_number);
            view.setTag(holder);
        } else
        {
            holder = (ViewHolder) view.getTag();
        }
        holder.flatNumberTV.setText(flatList.get(position).getFlatNumber());

        return view;
    }

    public List<Flat> getFlatList() {
        return flatList;
    }

    public void setFlatList(List<Flat> flatList)
    {
        this.flatList = flatList;
    }

    @Override
    public int getCount() {
        return flatList.size();
    }

    @Override
    public Flat getItem(int position) {
        return flatList.get(position);
    }

}


