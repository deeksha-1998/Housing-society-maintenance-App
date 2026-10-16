package project.android.com.adapters;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import project.android.com.R;
import project.android.com.database.AppDatabaseHelper;
import project.android.com.model.Election;
import project.android.com.model.MaintenanceOfficer;
import project.android.com.model.Resident;
import project.android.com.utility.Constants;

public class AllElectionsListItemAdapter extends ArrayAdapter<Election> {
    private Activity context;
    List<Election> electionList;
    LayoutInflater inflater;

    public AllElectionsListItemAdapter(Activity context, int resourceId)
    {
        super(context, resourceId);
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    private class ViewHolder
    {
        TextView titleTV;
        TextView dateTV;
        ImageView iconIV;
    }

    public View getView(int position, View view, ViewGroup parent) {

        final AllElectionsListItemAdapter.ViewHolder holder;
        if (view == null) {
            holder = new AllElectionsListItemAdapter.ViewHolder();
            view = inflater.inflate(R.layout.allelectionslist_item, null);
            holder.titleTV = view.findViewById(R.id.title);
            holder.dateTV =  view.findViewById(R.id.date);
            holder.iconIV = view.findViewById(R.id.image);
            view.setTag(holder);
        } else
        {
            holder = (AllElectionsListItemAdapter.ViewHolder) view.getTag();
        }
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        String dateString = dateFormatter.format(electionList.get(position).getDate().getTime());

        holder.dateTV.setText(dateString);
        holder.titleTV.setText(electionList.get(position).getTitle());
        String type = electionList.get(position).getType();
        AppDatabaseHelper databaseHelper = new AppDatabaseHelper(context);

        if (type.equals(Constants.OPINIONPOLL_ELECTION))
        {
            int resID = context.getResources().getIdentifier("opinion", Constants.DRAWABLE_RESOURCE, context.getPackageName());
            holder.iconIV.setImageResource(resID);
        }
        else
        {
            int resID = context.getResources().getIdentifier("candidate", Constants.DRAWABLE_RESOURCE, context.getPackageName());
            holder.iconIV.setImageResource(resID);
        }
        return view;
    }

    public List<Election> getElectionList() {
        return this.electionList;
    }

    public void setElectionList(List<Election> electionList)
    {
        this.electionList = electionList;
    }

    @Override
    public int getCount() {
        return electionList.size();
    }

    @Override
    public Election getItem(int position) {
        return electionList.get(position);
    }


}

