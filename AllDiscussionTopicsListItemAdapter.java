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

import project.android.com.R;
import project.android.com.database.AppDatabaseHelper;
import project.android.com.model.Complaint;
import project.android.com.model.DiscussionTopic;
import project.android.com.model.MaintenanceOfficer;
import project.android.com.model.Resident;
import project.android.com.utility.Constants;


public class AllDiscussionTopicsListItemAdapter extends ArrayAdapter<DiscussionTopic>
{
    private Activity context;
    List<DiscussionTopic> topicList;
    LayoutInflater inflater;

    public AllDiscussionTopicsListItemAdapter(Activity context, int resourceId)
    {
        super(context, resourceId);
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    private class ViewHolder
    {
        TextView descriptionTV;
        TextView dateTV;
        TextView titleTV;
        TextView createdByTV;
        TextView userTypeTV;
        ImageView imageIV;
    }

    public View getView(int position, View view, ViewGroup parent) {

        final AllDiscussionTopicsListItemAdapter.ViewHolder holder;
        if (view == null) {
            holder = new AllDiscussionTopicsListItemAdapter.ViewHolder();
            view = inflater.inflate(R.layout.alldiscussiontopicslist_item, parent, false);

            holder.descriptionTV = view.findViewById(R.id.description);
            holder.dateTV =  view.findViewById(R.id.date);
            holder.imageIV =  view.findViewById(R.id.user);
            holder.createdByTV =  view.findViewById(R.id.created_by);
            holder.userTypeTV =  view.findViewById(R.id.user_type);
            holder.titleTV =  view.findViewById(R.id.title);

            view.setTag(holder);
        } else
        {
            holder = (AllDiscussionTopicsListItemAdapter.ViewHolder) view.getTag();
        }

        holder.descriptionTV.setText("Description: " + topicList.get(position).getDescription());
        holder.titleTV.setText("Title: " + topicList.get(position).getTitle());
        holder.userTypeTV.setText("User: " + topicList.get(position).getUserType());

        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        String dateString = dateFormatter.format(topicList.get(position).getDate().getTime());
        holder.dateTV.setText("Posted On: " + dateString);
        AppDatabaseHelper databaseHelper = new AppDatabaseHelper(context);

        if (topicList.get(position).getUserType().equals(Constants.ADMIN))
        {
            int resID = context.getResources().getIdentifier("admin", Constants.DRAWABLE_RESOURCE, context.getPackageName());
            holder.imageIV.setImageResource(resID);
            holder.createdByTV.setText("Name: " +Constants.ADMIN);
        }
        else if (topicList.get(position).getUserType().equals(Constants.RESIDENT))
        {
            Resident resident = databaseHelper.getResidentWithId(topicList.get(position).getUserID());
            String imagePath = resident.getProfilePath();
            holder.createdByTV.setText("Name: " + resident.getName());
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            if (null != bitmap) {
                holder.imageIV.setImageBitmap(bitmap);
            }
            else
            {
                int resID = context.getResources().getIdentifier("noimage", Constants.DRAWABLE_RESOURCE, context.getPackageName());
                holder.imageIV.setImageResource(resID);
            }
        }
        else
        {
            MaintenanceOfficer officer = databaseHelper.getMaintenanceOfficerWithID(topicList.get(position).getUserID());
            String imagePath = officer.getProfilePath();
            holder.createdByTV.setText("Name: " + officer.getName());

            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            if (null != bitmap) {
                holder.imageIV.setImageBitmap(bitmap);
            }
            else
            {
                int resID = context.getResources().getIdentifier("noimage", Constants.DRAWABLE_RESOURCE, context.getPackageName());
                holder.imageIV.setImageResource(resID);
            }
        }


        return view;
    }


    @Override
    public int getCount() {
        return topicList.size();
    }

    @Override
    public DiscussionTopic getItem(int position) {
        return topicList.get(position);
    }

    public List<DiscussionTopic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<DiscussionTopic> topicList) {
        this.topicList = topicList;
    }
}
