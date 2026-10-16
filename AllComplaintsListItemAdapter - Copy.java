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

import project.android.com.R;
import project.android.com.model.Complaint;
import project.android.com.utility.Constants;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;


public class AllComplaintsListItemAdapter extends ArrayAdapter<Complaint>
{
    private Activity context;
    List<Complaint> complaints;
    LayoutInflater inflater;

    public AllComplaintsListItemAdapter(Activity context, int resourceId)
    {
        super(context, resourceId);
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    private class ViewHolder
    {
        TextView descriptionTV;
        TextView dateTV;
        ImageView imageIV;
    }

    public View getView(int position, View view, ViewGroup parent) {

        final AllComplaintsListItemAdapter.ViewHolder holder;
        if (view == null) {
            holder = new AllComplaintsListItemAdapter.ViewHolder();
            view = inflater.inflate(R.layout.allcomplaintslist_item, null);

            holder.descriptionTV = (TextView) view.findViewById(R.id.description);
            holder.dateTV = (TextView) view.findViewById(R.id.date);
            holder.imageIV = (ImageView) view.findViewById(R.id.image);

            view.setTag(holder);
        } else
        {
            holder = (AllComplaintsListItemAdapter.ViewHolder) view.getTag();
        }

        holder.descriptionTV.setText(complaints.get(position).getDescription());
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        String complaintDateString = dateFormatter.format(complaints.get(position).getComplaintDate().getTime());
        holder.dateTV.setText("Posted On: " + complaintDateString);

//        String imagePath = complaints.get(position).getImagePath();
//        Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
//        if (null != bitmap) {
//            holder.imageIV.setImageBitmap(bitmap);
//        }
//        else
//        {
//            int resID = context.getResources().getIdentifier("noimage", Constants.DRAWABLE_RESOURCE, context.getPackageName());
//            holder.imageIV.setImageResource(resID);
//        }

        return view;
    }

    public List<Complaint> getComplaints() {
        return complaints;
    }

    public void setComplaints(List<Complaint> complaints)
    {
        this.complaints = complaints;
    }

    @Override
    public int getCount() {
        return complaints.size();
    }

    @Override
    public Complaint getItem(int position) {
        return complaints.get(position);
    }


}
