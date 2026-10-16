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

import java.util.List;
import java.util.Map;

import project.android.com.R;
import project.android.com.database.AppDatabaseHelper;
import project.android.com.model.MaintenanceOfficer;
import project.android.com.model.Resident;
import project.android.com.utility.Constants;

public class AllDiscussionsListItemAdapter extends ArrayAdapter<Map<String,String>> {
    private Activity context;
    List<Map<String,String>> discussionList;
    LayoutInflater inflater;

    public AllDiscussionsListItemAdapter(Activity context, int resourceId)
    {
        super(context, resourceId);
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    private class ViewHolder
    {
        TextView commentTV;
        TextView dateTV;
        ImageView iconIV;
    }

    public View getView(int position, View view, ViewGroup parent) {

        final AllDiscussionsListItemAdapter.ViewHolder holder;
        if (view == null) {
            holder = new AllDiscussionsListItemAdapter.ViewHolder();
            view = inflater.inflate(R.layout.alldiscussionslist_item, null);
            holder.commentTV = view.findViewById(R.id.comment);
            holder.dateTV =  view.findViewById(R.id.date);
            holder.iconIV = view.findViewById(R.id.user);
            view.setTag(holder);
        } else
        {
            holder = (AllDiscussionsListItemAdapter.ViewHolder) view.getTag();
        }
        holder.dateTV.setText(discussionList.get(position).get(Constants.DISCUSSION_DATE_KEY));
        holder.commentTV.setText(discussionList.get(position).get(Constants.DISCUSSION_COMMENT_KEY));

        AppDatabaseHelper databaseHelper = new AppDatabaseHelper(context);

        if (discussionList.get(position).get(Constants.DISCUSSION_CREATED_BY_KEY).equals(Constants.ADMIN))
        {
            int resID = context.getResources().getIdentifier("admin", Constants.DRAWABLE_RESOURCE, context.getPackageName());
            holder.iconIV.setImageResource(resID);
        }
        else if (discussionList.get(position).get(Constants.DISCUSSION_CREATED_BY_KEY).equals(Constants.RESIDENT))
        {
            Resident resident = databaseHelper.getResidentWithId(Long.parseLong(discussionList.get(position).get(Constants.USER_ID_KEY)));
            String imagePath = resident.getProfilePath();
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            if (null != bitmap) {
                holder.iconIV.setImageBitmap(bitmap);
            }
            else
            {
                int resID = context.getResources().getIdentifier("noimage", Constants.DRAWABLE_RESOURCE, context.getPackageName());
                holder.iconIV.setImageResource(resID);
            }
        }
        else
        {
            MaintenanceOfficer officer = databaseHelper.getMaintenanceOfficerWithID(Long.parseLong(discussionList.get(position).get(Constants.USER_ID_KEY)));;
            String imagePath = officer.getProfilePath();

            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            if (null != bitmap) {
                holder.iconIV.setImageBitmap(bitmap);
            }
            else
            {
                int resID = context.getResources().getIdentifier("noimage", Constants.DRAWABLE_RESOURCE, context.getPackageName());
                holder.iconIV.setImageResource(resID);
            }
        }

        return view;
    }

    public List<Map<String,String>> getDiscussionList() {
        return this.discussionList;
    }

    public void setDiscussionList(List<Map<String,String>> discussionList)
    {
        this.discussionList = discussionList;
    }

    @Override
    public int getCount() {
        return discussionList.size();
    }

    @Override
    public Map<String, String> getItem(int position) {
        return discussionList.get(position);
    }


}

