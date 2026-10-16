package project.android.com.utility;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import project.android.com.model.MaintenanceOfficer;
import project.android.com.model.Resident;


public class AppInstance extends Application {
    public static AppInstance instance = null;




    private boolean isAdminUser;
    private MaintenanceOfficer currentMaintenanceOfficer;
    private Resident currentResident;

    private static Context mContext;

    public static Context getInstance()
    {
        if (null == instance) {
            instance = new AppInstance();
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        SharedPreferences mypref = PreferenceManager.getDefaultSharedPreferences(this);
        String adminPassword = Constants.ADMIN_PASSWORD;
        if (mypref.contains(Constants.ADMIN_PASSWORD_KEY))
        {
            adminPassword = mypref.getString(Constants.ADMIN_PASSWORD_KEY, Constants.ADMIN_PASSWORD);
        }
        mypref.edit().clear().commit();
        mypref.edit().putString(Constants.ADMIN_PASSWORD_KEY, adminPassword).commit();

    }

    public static Context getContext() {
        return mContext;
    }


    public boolean isAdminUser()
    {
        return isAdminUser;
    }

    public void setAdminUser(boolean isAdminUser)
    {
        this.isAdminUser = isAdminUser;
    }

    public MaintenanceOfficer getCurrentMaintenanceOfficer() {
        return currentMaintenanceOfficer;
    }

    public void setCurrentMaintenanceOfficer(MaintenanceOfficer currentMaintenanceOfficer) {
        this.currentMaintenanceOfficer = currentMaintenanceOfficer;
    }

    public Resident getCurrentResident() {
        return currentResident;
    }

    public void setCurrentResident(Resident currentResident) {
        this.currentResident = currentResident;
    }
}


