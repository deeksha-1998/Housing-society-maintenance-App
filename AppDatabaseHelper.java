package project.android.com.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import project.android.com.model.Apartment;
import project.android.com.model.Complaint;
import project.android.com.model.DiscussionTopic;
import project.android.com.model.Election;
import project.android.com.model.Event;
import project.android.com.model.Feedback;
import project.android.com.model.Flat;
import project.android.com.model.MaintenanceOfficer;
import project.android.com.model.Resident;
import project.android.com.utility.Constants;
import project.android.com.utility.Utility;


public class AppDatabaseHelper extends SQLiteOpenHelper{ public AppDatabaseHelper(Context context) {
    super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
}

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_APARTMENT_TABLE = "CREATE TABLE " + Constants.APARTMENT_TABLE_NAME + "(" +
                Constants.ID_KEY + " INTEGER PRIMARY KEY," +
                Constants.APARTMENT_NAME_KEY + " TEXT," +
                Constants.APARTMENT_DESCRIPTION_KEY + " TEXT," +
                Constants.APARTMENT_ADDRESS_KEY + " TEXT," +
                Constants.APARTMENT_TYPE_KEY + " TEXT," +
                Constants.APARTMENT_OPENING_KEY + " TEXT," +
                Constants.APARTMENT_NUMBEROFFLATS_KEY + " INTEGER," +
                Constants.APARTMENT_PROFILEPATH_KEY + " TEXT " +
                ")";

        String CREATE_MAINTENANCEOFFICER_TABLE = "CREATE TABLE " + Constants.MAINTENANCEOFFICER_TABLE_NAME + "(" +
                Constants.ID_KEY + " INTEGER PRIMARY KEY," +
                Constants.MAINTENANCEOFFICER_NAME_KEY + " TEXT," +
                Constants.MAINTENANCEOFFICER_MAIL_KEY + " TEXT," +
                Constants.MAINTENANCEOFFICER_CONTACT_KEY + " TEXT," +
                Constants.MAINTENANCEOFFICER_USERNAME_KEY + " TEXT," +
                Constants.MAINTENANCEOFFICER_PASSWORD_KEY + " TEXT," +
                Constants.APARTMENT_ID_KEY + " INTEGER," +
                Constants.MAINTENANCEOFFICER_PROFILEPATH_KEY + " TEXT " +
                ")";

        String CREATE_FLAT_TABLE = "CREATE TABLE " + Constants.FLAT_TABLE_NAME + "(" +
                Constants.ID_KEY + " INTEGER PRIMARY KEY," +
                Constants.FLAT_NUMBER_KEY + " TEXT," +
                Constants.FLAT_FLOOR_KEY + " INTEGER," +
                Constants.FLAT_FURNISHED_TYPE_KEY + " TEXT," +
                Constants.FLAT_TYPE_KEY + " TEXT," +
                Constants.FLAT_OCCUPANCY_TYPE_KEY + " TEXT," +
                Constants.FLAT_NUMBER_OF_BEDROOMS_KEY + " INTEGER," +
                Constants.APARTMENT_ID_KEY + " INTEGER " +
                ")";

        String CREATE_RESIDENT_TABLE = "CREATE TABLE " + Constants.RESIDENT_TABLE_NAME + "(" +
                Constants.ID_KEY + " INTEGER PRIMARY KEY," +
                Constants.RESIDENT_NAME_KEY + " TEXT," +
                Constants.RESIDENT_MAIL_KEY + " TEXT," +
                Constants.RESIDENT_CONTACT_KEY + " TEXT," +
                Constants.RESIDENT_USERNAME_KEY + " TEXT," +
                Constants.RESIDENT_PASSWORD_KEY + " TEXT," +
                Constants.APARTMENT_ID_KEY + " INTEGER," +
                Constants.FLAT_ID_KEY + " INTEGER," +
                Constants.RESIDENT_PROFILEPATH_KEY + " TEXT " +
                ")";

        String CREATE_EVENT_TABLE = "CREATE TABLE " + Constants.EVENT_TABLE_NAME + "(" +
                Constants.ID_KEY + " INTEGER PRIMARY KEY," +
                Constants.MAINTENANCEOFFICER_ID_KEY + " INTEGER," +
                Constants.EVENT_TITLE_KEY + " TEXT," +
                Constants.EVENT_DESCRIPTION_KEY + " TEXT," +
                Constants.EVENT_VENUE_KEY + " TEXT," +
                Constants.EVENT_TIME_KEY + " TEXT," +
                Constants.EVENT_DATE_KEY + " TEXT" +
                ")";

        String CREATE_FEEDBACK_TABLE = "CREATE TABLE " + Constants.FEEDBACK_TABLE_NAME + "(" +
                Constants.ID_KEY + " INTEGER PRIMARY KEY," +
                Constants.FEEDBACK_DESCRIPTION_KEY + " TEXT," +
                Constants.RESIDENT_ID_KEY + " INTEGER," +
                Constants.APARTMENT_ID_KEY + " INTEGER," +
                Constants.EVENT_ID_KEY + " INTEGER" +
                ")";

        String CREATE_COMPLAINT_TABLE = "CREATE TABLE " + Constants.COMPLAINT_TABLE_NAME + "("
                + Constants.ID_KEY + " INTEGER PRIMARY KEY," +
                Constants.COMPLAINT_DESCRIPTION_KEY + " TEXT," +
                Constants.COMPLAINT_DATE_KEY + " TEXT," +
                Constants.RESIDENT_ID_KEY + " INTEGER," +
                Constants.APARTMENT_ID_KEY + " INTEGER," +
                Constants.COMPLAINT_STATUS_KEY + " INTEGER " + ")";


        String CREATE_RESIDENT_EVENT_TABLE = "CREATE TABLE " + Constants.RESIDENT_EVENT_TABLE_NAME + "("
                + Constants.ID_KEY + " INTEGER PRIMARY KEY," +
                Constants.RESIDENT_ID_KEY + " INTEGER,"
                + Constants.EVENT_ID_KEY + " INTEGER"  + ")";

        String CREATE_ELECTION_CANDIDATE_TABLE = "CREATE TABLE " + Constants.ELECTION_CANDIDATE_TABLE_NAME + "("
                + Constants.ID_KEY + " INTEGER PRIMARY KEY," +
                Constants.ELECTION_ID_KEY + " INTEGER," +
        Constants.COUNT_OF_VOTES_KEY + " INTEGER,"

                + Constants.CANDIDATE_ID_KEY + " INTEGER"  + ")";


        String CREATE_ELECTION_RESIDENT_TABLE = "CREATE TABLE " + Constants.ELECTION_RESIDENT_TABLE_NAME + "("
                + Constants.ID_KEY + " INTEGER PRIMARY KEY," +
                Constants.RESIDENT_ID_KEY + " INTEGER,"
                + Constants.ELECTION_ID_KEY + " INTEGER"  + ")";

        String CREATE_DISCUSSION_TOPIC_TABLE = "CREATE TABLE " + Constants.DISCUSSION_TOPIC_TABLE_NAME + "("
                + Constants.ID_KEY + " INTEGER PRIMARY KEY," +
                Constants.USER_ID_KEY + " INTEGER," +
        Constants.DISCUSSION_TOPIC_CREATED_BY_KEY + " TEXT," +
                Constants.DISCUSSION_TOPIC_CREATION_DATE_KEY + " TEXT," +
                Constants.DISCUSSION_TOPIC_DESCRIPTION_KEY + " TEXT," +
                Constants.DISCUSSION_TOPIC_TITLE_KEY + " TEXT " +
                 ")";

        String CREATE_DISCUSSION_TABLE = "CREATE TABLE " + Constants.DISCUSSION_TABLE_NAME + "("
                + Constants.ID_KEY + " INTEGER PRIMARY KEY," +
                Constants.USER_ID_KEY + " INTEGER," +
                Constants.DISCUSSION_CREATED_BY_KEY + " TEXT," +
                Constants.DISCUSSION_DATE_KEY + " TEXT," +
                Constants.DISCUSSION_COMMENT_KEY + " TEXT," +
                Constants.DISCUSSION_TOPIC_ID_KEY + " INTEGER " +
                ")";

        String CREATE_ELECTION_TABLE = "CREATE TABLE " + Constants.ELECTION_TABLE_NAME + "("
                + Constants.ID_KEY + " INTEGER PRIMARY KEY," +
                Constants.ELECTION_TITLE_KEY + " TEXT," +
                Constants.ELECTION_DESCRIPTION_KEY + " TEXT," +
                Constants.ELECTION_DATE_KEY + " TEXT," +
                Constants.ELECTION_QUESTION_KEY + " TEXT," +
                Constants.ELECTION_OPTION1_KEY + " TEXT," +
                Constants.ELECTION_OPTION2_KEY + " TEXT," +
                Constants.ELECTION_CANDIDATES_KEY + " TEXT," +
                Constants.ELECTION_OPTION1_COUNT_KEY + " INTEGER," +
                Constants.ELECTION_OPTION2_COUNT_KEY + " INTEGER," +
                Constants.ELECTION_TYPE_KEY + " TEXT " +
                ")";

        db.execSQL(CREATE_APARTMENT_TABLE);
        db.execSQL(CREATE_MAINTENANCEOFFICER_TABLE);
        db.execSQL(CREATE_FLAT_TABLE);
        db.execSQL(CREATE_RESIDENT_TABLE);
        db.execSQL(CREATE_EVENT_TABLE);
        db.execSQL(CREATE_DISCUSSION_TOPIC_TABLE);
        db.execSQL(CREATE_FEEDBACK_TABLE);
        db.execSQL(CREATE_COMPLAINT_TABLE);
        db.execSQL(CREATE_RESIDENT_EVENT_TABLE);
        db.execSQL(CREATE_DISCUSSION_TABLE);
        db.execSQL(CREATE_ELECTION_TABLE);
        db.execSQL(CREATE_ELECTION_RESIDENT_TABLE);
        db.execSQL(CREATE_ELECTION_CANDIDATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long addElection(Election election)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        // Inserting Row to Apartment table
        values.put(Constants.ELECTION_TITLE_KEY, election.getTitle());
        values.put(Constants.ELECTION_DESCRIPTION_KEY, election.getDescription());
        values.put(Constants.ELECTION_TYPE_KEY, election.getType());
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        String date = dateFormatter.format(election.getDate().getTime());

        values.put(Constants.ELECTION_DATE_KEY, date);
        if (election.getCandidateIDs()!=null) {
            values.put(Constants.ELECTION_CANDIDATES_KEY, election.getCandidateIDs().toString());
        }
        values.put(Constants.ELECTION_QUESTION_KEY, election.getOpinionPollQuestion());
        values.put(Constants.ELECTION_OPTION1_KEY, election.getOpinionPollOption1());
        values.put(Constants.ELECTION_OPTION2_KEY, election.getOpinionPollOption2());
        values.put(Constants.ELECTION_OPTION1_COUNT_KEY, election.getOpinionPollOption1Count());
        values.put(Constants.ELECTION_OPTION2_COUNT_KEY, election.getOpinionPollOption2Count());

        long electionID = db.insert(Constants.ELECTION_TABLE_NAME, null, values);

        db.close();
        return electionID;
    }

    public long addApartment(Apartment apartment)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        // Inserting Row to Apartment table
        values.put(Constants.APARTMENT_NAME_KEY, apartment.getName());
        values.put(Constants.APARTMENT_DESCRIPTION_KEY, apartment.getDescription());
        values.put(Constants.APARTMENT_ADDRESS_KEY, apartment.getAddress());
        values.put(Constants.APARTMENT_NUMBEROFFLATS_KEY, apartment.getNumberOfFlats());
        values.put(Constants.APARTMENT_PROFILEPATH_KEY, apartment.getPicPath());
        values.put(Constants.APARTMENT_TYPE_KEY, apartment.getApartmentType());

        String date = null;
        if ( apartment.getOpeningDate() != null )
        {
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            date = dateFormatter.format(apartment.getOpeningDate().getTime());
        }

        values.put(Constants.APARTMENT_OPENING_KEY, date);

        long apartmentID = db.insert(Constants.APARTMENT_TABLE_NAME, null, values);

        db.close();
        return apartmentID;
    }

    public long addMaintenanceOfficer(MaintenanceOfficer maintenanceOfficer)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        // Inserting Row to MaintenanceOfficer table
        values.put(Constants.MAINTENANCEOFFICER_NAME_KEY, maintenanceOfficer.getName());
        values.put(Constants.MAINTENANCEOFFICER_MAIL_KEY, maintenanceOfficer.getMail());
        values.put(Constants.MAINTENANCEOFFICER_PROFILEPATH_KEY, maintenanceOfficer.getProfilePath());
        values.put(Constants.MAINTENANCEOFFICER_CONTACT_KEY, maintenanceOfficer.getContact());
        values.put(Constants.MAINTENANCEOFFICER_USERNAME_KEY, maintenanceOfficer.getUsername());
        values.put(Constants.MAINTENANCEOFFICER_PASSWORD_KEY, maintenanceOfficer.getPassword());
        values.put(Constants.APARTMENT_ID_KEY, maintenanceOfficer.getApartmentID());

        long officerID = db.insert(Constants.MAINTENANCEOFFICER_TABLE_NAME, null, values);

        db.close();
        return officerID;
    }

    public long addFlat(Flat flat)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        // Inserting Row to Flat table
        values.put(Constants.FLAT_NUMBER_KEY, flat.getFlatNumber());
        values.put(Constants.FLAT_FLOOR_KEY, flat.getFloorNumber());
        values.put(Constants.FLAT_FURNISHED_TYPE_KEY, flat.getFurnishedType());
        values.put(Constants.FLAT_NUMBER_OF_BEDROOMS_KEY, flat.getNumberOfBedrooms());
        values.put(Constants.APARTMENT_ID_KEY, flat.getApartmentID());
        values.put(Constants.FLAT_TYPE_KEY, flat.getFlatType());
        values.put(Constants.FLAT_OCCUPANCY_TYPE_KEY, flat.getOccupancyType());

        long flatID = db.insert(Constants.FLAT_TABLE_NAME, null, values);

        db.close();
        return flatID;
    }

    public long addDiscussionTopic(DiscussionTopic topic)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Constants.DISCUSSION_TOPIC_DESCRIPTION_KEY, topic.getDescription());
        values.put(Constants.DISCUSSION_TOPIC_TITLE_KEY, topic.getTitle());
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        String date = dateFormatter.format(topic.getDate().getTime());

        values.put(Constants.DISCUSSION_TOPIC_CREATION_DATE_KEY, date);
        values.put(Constants.DISCUSSION_TOPIC_CREATED_BY_KEY, topic.getUserType());
        values.put(Constants.USER_ID_KEY, topic.getUserID());
        long topicID = db.insert(Constants.DISCUSSION_TOPIC_TABLE_NAME, null, values);

        db.close();
        return topicID;


    }
    public long addResident(Resident resident)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Constants.RESIDENT_NAME_KEY, resident.getName());
        values.put(Constants.RESIDENT_MAIL_KEY, resident.getMail());
        values.put(Constants.RESIDENT_PROFILEPATH_KEY, resident.getProfilePath());
        values.put(Constants.RESIDENT_CONTACT_KEY, resident.getContact());
        values.put(Constants.RESIDENT_USERNAME_KEY, resident.getUsername());
        values.put(Constants.RESIDENT_PASSWORD_KEY, resident.getPassword());
        values.put(Constants.APARTMENT_ID_KEY, resident.getApartmentID());
        values.put(Constants.FLAT_ID_KEY, resident.getFlatID());

        long residentID = db.insert(Constants.RESIDENT_TABLE_NAME, null, values);

        db.close();
        return residentID;
    }

    public MaintenanceOfficer getMaintenanceOfficerWithID(long officerID)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String table = Constants.MAINTENANCEOFFICER_TABLE_NAME;

        String[] columns = new String[]{Constants.ID_KEY,
                Constants.MAINTENANCEOFFICER_NAME_KEY,
                Constants.MAINTENANCEOFFICER_PASSWORD_KEY,
                Constants.MAINTENANCEOFFICER_USERNAME_KEY,
                Constants.MAINTENANCEOFFICER_MAIL_KEY,
                Constants.APARTMENT_ID_KEY,
                Constants.MAINTENANCEOFFICER_CONTACT_KEY,
                Constants.MAINTENANCEOFFICER_PROFILEPATH_KEY};
        String where = Constants.ID_KEY + " =?";

        Cursor cursor = db.query(table, columns, where,
                new String[]{String.valueOf(officerID)}, null, null, null, null);
        MaintenanceOfficer maintenanceOfficer = null;
        if (cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            long apartmentID = cursor.getLong(cursor.getColumnIndex(Constants.APARTMENT_ID_KEY));

            String name = cursor.getString(cursor.getColumnIndex(Constants.MAINTENANCEOFFICER_NAME_KEY));
            String mail = cursor.getString(cursor.getColumnIndex(Constants.MAINTENANCEOFFICER_MAIL_KEY));
            String contact = cursor.getString(cursor.getColumnIndex(Constants.MAINTENANCEOFFICER_CONTACT_KEY));
            String profilePath = cursor.getString(cursor.getColumnIndex(Constants.MAINTENANCEOFFICER_PROFILEPATH_KEY));
            String password = cursor.getString(cursor.getColumnIndex(Constants.MAINTENANCEOFFICER_PASSWORD_KEY));
            String username = cursor.getString(cursor.getColumnIndex(Constants.MAINTENANCEOFFICER_USERNAME_KEY));

            maintenanceOfficer = new MaintenanceOfficer();
            maintenanceOfficer.setOfficerID(officerID);
            maintenanceOfficer.setName(name);
            maintenanceOfficer.setContact(contact);
            maintenanceOfficer.setMail(mail);
            maintenanceOfficer.setUsername(username);
            maintenanceOfficer.setPassword(password);
            maintenanceOfficer.setProfilePath(profilePath);
            maintenanceOfficer.setApartmentID(apartmentID);

        }

        db.close();
        return maintenanceOfficer;
    }


    public ArrayList<DiscussionTopic> getDiscussionTopicsList()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String table = Constants.DISCUSSION_TOPIC_TABLE_NAME;
        String[] columns = new String[]{Constants.ID_KEY,
                Constants.DISCUSSION_TOPIC_TITLE_KEY,
                Constants.DISCUSSION_TOPIC_DESCRIPTION_KEY,
                Constants.DISCUSSION_TOPIC_CREATION_DATE_KEY,
                Constants.DISCUSSION_TOPIC_CREATED_BY_KEY,
                Constants.USER_ID_KEY};

        Cursor cursor = db.query(table, columns, null, null, null, null, null, null);

        ArrayList<DiscussionTopic> topics = new ArrayList();
        if (cursor.moveToFirst()) {
            do {
                long topicID = Long.parseLong(cursor.getString(cursor.getColumnIndex(Constants.ID_KEY)));
                long userID = Long.parseLong(cursor.getString(cursor.getColumnIndex(Constants.USER_ID_KEY)));

                String title = cursor.getString(cursor.getColumnIndex(Constants.DISCUSSION_TOPIC_TITLE_KEY));
                String description = cursor.getString(cursor.getColumnIndex(Constants.DISCUSSION_TOPIC_DESCRIPTION_KEY));
                String createdBy = cursor.getString(cursor.getColumnIndex(Constants.DISCUSSION_TOPIC_CREATED_BY_KEY));

                String dateString = cursor.getString(cursor.getColumnIndex(Constants.DISCUSSION_TOPIC_CREATION_DATE_KEY));
                Calendar date = null;
                if (dateString != null )
                {
                    date = Utility.stringToDate(dateString);
                }
                DiscussionTopic topic = new DiscussionTopic();
                topic.setTopicID(topicID);
                topic.setTitle(title);
                topic.setUserID(userID);
                topic.setDescription(description);
                topic.setDate(date);
                topic.setUserType(createdBy);

                topics.add(topic);
            } while (cursor.moveToNext());
        }
        db.close();
        return topics;
    }

    public ArrayList<Apartment> getExisitingApartmentList()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String table = Constants.APARTMENT_TABLE_NAME;
        String[] columns = new String[]{Constants.ID_KEY,
                Constants.APARTMENT_NAME_KEY,
                Constants.APARTMENT_DESCRIPTION_KEY,
                Constants.APARTMENT_ADDRESS_KEY,
                Constants.APARTMENT_NUMBEROFFLATS_KEY,
                Constants.APARTMENT_TYPE_KEY,
                Constants.APARTMENT_PROFILEPATH_KEY,
                Constants.APARTMENT_OPENING_KEY};

        String where = Constants.APARTMENT_TYPE_KEY + " =?" ;
        Cursor cursor = db.query(table, columns, where, new String[]{Constants.EXISTING_APARTMENT}, null, null, null, null);

        ArrayList<Apartment> apartmentList = new ArrayList();
        if (cursor.moveToFirst()) {
            do {
                long apartmentID = Long.parseLong(cursor.getString(cursor.getColumnIndex(Constants.ID_KEY)));

                String name = cursor.getString(cursor.getColumnIndex(Constants.APARTMENT_NAME_KEY));
                String address = cursor.getString(cursor.getColumnIndex(Constants.APARTMENT_ADDRESS_KEY));
                String description = cursor.getString(cursor.getColumnIndex(Constants.APARTMENT_DESCRIPTION_KEY));
                int numberOfFlats = cursor.getInt(cursor.getColumnIndex(Constants.APARTMENT_NUMBEROFFLATS_KEY));
                String type = cursor.getString(cursor.getColumnIndex(Constants.APARTMENT_TYPE_KEY));
                String profilePath = cursor.getString(cursor.getColumnIndex(Constants.APARTMENT_PROFILEPATH_KEY));

                String dateString = cursor.getString(cursor.getColumnIndex(Constants.APARTMENT_OPENING_KEY));
                Calendar openingDate = null;
                if (dateString != null )
                {
                    openingDate = Utility.stringToDate(dateString);
                }
                Apartment apartment = new Apartment();
                apartment.setApartmentID(apartmentID);
                apartment.setName(name);
                apartment.setAddress(address);
                apartment.setDescription(description);
                apartment.setNumberOfFlats(numberOfFlats);
                apartment.setApartmentType(type);
                apartment.setPicPath(profilePath);
                apartment.setOpeningDate(openingDate);

                apartmentList.add(apartment);
            } while (cursor.moveToNext());
        }
        db.close();
        return apartmentList;
    }

    public String getApartmentNameForApartmentID(long apartmentID)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String table = Constants.APARTMENT_TABLE_NAME;
        String[] columns = new String[]{
                Constants.APARTMENT_NAME_KEY,
               };
        String where = Constants.ID_KEY + " =?";

        Cursor cursor = db.query(table, columns, where, new String[]{String.valueOf(apartmentID)}, null, null, null, null);

        String apartmentName = null;
        if (cursor.moveToFirst()) {

            apartmentName = cursor.getString(cursor.getColumnIndex(Constants.APARTMENT_NAME_KEY));
        }
        db.close();
        return apartmentName;
    }

    public ArrayList<Apartment> getApartmentList()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String table = Constants.APARTMENT_TABLE_NAME;
        String[] columns = new String[]{Constants.ID_KEY,
                Constants.APARTMENT_NAME_KEY,
                Constants.APARTMENT_DESCRIPTION_KEY,
                Constants.APARTMENT_ADDRESS_KEY,
                Constants.APARTMENT_NUMBEROFFLATS_KEY,
                Constants.APARTMENT_TYPE_KEY,
                Constants.APARTMENT_PROFILEPATH_KEY,
                Constants.APARTMENT_OPENING_KEY};

        Cursor cursor = db.query(table, columns, null, null, null, null, null, null);

        ArrayList<Apartment> apartmentList = new ArrayList();
        if (cursor.moveToFirst()) {
            do {
                long apartmentID = Long.parseLong(cursor.getString(cursor.getColumnIndex(Constants.ID_KEY)));

                String name = cursor.getString(cursor.getColumnIndex(Constants.APARTMENT_NAME_KEY));
                String address = cursor.getString(cursor.getColumnIndex(Constants.APARTMENT_ADDRESS_KEY));
                String description = cursor.getString(cursor.getColumnIndex(Constants.APARTMENT_DESCRIPTION_KEY));
                int numberOfFlats = cursor.getInt(cursor.getColumnIndex(Constants.APARTMENT_NUMBEROFFLATS_KEY));
                String type = cursor.getString(cursor.getColumnIndex(Constants.APARTMENT_TYPE_KEY));
                String profilePath = cursor.getString(cursor.getColumnIndex(Constants.APARTMENT_PROFILEPATH_KEY));

                String dateString = cursor.getString(cursor.getColumnIndex(Constants.APARTMENT_OPENING_KEY));
                Calendar openingDate = null;
                if (dateString != null )
                {
                    openingDate = Utility.stringToDate(dateString);
                }
                Apartment apartment = new Apartment();
                apartment.setApartmentID(apartmentID);
                apartment.setName(name);
                apartment.setAddress(address);
                apartment.setDescription(description);
                apartment.setNumberOfFlats(numberOfFlats);
                apartment.setApartmentType(type);
                apartment.setPicPath(profilePath);
                apartment.setOpeningDate(openingDate);

                apartmentList.add(apartment);
            } while (cursor.moveToNext());
        }
        db.close();
        return apartmentList;
    }

    public ArrayList<Election> getElectionList()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String table = Constants.ELECTION_TABLE_NAME;
        String[] columns = new String[]{Constants.ID_KEY,
                Constants.ELECTION_TITLE_KEY,
                Constants.ELECTION_DESCRIPTION_KEY,
                Constants.ELECTION_TYPE_KEY,
                Constants.ELECTION_DATE_KEY,
                Constants.ELECTION_QUESTION_KEY,
                Constants.ELECTION_OPTION1_KEY,
                Constants.ELECTION_OPTION2_KEY,
                Constants.ELECTION_OPTION1_COUNT_KEY,
                Constants.ELECTION_OPTION2_COUNT_KEY,
                Constants.ELECTION_CANDIDATES_KEY};

        Cursor cursor = db.query(table, columns, null, null, null, null, null, null);

        ArrayList<Election> electionList = new ArrayList();
        if (cursor.moveToFirst()) {
            do {
                long electionID = Long.parseLong(cursor.getString(cursor.getColumnIndex(Constants.ID_KEY)));

                String title = cursor.getString(cursor.getColumnIndex(Constants.ELECTION_TITLE_KEY));
                String type = cursor.getString(cursor.getColumnIndex(Constants.ELECTION_TYPE_KEY));
                String description = cursor.getString(cursor.getColumnIndex(Constants.ELECTION_DESCRIPTION_KEY));
                String question = cursor.getString(cursor.getColumnIndex(Constants.ELECTION_QUESTION_KEY));
                String option1 = cursor.getString(cursor.getColumnIndex(Constants.ELECTION_OPTION1_KEY));
                String option2 = cursor.getString(cursor.getColumnIndex(Constants.ELECTION_OPTION2_KEY));
                String candidateIDs = cursor.getString(cursor.getColumnIndex(Constants.ELECTION_CANDIDATES_KEY));
                int option1Count = cursor.getInt(cursor.getColumnIndex(Constants.ELECTION_OPTION1_COUNT_KEY));
                int option2Count = cursor.getInt(cursor.getColumnIndex(Constants.ELECTION_OPTION2_COUNT_KEY));

                String dateString = cursor.getString(cursor.getColumnIndex(Constants.ELECTION_DATE_KEY));
                Calendar date = null;
                if (dateString != null )
                {
                    date = Utility.stringToDate(dateString);
                }
                Election election = new Election();
                election.setElectionID(electionID);
                election.setTitle(title);
                election.setDescription(description);
                election.setType(type);
                election.setOpinionPollQuestion(question);
                election.setOpinionPollOption1(option1);
                election.setOpinionPollOption2(option2);
                election.setOpinionPollOption1(option1);
                election.setOpinionPollOption2(option2);
                election.setOpinionPollOption1Count(option1Count);
                election.setOpinionPollOption2Count(option2Count);

                election.setDate(date);
                if (candidateIDs != null) {
                    List<String> candidateList = new ArrayList(Arrays.asList(candidateIDs.split(",")));
                    List<Long> newList = new ArrayList(candidateList.size());
                    for (String myInt : candidateList) {
                        myInt = myInt.replace("[", "");
                        myInt = myInt.replace("]", "");
                        myInt = myInt.trim();

                        newList.add(Long.valueOf(myInt));
                    }

                    election.setCandidateIDs(newList);
                }
                electionList.add(election);
            } while (cursor.moveToNext());
        }
        db.close();
        return electionList;
    }

    public ArrayList<String> getAllMaintenanceOfficerUserNames()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String table = Constants.MAINTENANCEOFFICER_TABLE_NAME;
        String[] columns = new String[]{Constants.MAINTENANCEOFFICER_USERNAME_KEY};

        Cursor cursor = db.query(table, columns, null,
                null, null, null, null, null);

        ArrayList<String> maintenanceOfficerUserNames = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                String username = cursor.getString(cursor.getColumnIndex(Constants.MAINTENANCEOFFICER_USERNAME_KEY));
                maintenanceOfficerUserNames.add(username);
            } while (cursor.moveToNext());
        }

        db.close();
        return maintenanceOfficerUserNames;
    }

    public MaintenanceOfficer getMaintenanceOfficerWithUsernameAndPassword(String userName, String password)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String table = Constants.MAINTENANCEOFFICER_TABLE_NAME;

        String[] columns = new String[]{Constants.ID_KEY,
                Constants.MAINTENANCEOFFICER_NAME_KEY,
                Constants.MAINTENANCEOFFICER_MAIL_KEY,
                Constants.APARTMENT_ID_KEY,
                Constants.MAINTENANCEOFFICER_CONTACT_KEY,
                Constants.MAINTENANCEOFFICER_PROFILEPATH_KEY};
        String where = Constants.MAINTENANCEOFFICER_USERNAME_KEY + " =?" + " AND " + Constants.MAINTENANCEOFFICER_PASSWORD_KEY + " =?";

        Cursor cursor = db.query(table, columns, where,
                new String[]{userName, password}, null, null, null, null);
        MaintenanceOfficer maintenanceOfficer = null;
        if (cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            long officerID = cursor.getLong(cursor.getColumnIndex(Constants.ID_KEY));
            long apartmentID = cursor.getLong(cursor.getColumnIndex(Constants.APARTMENT_ID_KEY));

            String name = cursor.getString(cursor.getColumnIndex(Constants.MAINTENANCEOFFICER_NAME_KEY));
            String mail = cursor.getString(cursor.getColumnIndex(Constants.MAINTENANCEOFFICER_MAIL_KEY));
            String contact = cursor.getString(cursor.getColumnIndex(Constants.MAINTENANCEOFFICER_CONTACT_KEY));
            String profilePath = cursor.getString(cursor.getColumnIndex(Constants.MAINTENANCEOFFICER_PROFILEPATH_KEY));


            maintenanceOfficer = new MaintenanceOfficer();
            maintenanceOfficer.setOfficerID(officerID);
            maintenanceOfficer.setName(name);
            maintenanceOfficer.setContact(contact);
            maintenanceOfficer.setMail(mail);
            maintenanceOfficer.setUsername(userName);
            maintenanceOfficer.setPassword(password);
            maintenanceOfficer.setProfilePath(profilePath);
            maintenanceOfficer.setApartmentID(apartmentID);

        }

        db.close();
        return maintenanceOfficer;
    }
    public MaintenanceOfficer getMaintenanceOfficerWithUserName(String username)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String table = Constants.MAINTENANCEOFFICER_TABLE_NAME;

        String[] columns = new String[]{Constants.ID_KEY,
                Constants.MAINTENANCEOFFICER_NAME_KEY,
                Constants.MAINTENANCEOFFICER_PASSWORD_KEY,
                Constants.MAINTENANCEOFFICER_MAIL_KEY,
                Constants.APARTMENT_ID_KEY,
                Constants.MAINTENANCEOFFICER_CONTACT_KEY,
                Constants.MAINTENANCEOFFICER_PROFILEPATH_KEY};
        String where = Constants.MAINTENANCEOFFICER_USERNAME_KEY + " =?";

        Cursor cursor = db.query(table, columns, where,
                new String[]{username}, null, null, null, null);
        MaintenanceOfficer maintenanceOfficer = null;
        if (cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            long officerID = cursor.getLong(cursor.getColumnIndex(Constants.ID_KEY));
            long apartmentID = cursor.getLong(cursor.getColumnIndex(Constants.APARTMENT_ID_KEY));

            String name = cursor.getString(cursor.getColumnIndex(Constants.MAINTENANCEOFFICER_NAME_KEY));
            String mail = cursor.getString(cursor.getColumnIndex(Constants.MAINTENANCEOFFICER_MAIL_KEY));
            String contact = cursor.getString(cursor.getColumnIndex(Constants.MAINTENANCEOFFICER_CONTACT_KEY));
            String profilePath = cursor.getString(cursor.getColumnIndex(Constants.MAINTENANCEOFFICER_PROFILEPATH_KEY));
            String password = cursor.getString(cursor.getColumnIndex(Constants.MAINTENANCEOFFICER_PASSWORD_KEY));


            maintenanceOfficer = new MaintenanceOfficer();
            maintenanceOfficer.setOfficerID(officerID);
            maintenanceOfficer.setName(name);
            maintenanceOfficer.setContact(contact);
            maintenanceOfficer.setMail(mail);
            maintenanceOfficer.setUsername(username);
            maintenanceOfficer.setPassword(password);
            maintenanceOfficer.setProfilePath(profilePath);
            maintenanceOfficer.setApartmentID(apartmentID);

        }

        db.close();
        return maintenanceOfficer;
    }
    public ArrayList<Flat> getVacantFlatListInApartmentWithID(long apartmentID)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String table = Constants.FLAT_TABLE_NAME;
        String[] columns = new String[]{Constants.ID_KEY,
                Constants.FLAT_NUMBER_KEY,
                Constants.FLAT_FLOOR_KEY,
                Constants.FLAT_FURNISHED_TYPE_KEY,
                Constants.FLAT_TYPE_KEY,
                Constants.FLAT_OCCUPANCY_TYPE_KEY,
                Constants.FLAT_NUMBER_OF_BEDROOMS_KEY
        };

        String where = Constants.APARTMENT_ID_KEY + " =?" + " AND " + Constants.FLAT_TYPE_KEY + " =?";

        Cursor cursor = db.query(table, columns, where, new String[]{String.valueOf(apartmentID), Constants.VACANT_FLAT_TYPE}, null, null, null, null);

        ArrayList<Flat> flatList = new ArrayList();
        if (cursor.moveToFirst()) {
            do {
                long flatID = Long.parseLong(cursor.getString(cursor.getColumnIndex(Constants.ID_KEY)));

                String number = cursor.getString(cursor.getColumnIndex(Constants.FLAT_NUMBER_KEY));
                int floor = cursor.getInt(cursor.getColumnIndex(Constants.FLAT_FLOOR_KEY));
                String furnishedType = cursor.getString(cursor.getColumnIndex(Constants.FLAT_FURNISHED_TYPE_KEY));
                String flatType = cursor.getString(cursor.getColumnIndex(Constants.FLAT_TYPE_KEY));
                String flatOccupancyType = cursor.getString(cursor.getColumnIndex(Constants.FLAT_OCCUPANCY_TYPE_KEY));

                int numberOfBedrooms = cursor.getInt(cursor.getColumnIndex(Constants.FLAT_NUMBER_OF_BEDROOMS_KEY));
                Flat flat = new Flat();
                flat.setFlatID(flatID);
                flat.setFlatNumber(number);
                flat.setFloorNumber(floor);
                flat.setFurnishedType(furnishedType);
                flat.setFlatType(flatType);
                flat.setNumberOfBedrooms(numberOfBedrooms);
                flat.setApartmentID(apartmentID);
                flat.setOccupancyType(flatOccupancyType);
                flatList.add(flat);
            } while (cursor.moveToNext());
        }
        db.close();
        return flatList;

    }

    public ArrayList<Flat> getFlatListInApartmentWithID(long apartmentID)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String table = Constants.FLAT_TABLE_NAME;
        String[] columns = new String[]{Constants.ID_KEY,
                Constants.FLAT_NUMBER_KEY,
                Constants.FLAT_FLOOR_KEY,
                Constants.FLAT_FURNISHED_TYPE_KEY,
                Constants.FLAT_TYPE_KEY,
                Constants.FLAT_OCCUPANCY_TYPE_KEY,
                Constants.FLAT_NUMBER_OF_BEDROOMS_KEY
                };

        String where = Constants.APARTMENT_ID_KEY + " =?";

        Cursor cursor = db.query(table, columns, where, new String[]{String.valueOf(apartmentID)}, null, null, null, null);

        ArrayList<Flat> flatList = new ArrayList();
        if (cursor.moveToFirst()) {
            do {
                long flatID = Long.parseLong(cursor.getString(cursor.getColumnIndex(Constants.ID_KEY)));

                String number = cursor.getString(cursor.getColumnIndex(Constants.FLAT_NUMBER_KEY));
                int floor = cursor.getInt(cursor.getColumnIndex(Constants.FLAT_FLOOR_KEY));
                String furnishedType = cursor.getString(cursor.getColumnIndex(Constants.FLAT_FURNISHED_TYPE_KEY));
                String flatType = cursor.getString(cursor.getColumnIndex(Constants.FLAT_TYPE_KEY));
                String flatOccupancyType = cursor.getString(cursor.getColumnIndex(Constants.FLAT_OCCUPANCY_TYPE_KEY));

                int numberOfBedrooms = cursor.getInt(cursor.getColumnIndex(Constants.FLAT_NUMBER_OF_BEDROOMS_KEY));
                Flat flat = new Flat();
                flat.setFlatID(flatID);
                flat.setFlatNumber(number);
                flat.setFloorNumber(floor);
                flat.setFurnishedType(furnishedType);
                flat.setFlatType(flatType);
                flat.setNumberOfBedrooms(numberOfBedrooms);
                flat.setApartmentID(apartmentID);
                flat.setOccupancyType(flatOccupancyType);
                flatList.add(flat);
            } while (cursor.moveToNext());
        }
        db.close();
        return flatList;

    }

    public long addEvent(Event event)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        // Inserting Row to User table
        values.put(Constants.EVENT_TITLE_KEY, event.getTitle());
        values.put(Constants.EVENT_DESCRIPTION_KEY, event.getDescription());
        values.put(Constants.EVENT_VENUE_KEY, event.getVenue());
        values.put(Constants.EVENT_TIME_KEY, event.getTime());
        values.put(Constants.MAINTENANCEOFFICER_ID_KEY, event.getOfficerID());

        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        String date = dateFormatter.format(event.getDate().getTime());

        values.put(Constants.EVENT_DATE_KEY, date);

        long eventID = db.insert(Constants.EVENT_TABLE_NAME, null, values);

        db.close();
        return eventID;
    }
    public long addFeedback(Feedback feedback)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        // Inserting Row to User table
        values.put(Constants.FEEDBACK_DESCRIPTION_KEY, feedback.getDescription());
        values.put(Constants.EVENT_ID_KEY, feedback.getEventID());
        values.put(Constants.RESIDENT_ID_KEY, feedback.getResidentID());
        values.put(Constants.APARTMENT_ID_KEY, feedback.getApartmentID());

        long feedbackID = db.insert(Constants.FEEDBACK_TABLE_NAME, null, values);

        db.close();
        return feedbackID;
    }
    public Feedback getFeedbackWithID(long feedbackID)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String table = Constants.FEEDBACK_TABLE_NAME;
        String[] columns = new String[]{
                Constants.ID_KEY,
                Constants.FEEDBACK_DESCRIPTION_KEY,
                Constants.EVENT_ID_KEY,
                Constants.APARTMENT_ID_KEY,
                Constants.RESIDENT_ID_KEY};
        String where_clause = Constants.ID_KEY + " =?" ;

        Cursor cursor = db.query(table, columns, where_clause,
                new String[]{String.valueOf(feedbackID)}, null, null, null, null);

        Feedback feedback = null;
        if (cursor.moveToFirst()) {

            String description = cursor.getString(cursor.getColumnIndex(Constants.FEEDBACK_DESCRIPTION_KEY));
            long eventID = cursor.getLong(cursor.getColumnIndex(Constants.EVENT_ID_KEY));
            long residentID = cursor.getLong(cursor.getColumnIndex(Constants.RESIDENT_ID_KEY));
            long apartmentID = cursor.getLong(cursor.getColumnIndex(Constants.APARTMENT_ID_KEY));

            feedback = new Feedback();
            feedback.setFeedbackID(feedbackID);
            feedback.setDescription(description);
            feedback.setEventID(eventID);
            feedback.setResidentID(residentID);
            feedback.setApartmentID(apartmentID);
        }

        db.close();
        return feedback;

    }
    public ArrayList<Feedback> getFeedbackListForApartmentWithID(long apartmentID)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String table = Constants.FEEDBACK_TABLE_NAME;
        String[] columns = new String[]{
                Constants.ID_KEY,
                Constants.FEEDBACK_DESCRIPTION_KEY,
                Constants.EVENT_ID_KEY,
                Constants.RESIDENT_ID_KEY};
        String where = Constants.APARTMENT_ID_KEY + " =?";
        Cursor cursor = db.query(table, columns, where,
                new String[]{String.valueOf(apartmentID)}, null, null, null, null);

        ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();
        if (cursor.moveToFirst()) {
            do {
                long feedbackID = cursor.getLong(cursor.getColumnIndex(Constants.ID_KEY));
                String description = cursor.getString(cursor.getColumnIndex(Constants.FEEDBACK_DESCRIPTION_KEY));
                long eventID = cursor.getLong(cursor.getColumnIndex(Constants.EVENT_ID_KEY));
                long residentID = cursor.getLong(cursor.getColumnIndex(Constants.RESIDENT_ID_KEY));

                Feedback feedback = new Feedback();
                feedback.setFeedbackID(feedbackID);
                feedback.setDescription(description);
                feedback.setEventID(eventID);
                feedback.setResidentID(residentID);
                feedback.setApartmentID(apartmentID);
                feedbackList.add(feedback);
            } while (cursor.moveToNext());
        }

        db.close();
        return feedbackList;
    }

    public ArrayList<Event> getEventList()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String table = Constants.EVENT_TABLE_NAME;
        String[] columns = new String[]{Constants.ID_KEY,
                Constants.EVENT_TITLE_KEY,
                Constants.EVENT_DESCRIPTION_KEY,
                Constants.MAINTENANCEOFFICER_ID_KEY,

                Constants.EVENT_VENUE_KEY,
                Constants.EVENT_DATE_KEY,
                Constants.EVENT_TIME_KEY};

        Cursor cursor = db.query(table, columns, null, null, null, null, null, null);

        ArrayList<Event> eventList = new ArrayList();
        if (cursor.moveToFirst()) {
            do {
                long eventID = Long.parseLong(cursor.getString(cursor.getColumnIndex(Constants.ID_KEY)));
                long officerID = Long.parseLong(cursor.getString(cursor.getColumnIndex(Constants.MAINTENANCEOFFICER_ID_KEY)));

                String title = cursor.getString(cursor.getColumnIndex(Constants.EVENT_TITLE_KEY));
                String description = cursor.getString(cursor.getColumnIndex(Constants.EVENT_DESCRIPTION_KEY));
                String venue = cursor.getString(cursor.getColumnIndex(Constants.EVENT_VENUE_KEY));
                String time = cursor.getString(cursor.getColumnIndex(Constants.EVENT_TIME_KEY));
                String dateString = cursor.getString(cursor.getColumnIndex(Constants.EVENT_DATE_KEY));
                Calendar date = Utility.stringToDate(dateString);

                Event event = new Event();
                event.setEventID(eventID);
                event.setTitle(title);
                event.setDescription(description);
                event.setVenue(venue);
                event.setTime(time);
                event.setDate(date);
                event.setOfficerID(officerID);

                eventList.add(event);
            } while (cursor.moveToNext());
        }
        db.close();
        return eventList;
    }
    public Event getEventWithId(long eventID)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String table = Constants.EVENT_TABLE_NAME;
        String[] columns = new String[]{
                Constants.EVENT_TITLE_KEY,
                Constants.EVENT_DESCRIPTION_KEY,
                Constants.EVENT_VENUE_KEY,
                Constants.MAINTENANCEOFFICER_ID_KEY,
                Constants.EVENT_DATE_KEY,
                Constants.EVENT_TIME_KEY};
        String where_clause = Constants.ID_KEY + " =?" ;

        Cursor cursor = db.query(table, columns, where_clause, new String[]{String.valueOf(eventID)}, null, null, null, null);

        Event event = null;
        if (cursor.moveToFirst()) {
            do {
                long officerID = Long.parseLong(cursor.getString(cursor.getColumnIndex(Constants.MAINTENANCEOFFICER_ID_KEY)));

                String title = cursor.getString(cursor.getColumnIndex(Constants.EVENT_TITLE_KEY));
                String description = cursor.getString(cursor.getColumnIndex(Constants.EVENT_DESCRIPTION_KEY));
                String venue = cursor.getString(cursor.getColumnIndex(Constants.EVENT_VENUE_KEY));
                String time = cursor.getString(cursor.getColumnIndex(Constants.EVENT_TIME_KEY));
                String dateString = cursor.getString(cursor.getColumnIndex(Constants.EVENT_DATE_KEY));
                Calendar date = Utility.stringToDate(dateString);

                event = new Event();
                event.setEventID(eventID);
                event.setTitle(title);
                event.setDescription(description);
                event.setVenue(venue);
                event.setTime(time);
                event.setDate(date);
                event.setOfficerID(officerID);

            } while (cursor.moveToNext());
        }
        db.close();
        return event;
    }

    public ArrayList<Resident> getResidentListInApartmentWithID(long apartmentID)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String table = Constants.RESIDENT_TABLE_NAME;
        String[] tableColumns = new String[]{
               Constants.ID_KEY,
                Constants.RESIDENT_NAME_KEY,
                Constants.RESIDENT_MAIL_KEY,
                Constants.RESIDENT_CONTACT_KEY,
                Constants.RESIDENT_USERNAME_KEY,
                Constants.RESIDENT_PASSWORD_KEY,
                Constants.RESIDENT_PROFILEPATH_KEY,
                Constants.APARTMENT_ID_KEY,
                Constants.FLAT_ID_KEY};

        String where = Constants.APARTMENT_ID_KEY + " =?";

        Cursor cursor = db.query(table, tableColumns, where, new String[]{String.valueOf(apartmentID)}, null, null, null, null);

        ArrayList<Resident> residentList = new ArrayList();
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(Constants.RESIDENT_NAME_KEY));

                String mail = cursor.getString(cursor.getColumnIndex(Constants.RESIDENT_MAIL_KEY));
                String mobile = cursor.getString(cursor.getColumnIndex(Constants.RESIDENT_CONTACT_KEY));
                String username = cursor.getString(cursor.getColumnIndex(Constants.RESIDENT_USERNAME_KEY));
                String password = cursor.getString(cursor.getColumnIndex(Constants.RESIDENT_PASSWORD_KEY));
                String profilePath = cursor.getString(cursor.getColumnIndex(Constants.RESIDENT_PROFILEPATH_KEY));
                long flatID = cursor.getLong(cursor.getColumnIndex(Constants.FLAT_ID_KEY));
                long residentID = cursor.getLong(cursor.getColumnIndex(Constants.ID_KEY));

                Resident resident = new Resident();
                resident.setResidentID(residentID);
                resident.setName(name);
                resident.setMail(mail);
                resident.setContact(mobile);
                resident.setUsername(username);
                resident.setPassword(password);
                resident.setProfilePath(profilePath);
                resident.setApartmentID(apartmentID);
                resident.setFlatID(flatID);
                residentList.add(resident);
            } while (cursor.moveToNext());
        }
        db.close();
        return residentList;

    }


    public Resident getResidentWithId(long residentID)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Resident resident = null;

        String table = Constants.RESIDENT_TABLE_NAME;
        String[] tableColumns = new String[]{
                Constants.RESIDENT_NAME_KEY,
                Constants.RESIDENT_MAIL_KEY,
                Constants.RESIDENT_CONTACT_KEY,
                Constants.RESIDENT_USERNAME_KEY,
                Constants.RESIDENT_PASSWORD_KEY,
                Constants.RESIDENT_PROFILEPATH_KEY,
                Constants.APARTMENT_ID_KEY,
                Constants.FLAT_ID_KEY};

        String where_clause = Constants.ID_KEY + " =?" ;

        Cursor cursor = db.query(table, tableColumns, where_clause,
                new String[]{String.valueOf(residentID)}, null, null, null, null);

        if (cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            String name = cursor.getString(cursor.getColumnIndex(Constants.RESIDENT_NAME_KEY));

            String mail = cursor.getString(cursor.getColumnIndex(Constants.RESIDENT_MAIL_KEY));
            String mobile = cursor.getString(cursor.getColumnIndex(Constants.RESIDENT_CONTACT_KEY));
            String username = cursor.getString(cursor.getColumnIndex(Constants.RESIDENT_USERNAME_KEY));
            String password = cursor.getString(cursor.getColumnIndex(Constants.RESIDENT_PASSWORD_KEY));
            String profilePath = cursor.getString(cursor.getColumnIndex(Constants.RESIDENT_PROFILEPATH_KEY));
            long apartmentID = cursor.getLong(cursor.getColumnIndex(Constants.APARTMENT_ID_KEY));
            long flatID = cursor.getLong(cursor.getColumnIndex(Constants.FLAT_ID_KEY));

            resident = new Resident();
            resident.setResidentID(residentID);
            resident.setName(name);
            resident.setMail(mail);
            resident.setContact(mobile);
            resident.setUsername(username);
            resident.setPassword(password);
            resident.setProfilePath(profilePath);
            resident.setApartmentID(apartmentID);
            resident.setFlatID(flatID);

        }
        db.close();
        return resident;
    }

    public int updateOccupancyTypeForFlat(String occupancyType, long flatID){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.FLAT_OCCUPANCY_TYPE_KEY , occupancyType);

        // Updating row
        return db.update(Constants.FLAT_TABLE_NAME, values, Constants.ID_KEY + "=?",
                new String[]{String.valueOf(flatID)});
    }

    public int updatePasswordForResident(String newPassword, long residentID){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.RESIDENT_PASSWORD_KEY , newPassword);

        // Updating row
        return db.update(Constants.RESIDENT_TABLE_NAME, values, Constants.ID_KEY + "=?",
                new String[]{String.valueOf(residentID)});
    }

    public int updatePasswordForMaintenanceOfficer(String newPassword, long officerID){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.MAINTENANCEOFFICER_PASSWORD_KEY , newPassword);

        // Updating row
        return db.update(Constants.MAINTENANCEOFFICER_TABLE_NAME, values, Constants.ID_KEY + "=?",
                new String[]{String.valueOf(officerID)});
    }

    public Resident getResidentWithUsernameAndPassword(String userName, String password)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String table = Constants.RESIDENT_TABLE_NAME;

        String[] columns = new String[]{Constants.ID_KEY,
                Constants.RESIDENT_NAME_KEY,
                Constants.RESIDENT_MAIL_KEY,
                Constants.APARTMENT_ID_KEY,
                Constants.FLAT_ID_KEY,
                Constants.RESIDENT_CONTACT_KEY,
                Constants.RESIDENT_PROFILEPATH_KEY};
        String where = Constants.RESIDENT_USERNAME_KEY + " =?" + " AND " + Constants.RESIDENT_PASSWORD_KEY + " =?";

        Cursor cursor = db.query(table, columns, where,
                new String[]{userName, password}, null, null, null, null);
        Resident resident = null;
        if (cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            long residentID = cursor.getLong(cursor.getColumnIndex(Constants.ID_KEY));
            long apartmentID = cursor.getLong(cursor.getColumnIndex(Constants.APARTMENT_ID_KEY));
            long flatID = cursor.getLong(cursor.getColumnIndex(Constants.FLAT_ID_KEY));

            String name = cursor.getString(cursor.getColumnIndex(Constants.RESIDENT_NAME_KEY));
            String mail = cursor.getString(cursor.getColumnIndex(Constants.RESIDENT_MAIL_KEY));
            String contact = cursor.getString(cursor.getColumnIndex(Constants.RESIDENT_CONTACT_KEY));
            String profilePath = cursor.getString(cursor.getColumnIndex(Constants.RESIDENT_PROFILEPATH_KEY));


            resident = new Resident();
            resident.setResidentID(residentID);
            resident.setName(name);
            resident.setContact(contact);
            resident.setMail(mail);
            resident.setUsername(userName);
            resident.setPassword(password);
            resident.setProfilePath(profilePath);
            resident.setApartmentID(apartmentID);
            resident.setFlatID(flatID);

        }

        db.close();
        return resident;
    }
    public Resident getResidentWithUserName(String username)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String table = Constants.RESIDENT_TABLE_NAME;

        String[] columns = new String[]{Constants.ID_KEY,
                Constants.RESIDENT_NAME_KEY,
                Constants.RESIDENT_PASSWORD_KEY,
                Constants.RESIDENT_MAIL_KEY,
                Constants.APARTMENT_ID_KEY,
                Constants.FLAT_ID_KEY,
                Constants.RESIDENT_CONTACT_KEY,
                Constants.RESIDENT_PROFILEPATH_KEY};
        String where = Constants.RESIDENT_USERNAME_KEY + " =?";

        Cursor cursor = db.query(table, columns, where,
                new String[]{username}, null, null, null, null);
        Resident resident = null;
        if (cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            long residentID = cursor.getLong(cursor.getColumnIndex(Constants.ID_KEY));
            long apartmentID = cursor.getLong(cursor.getColumnIndex(Constants.APARTMENT_ID_KEY));
            long flatID = cursor.getLong(cursor.getColumnIndex(Constants.FLAT_ID_KEY));

            String name = cursor.getString(cursor.getColumnIndex(Constants.RESIDENT_NAME_KEY));
            String password = cursor.getString(cursor.getColumnIndex(Constants.RESIDENT_PASSWORD_KEY));
            String mail = cursor.getString(cursor.getColumnIndex(Constants.RESIDENT_MAIL_KEY));
            String contact = cursor.getString(cursor.getColumnIndex(Constants.RESIDENT_CONTACT_KEY));
            String profilePath = cursor.getString(cursor.getColumnIndex(Constants.RESIDENT_PROFILEPATH_KEY));

            resident = new Resident();
            resident.setResidentID(residentID);
            resident.setName(name);
            resident.setContact(contact);
            resident.setMail(mail);
            resident.setUsername(username);
            resident.setPassword(password);
            resident.setProfilePath(profilePath);
            resident.setApartmentID(apartmentID);
            resident.setFlatID(flatID);

        }

        db.close();
        return resident;
    }

    public Flat getFlatWithNumber(String flatNumber)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String table = Constants.FLAT_TABLE_NAME;
        String[] columns = new String[]{
                Constants.FLAT_NUMBER_KEY,
                Constants.ID_KEY,

                Constants.FLAT_FLOOR_KEY,
                Constants.FLAT_FURNISHED_TYPE_KEY,
                Constants.FLAT_TYPE_KEY,
                Constants.APARTMENT_ID_KEY,
                Constants.FLAT_OCCUPANCY_TYPE_KEY,
                Constants.FLAT_NUMBER_OF_BEDROOMS_KEY
        };

        String where = Constants.FLAT_NUMBER_KEY + " =?";

        Cursor cursor = db.query(table, columns, where, new String[]{flatNumber}, null, null, null, null);

        Flat flat = null;
        if (cursor.moveToFirst()) {

            int floor = cursor.getInt(cursor.getColumnIndex(Constants.FLAT_FLOOR_KEY));
            String furnishedType = cursor.getString(cursor.getColumnIndex(Constants.FLAT_FURNISHED_TYPE_KEY));
            String flatType = cursor.getString(cursor.getColumnIndex(Constants.FLAT_TYPE_KEY));
            String flatOccupancyType = cursor.getString(cursor.getColumnIndex(Constants.FLAT_OCCUPANCY_TYPE_KEY));
            long apartmentID = cursor.getLong(cursor.getColumnIndex(Constants.APARTMENT_ID_KEY));
            long flatID = cursor.getLong(cursor.getColumnIndex(Constants.ID_KEY));

            int numberOfBedrooms = cursor.getInt(cursor.getColumnIndex(Constants.FLAT_NUMBER_OF_BEDROOMS_KEY));
            flat = new Flat();
            flat.setFlatID(flatID);
            flat.setFlatNumber(flatNumber);
            flat.setFloorNumber(floor);
            flat.setFurnishedType(furnishedType);
            flat.setFlatType(flatType);
            flat.setNumberOfBedrooms(numberOfBedrooms);
            flat.setApartmentID(apartmentID);
            flat.setOccupancyType(flatOccupancyType);

        }
        db.close();
        return flat;

    }


    public Flat getFlatWithID(long flatID)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String table = Constants.FLAT_TABLE_NAME;
        String[] columns = new String[]{
                Constants.FLAT_NUMBER_KEY,
                Constants.FLAT_FLOOR_KEY,
                Constants.FLAT_FURNISHED_TYPE_KEY,
                Constants.FLAT_TYPE_KEY,
                Constants.APARTMENT_ID_KEY,
                Constants.FLAT_OCCUPANCY_TYPE_KEY,
                Constants.FLAT_NUMBER_OF_BEDROOMS_KEY
        };

        String where = Constants.ID_KEY + " =?";

        Cursor cursor = db.query(table, columns, where, new String[]{String.valueOf(flatID)}, null, null, null, null);

        Flat flat = null;
        if (cursor.moveToFirst()) {

                String number = cursor.getString(cursor.getColumnIndex(Constants.FLAT_NUMBER_KEY));
                int floor = cursor.getInt(cursor.getColumnIndex(Constants.FLAT_FLOOR_KEY));
                String furnishedType = cursor.getString(cursor.getColumnIndex(Constants.FLAT_FURNISHED_TYPE_KEY));
                String flatType = cursor.getString(cursor.getColumnIndex(Constants.FLAT_TYPE_KEY));
                String flatOccupancyType = cursor.getString(cursor.getColumnIndex(Constants.FLAT_OCCUPANCY_TYPE_KEY));
            long apartmentID = cursor.getLong(cursor.getColumnIndex(Constants.APARTMENT_ID_KEY));

                int numberOfBedrooms = cursor.getInt(cursor.getColumnIndex(Constants.FLAT_NUMBER_OF_BEDROOMS_KEY));
                flat = new Flat();
                flat.setFlatID(flatID);
                flat.setFlatNumber(number);
                flat.setFloorNumber(floor);
                flat.setFurnishedType(furnishedType);
                flat.setFlatType(flatType);
                flat.setNumberOfBedrooms(numberOfBedrooms);
                flat.setApartmentID(apartmentID);
                flat.setOccupancyType(flatOccupancyType);

        }
        db.close();
        return flat;

    }

    public void addResidentToEvent(long residentID, long eventID)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        // Inserting Row to User table
        values.put(Constants.RESIDENT_ID_KEY, residentID);
        values.put(Constants.EVENT_ID_KEY, eventID);

        long rowID = db.insert(Constants.RESIDENT_EVENT_TABLE_NAME, null, values);

        db.close();
    }


    public void addCandidateToElection(long candidateID, long electionID)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        // Inserting Row to User table
        values.put(Constants.CANDIDATE_ID_KEY, candidateID);
        values.put(Constants.ELECTION_ID_KEY, electionID);

        long rowID = db.insert(Constants.ELECTION_CANDIDATE_TABLE_NAME, null, values);

        db.close();
    }

    public void addResidentToElection(long residentID, long electionID)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        // Inserting Row to User table
        values.put(Constants.RESIDENT_ID_KEY, residentID);
        values.put(Constants.ELECTION_ID_KEY, electionID);

        long rowID = db.insert(Constants.ELECTION_RESIDENT_TABLE_NAME, null, values);

        db.close();
    }

    public DiscussionTopic getDiscussionTopicWithID(long topicID) {
        SQLiteDatabase db = this.getReadableDatabase();

        String table = Constants.DISCUSSION_TOPIC_TABLE_NAME;
        String[] columns = new String[]{Constants.ID_KEY,
                Constants.DISCUSSION_TOPIC_TITLE_KEY,
                Constants.DISCUSSION_TOPIC_DESCRIPTION_KEY,
                Constants.DISCUSSION_TOPIC_CREATION_DATE_KEY,
                Constants.DISCUSSION_TOPIC_CREATED_BY_KEY,
                Constants.USER_ID_KEY};

        String where_clause = Constants.ID_KEY + " =?" ;
        Cursor cursor = db.query(table, columns, where_clause,
                new String[]{String.valueOf(topicID)}, null, null, null, null);


        DiscussionTopic topic = null;
        if (cursor.moveToFirst()) {

                long userID = Long.parseLong(cursor.getString(cursor.getColumnIndex(Constants.USER_ID_KEY)));

                String title = cursor.getString(cursor.getColumnIndex(Constants.DISCUSSION_TOPIC_TITLE_KEY));
                String description = cursor.getString(cursor.getColumnIndex(Constants.DISCUSSION_TOPIC_DESCRIPTION_KEY));
                String createdBy = cursor.getString(cursor.getColumnIndex(Constants.DISCUSSION_TOPIC_CREATED_BY_KEY));

                String dateString = cursor.getString(cursor.getColumnIndex(Constants.DISCUSSION_TOPIC_CREATION_DATE_KEY));
                Calendar date = null;
                if (dateString != null )
                {
                    date = Utility.stringToDate(dateString);
                }
                topic = new DiscussionTopic();
                topic.setTopicID(topicID);
                topic.setTitle(title);
                topic.setUserID(userID);
                topic.setDescription(description);
                topic.setDate(date);
                topic.setUserType(createdBy);

        }
        db.close();
        return topic;

    }
    public boolean isResidentAttendingEvent(long residentID, long eventID)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String table = Constants.RESIDENT_EVENT_TABLE_NAME;
        String[] columns = new String[]{Constants.ID_KEY};

        String where_clause = Constants.RESIDENT_ID_KEY + " =?" + " AND " + Constants.EVENT_ID_KEY + " =?";
        Cursor cursor = db.query(table, columns, where_clause,
                new String[]{String.valueOf(residentID), String.valueOf(eventID)}, null, null, null, null);
        if (cursor.getCount() > 0) {
            return true;
        }
        return false;
    }


    public boolean hasResidentCastedVote(long residentID, long electionID)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String table = Constants.ELECTION_RESIDENT_TABLE_NAME;
        String[] columns = new String[]{Constants.ID_KEY};

        String where_clause = Constants.RESIDENT_ID_KEY + " =?" + " AND " + Constants.ELECTION_ID_KEY + " =?";
        Cursor cursor = db.query(table, columns, where_clause,
                new String[]{String.valueOf(residentID), String.valueOf(electionID)}, null, null, null, null);
        if (cursor.getCount() > 0) {
            return true;
        }
        return false;
    }

    public void addCommentToDiscussion(long topicID, long userID, String comment, String userType)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        // Inserting Row to User table
        values.put(Constants.DISCUSSION_TOPIC_ID_KEY, topicID);
        values.put(Constants.USER_ID_KEY, userID);
        values.put(Constants.DISCUSSION_COMMENT_KEY, comment);
        values.put(Constants.DISCUSSION_CREATED_BY_KEY, userType);


        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyyy hh:mm a", Locale.US);
        String date = dateFormatter.format(Calendar.getInstance().getTime());

        values.put(Constants.DISCUSSION_DATE_KEY,date);

        long rowID = db.insert(Constants.DISCUSSION_TABLE_NAME, null, values);

        db.close();
    }

    public ArrayList<Map<String, String>> getDiscussionsListForTopicWithID(long topicID)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String table = Constants.DISCUSSION_TABLE_NAME;
        String[] columns = new String[]{
                Constants.USER_ID_KEY,
                Constants.DISCUSSION_COMMENT_KEY,
                Constants.DISCUSSION_DATE_KEY,
                Constants.DISCUSSION_CREATED_BY_KEY
        };

        String where = Constants.DISCUSSION_TOPIC_ID_KEY + " =?";

        Cursor cursor = db.query(table, columns, where,
                new String[]{String.valueOf(topicID)}, null, null, null, null);

        ArrayList<Map<String, String>> discussionList = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                long userID = cursor.getLong(cursor.getColumnIndex(Constants.USER_ID_KEY));
                String date = cursor.getString(cursor.getColumnIndex(Constants.DISCUSSION_DATE_KEY));
                String comment = cursor.getString(cursor.getColumnIndex(Constants.DISCUSSION_COMMENT_KEY));
                String userType = cursor.getString(cursor.getColumnIndex(Constants.DISCUSSION_CREATED_BY_KEY));

                HashMap<String,String> details = new HashMap<>();
                details.put(Constants.USER_ID_KEY, String.valueOf(userID));
                details.put(Constants.DISCUSSION_DATE_KEY, date);
                details.put(Constants.DISCUSSION_COMMENT_KEY, comment);
                details.put(Constants.DISCUSSION_CREATED_BY_KEY, userType);


                discussionList.add(details);
            } while (cursor.moveToNext());
        }

        db.close();
        return discussionList;

    }

    public Election getElectionWithID(long electionID)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String table = Constants.ELECTION_TABLE_NAME;
        String[] columns = new String[]{Constants.ID_KEY,
                Constants.ELECTION_TITLE_KEY,
                Constants.ELECTION_DESCRIPTION_KEY,
                Constants.ELECTION_TYPE_KEY,
                Constants.ELECTION_DATE_KEY,
                Constants.ELECTION_QUESTION_KEY,
                Constants.ELECTION_OPTION1_KEY,
                Constants.ELECTION_OPTION2_KEY,
                Constants.ELECTION_OPTION1_COUNT_KEY,
                Constants.ELECTION_OPTION2_COUNT_KEY,
                Constants.ELECTION_CANDIDATES_KEY};

        String where = Constants.ID_KEY + " =?";

        Cursor cursor = db.query(table, columns, where,
                new String[]{String.valueOf(electionID)}, null, null, null, null);

        Election election = null;
        if (cursor.moveToFirst()) {

                String title = cursor.getString(cursor.getColumnIndex(Constants.ELECTION_TITLE_KEY));
                String type = cursor.getString(cursor.getColumnIndex(Constants.ELECTION_TYPE_KEY));
                String description = cursor.getString(cursor.getColumnIndex(Constants.ELECTION_DESCRIPTION_KEY));
                String question = cursor.getString(cursor.getColumnIndex(Constants.ELECTION_QUESTION_KEY));
                String option1 = cursor.getString(cursor.getColumnIndex(Constants.ELECTION_OPTION1_KEY));
                String option2 = cursor.getString(cursor.getColumnIndex(Constants.ELECTION_OPTION2_KEY));
                String candidateIDs = cursor.getString(cursor.getColumnIndex(Constants.ELECTION_CANDIDATES_KEY));
            int option1Count = cursor.getInt(cursor.getColumnIndex(Constants.ELECTION_OPTION1_COUNT_KEY));
            int option2Count = cursor.getInt(cursor.getColumnIndex(Constants.ELECTION_OPTION2_COUNT_KEY));

                String dateString = cursor.getString(cursor.getColumnIndex(Constants.ELECTION_DATE_KEY));
                Calendar date = null;
                if (dateString != null )
                {
                    date = Utility.stringToDate(dateString);
                }
                election = new Election();
                election.setElectionID(electionID);
                election.setTitle(title);
                election.setDescription(description);
                election.setType(type);
                election.setOpinionPollQuestion(question);
                election.setOpinionPollOption1(option1);
                election.setOpinionPollOption2(option2);
                election.setOpinionPollOption1Count(option1Count);
                election.setOpinionPollOption2Count(option2Count);

            election.setDate(date);
                if (candidateIDs != null) {
                    List<String> candidateList = new ArrayList(Arrays.asList(candidateIDs.split(",")));
                    List<Long> newList = new ArrayList(candidateList.size());
                    for (String myInt : candidateList) {
                        myInt = myInt.replace("[", "");
                        myInt = myInt.replace("]", "");
                        myInt = myInt.trim();

                        newList.add(Long.valueOf(myInt));
                    }

                    election.setCandidateIDs(newList);
                }
        }
        db.close();
        return election;

    }

    public int updateOption1CountForElection(Election election){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.ELECTION_OPTION1_COUNT_KEY , election.getOpinionPollOption1Count());

        // Updating row
        return db.update(Constants.ELECTION_TABLE_NAME, values, Constants.ID_KEY + "=?",
                new String[]{String.valueOf(election.getElectionID())});
    }

    public int updateOption2CountForElection(Election election){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.ELECTION_OPTION2_COUNT_KEY , election.getOpinionPollOption2Count());

        // Updating row
        return db.update(Constants.ELECTION_TABLE_NAME, values, Constants.ID_KEY + "=?",
                new String[]{String.valueOf(election.getElectionID())});
    }

    public int incrementVoteForCandidateInElection(long candidateID, long electionID){

        SQLiteDatabase db = this.getReadableDatabase();
        String table = Constants.ELECTION_CANDIDATE_TABLE_NAME;
        String[] columns = new String[]{
                Constants.COUNT_OF_VOTES_KEY
        };

        String where = Constants.CANDIDATE_ID_KEY + " =?" + " AND " + Constants.ELECTION_ID_KEY + " =?";

        Cursor cursor = db.query(table, columns, where,
                new String[]{String.valueOf(candidateID), String.valueOf(electionID)}, null, null, null, null);
        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(cursor.getColumnIndex(Constants.COUNT_OF_VOTES_KEY));
        }
        db.close();
           db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.COUNT_OF_VOTES_KEY , count+1);

        // Updating row
        return db.update(Constants.ELECTION_CANDIDATE_TABLE_NAME, values, where,
                new String[]{String.valueOf(candidateID), String.valueOf(electionID)});
    }

    public Map<String, String> getResultOfElectionWithID(long electionID)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = new String[]{String.valueOf(electionID)};

        Cursor cursor = db.rawQuery("select max(Count_Of_Votes), CandidateID from Election_Candidate where ElectionID" + " =? "

                , columns);
        HashMap<String,String> results = new HashMap<>();
        if (cursor.moveToFirst()) {
            int count = Integer.parseInt(cursor.getString(0));
            long candidateID = (cursor.getLong(1));

            results.put(Constants.COUNT_OF_VOTES_KEY,String.valueOf(count));
            results.put(Constants.CANDIDATE_ID_KEY,String.valueOf(candidateID));
        }
        return results;
    }

    public long addComplaint(Complaint complaint)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        // Inserting Row to User table
        values.put(Constants.APARTMENT_ID_KEY, complaint.getApartmentID());
        values.put(Constants.COMPLAINT_DESCRIPTION_KEY, complaint.getDescription());
        values.put(Constants.RESIDENT_ID_KEY, complaint.getResidentID());
        values.put(Constants.COMPLAINT_STATUS_KEY, complaint.getStatus());
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        String complaintDate = dateFormatter.format(complaint.getComplaintDate().getTime());
        values.put(Constants.COMPLAINT_DATE_KEY, complaintDate);

        long complaintID = db.insert(Constants.COMPLAINT_TABLE_NAME, null, values);

        db.close();
        return complaintID;
    }

    public Complaint getComplaintWithID(long complaintID)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String table = Constants.COMPLAINT_TABLE_NAME;

        String[] columns = new String[]{
                Constants.COMPLAINT_STATUS_KEY,
                Constants.APARTMENT_ID_KEY,
                Constants.COMPLAINT_DESCRIPTION_KEY,
                Constants.COMPLAINT_DATE_KEY,
                Constants.RESIDENT_ID_KEY};

        String where = Constants.ID_KEY + " =?" ;

        Cursor cursor = db.query(table, columns, where,
                new String[]{String.valueOf(complaintID)}, null, null, null, null);
        Complaint complaint = null;
        if (cursor.moveToFirst()) {

            long residentID = cursor.getLong(cursor.getColumnIndex(Constants.RESIDENT_ID_KEY));
            long apartmentID = cursor.getLong(cursor.getColumnIndex(Constants.APARTMENT_ID_KEY));

            String description = cursor.getString(cursor.getColumnIndex(Constants.COMPLAINT_DESCRIPTION_KEY));
            int status = cursor.getInt(cursor.getColumnIndex(Constants.COMPLAINT_STATUS_KEY));
            String date = cursor.getString(cursor.getColumnIndex(Constants.COMPLAINT_DATE_KEY));
            Calendar complaintDate = Utility.stringToDate(date);

            complaint = new Complaint();
            complaint.setComplaintID(complaintID);
            complaint.setApartmentID(apartmentID);
            complaint.setDescription(description);
            complaint.setComplaintDate(complaintDate);
            complaint.setStatus(status);
            complaint.setResidentID(residentID);
        }

        db.close();
        return complaint;
    }

    public ArrayList<Complaint> getAllComplaintsForApartmentWithID(long apartmentID)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String table = Constants.COMPLAINT_TABLE_NAME;

        String[] columns = new String[]{Constants.ID_KEY,
                Constants.COMPLAINT_STATUS_KEY,
                Constants.COMPLAINT_DESCRIPTION_KEY,
                Constants.COMPLAINT_DATE_KEY,
                Constants.APARTMENT_ID_KEY,
                Constants.RESIDENT_ID_KEY};

        String where = Constants.APARTMENT_ID_KEY + " =?";

        Cursor cursor = db.query(table, columns, where,
                new String[]{String.valueOf(apartmentID)}, null, null, null, null);
        ArrayList<Complaint> complaintList = new ArrayList();
        if (cursor.moveToFirst()) {
            do {

                long complaintID = cursor.getLong(cursor.getColumnIndex(Constants.ID_KEY));
                long residentID = cursor.getLong(cursor.getColumnIndex(Constants.RESIDENT_ID_KEY));

                String description = cursor.getString(cursor.getColumnIndex(Constants.COMPLAINT_DESCRIPTION_KEY));
                int status = cursor.getInt(cursor.getColumnIndex(Constants.COMPLAINT_STATUS_KEY));
                String date = cursor.getString(cursor.getColumnIndex(Constants.COMPLAINT_DATE_KEY));
                Calendar complaintDate = Utility.stringToDate(date);

                Complaint complaint = new Complaint();
                complaint.setComplaintID(complaintID);
                complaint.setApartmentID(apartmentID);
                complaint.setDescription(description);
                complaint.setComplaintDate(complaintDate);
                complaint.setStatus(status);
                complaint.setResidentID(residentID);
                complaintList.add(complaint);
            }while (cursor.moveToNext());

        }

        db.close();
        return complaintList;
    }
    public int updateComplaintStatus(Complaint complaint){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.COMPLAINT_STATUS_KEY , complaint.getStatus());

        // Updating row
        return db.update(Constants.COMPLAINT_TABLE_NAME, values, Constants.ID_KEY + "=?",
                new String[]{String.valueOf(complaint.getComplaintID())});
    }

    public int deleteVacantFlatWithNumber(String flatNumber)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.FLAT_TYPE_KEY , Constants.OCCUPIED_FLAT_TYPE);
        return db.update(Constants.FLAT_TABLE_NAME, values, Constants.FLAT_NUMBER_KEY + "=?",
                new String[]{flatNumber});

    }

    public void deleteResidentWithID(long residentID)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Constants.RESIDENT_TABLE_NAME, Constants.ID_KEY + "=?",
                new String[]{String.valueOf(residentID)});


        db.delete(Constants.FEEDBACK_TABLE_NAME, Constants.RESIDENT_ID_KEY + "=?",
                new String[]{String.valueOf(residentID)});


        db.delete(Constants.COMPLAINT_TABLE_NAME, Constants.RESIDENT_ID_KEY + "=?",
                new String[]{String.valueOf(residentID)});

        db.delete(Constants.DISCUSSION_TOPIC_TABLE_NAME, Constants.USER_ID_KEY + "=?",
                new String[]{String.valueOf(residentID)});

        db.delete(Constants.DISCUSSION_TABLE_NAME, Constants.USER_ID_KEY + "=?",
                new String[]{String.valueOf(residentID)});

        db.close();

    }


    public int updateFlatTypeForFlat(String flatType, long flatID){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.FLAT_TYPE_KEY , flatType);

        // Updating row
        return db.update(Constants.FLAT_TABLE_NAME, values, Constants.ID_KEY + "=?",
                new String[]{String.valueOf(flatID)});
    }



}


