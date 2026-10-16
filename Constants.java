package project.android.com.utility;

public class Constants { // Error Messages
    public static final String MISSING_NAME = "Please enter name";
    public static final String MISSING_PASSWORD = "Please enter your password";
    public static final String INVALID_ADMIN_CREDENTIALS = "Wrong Credentials";
    public static final String INVALID_USER = "Wrong Credentials";
    public static final String MISSING_MAIL = "Please enter mail";
    public static final String MISSING_PASSWORD_CONFIRMATION = "Please confirm your password";
    public static final String PASSWORD_MISMATCH = "Password does not match";
    public static final String INVALID_MOBILE = "Mobile number should be 10 digit number";
    // App Description
    public static final String APP_DESCRIPTION = "Housing Society Maintenance App is a mobile app for Housing & Commercial Societies which provides a unique experience in Community Living. \nIt helps with effective administration & management within the complex. It is a perfect solution to make living in an apartment complex a pleasant and convenient experience - for the residents, the managing committee members and the admin.";

    // Database version
    public static final int DATABASE_VERSION = 1;

    // Database name
    public static final String DATABASE_NAME = "ResidentialMaintenance";

    // Common column names
    public static final String ID_KEY = "_id";

    public static final String DRAWABLE_RESOURCE = "drawable";


    //Apartment Table
    public static final String APARTMENT_TABLE_NAME ="Apartment" ;
    public static final String APARTMENT_NAME_KEY = "Name";
    public static final String APARTMENT_DESCRIPTION_KEY = "Description";
    public static final String APARTMENT_ADDRESS_KEY ="Address" ;
    public static final String APARTMENT_NUMBEROFFLATS_KEY = "NumberOfFlats";
    public static final String APARTMENT_PROFILEPATH_KEY = "PicturePath";
    public static final String APARTMENT_TYPE_KEY = "Type";
    public static final String APARTMENT_OPENING_KEY = "OpeningDate";

    //Maintenance Officer table
    public static final String MAINTENANCEOFFICER_TABLE_NAME ="MaintenanceOfficer" ;
    public static final String MAINTENANCEOFFICER_NAME_KEY ="Name" ;
    public static final String MAINTENANCEOFFICER_PASSWORD_KEY ="Password" ;
    public static final String MAINTENANCEOFFICER_MAIL_KEY ="Mail";
    public static final String MAINTENANCEOFFICER_CONTACT_KEY = "Contact";
    public static final String MAINTENANCEOFFICER_PROFILEPATH_KEY ="ProfilePath" ;
    public static final String MAINTENANCEOFFICER_USERNAME_KEY ="Username" ;
    public static final String APARTMENT_ID_KEY ="ApartmentID" ;

    //Flat table
    public static final String FLAT_TABLE_NAME ="Flat" ;
    public static final String FLAT_NUMBER_KEY ="Number" ;
    public static final String FLAT_FLOOR_KEY ="FloorNumber" ;
    public static final String FLAT_FURNISHED_TYPE_KEY ="FurnishedType";
    public static final String FLAT_NUMBER_OF_BEDROOMS_KEY = "NumberOfBedrooms";
    public static final String FLAT_TYPE_KEY ="FlatType";
    public static final String FLAT_OCCUPANCY_TYPE_KEY ="FlatOccupancyType";


    //Resident table
    public static final String RESIDENT_TABLE_NAME ="Resident" ;
    public static final String RESIDENT_NAME_KEY ="Name" ;
    public static final String RESIDENT_PASSWORD_KEY ="Password" ;
    public static final String RESIDENT_MAIL_KEY ="Mail";
    public static final String RESIDENT_CONTACT_KEY = "Contact";
    public static final String RESIDENT_PROFILEPATH_KEY ="ProfilePath" ;
    public static final String RESIDENT_USERNAME_KEY ="Username" ;
    public static final String FLAT_ID_KEY ="FlatID" ;

    // Event Table
    public static final String EVENT_TABLE_NAME = "Event";
    public static final String EVENT_TITLE_KEY = "title";
    public static final String EVENT_DESCRIPTION_KEY = "description";
    public static final String EVENT_VENUE_KEY = "venue";
    public static final String EVENT_DATE_KEY = "date";
    public static final String EVENT_TIME_KEY = "time";
    public static final String MAINTENANCEOFFICER_ID_KEY ="OfficerID" ;

    // Election Table
    public static final String ELECTION_TABLE_NAME = "Election";
    public static final String ELECTION_TITLE_KEY = "title";
    public static final String ELECTION_DESCRIPTION_KEY = "description";
    public static final String ELECTION_DATE_KEY = "date";
    public static final String ELECTION_TYPE_KEY = "type";
    public static final String ELECTION_CANDIDATES_KEY = "candidates";
    public static final String ELECTION_QUESTION_KEY = "question";
    public static final String ELECTION_OPTION1_KEY = "option1";
    public static final String ELECTION_OPTION2_KEY = "option2";
    public static final String ELECTION_OPTION1_COUNT_KEY = "option1_count";
    public static final String ELECTION_OPTION2_COUNT_KEY = "option2_count";

    // Vote Table
    public static final String ELECTION_RESIDENT_TABLE_NAME = "Election_Resident";
    public static final String ELECTION_ID_KEY = "ElectionID";

    // Election Candidate Table
    public static final String ELECTION_CANDIDATE_TABLE_NAME = "Election_Candidate";
    public static final String CANDIDATE_ID_KEY = "CandidateID";
    public static final String COUNT_OF_VOTES_KEY = "Count_Of_Votes";

    // Feedback Table
    public static final String FEEDBACK_TABLE_NAME = "Feedback";
    public static final String FEEDBACK_DESCRIPTION_KEY = "Description";
    public static final String RESIDENT_ID_KEY = "ResidentID";

    // Discussion Topic Table
    public static final String DISCUSSION_TOPIC_TABLE_NAME = "Discussion_Topic";
    public static final String DISCUSSION_TOPIC_DESCRIPTION_KEY = "Description";
    public static final String USER_ID_KEY = "UserID";
    public static final String DISCUSSION_TOPIC_TITLE_KEY = "Title";
    public static final String DISCUSSION_TOPIC_CREATION_DATE_KEY = "Date";
    public static final String DISCUSSION_TOPIC_CREATED_BY_KEY = "CreatedBy";

    // Discussions Table
    public static final String DISCUSSION_TABLE_NAME = "Discussions";
    public static final String DISCUSSION_COMMENT_KEY = "Comment";
    public static final String DISCUSSION_TOPIC_ID_KEY = "TopicID";
    public static final String DISCUSSION_DATE_KEY = "Date";
    public static final String DISCUSSION_CREATED_BY_KEY = "CreatedBy";


    // Complaint Table
    public static final String COMPLAINT_TABLE_NAME = "Complaint";
    public static final String COMPLAINT_DESCRIPTION_KEY = "Description";
    public static final String COMPLAINT_DATE_KEY = "Date";
    public static final String COMPLAINT_STATUS_KEY = "Status";

    public static final String EVENT_ID_KEY = "event_id";

    public static final String ALREADY_ATTENDING_EVENT = "You are already attending this event";
    public static final String THANKS_FOR_ATTENDING = "Thanks for attending the event. Maintenance Officer is notified of your attendance for the event";




    public static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;
    public static final String FORGOT_PASSWORD ="The registered password has been sent to your registered mobile number" ;
    public static final String INVALID_CREDENTIALS = "Wrong Credentials";


    public static final String MISSING_MOBILE ="Please enter your Mbl no" ;
    public static final String MISSING_USERNAME ="Please enter username" ;
    public static final String INVALID_EMAIL = "Please enter valid Email";
    public static final String MISSING_EMAIL="Please enter your  Mail";
    public static final String INVALID_PASSWORD ="Please enter valid password" ;
    public static final int MINIMUM_PASSWORD_LENGTH = 8;
    public static final int REQUEST_CAMERA =123 ;
    public static final int SELECT_FILE =234 ;

    public static final String ADMIN_PASSWORD ="admin" ;
    public static final String ADMIN_PASSWORD_KEY ="password" ;
    public static final String ADMIN_MOBILE = "";


    public static final String FEEDBACK_SUBJECT = "Housing Society Maintenance App Feedback";
    public static final String FEEDBACK_MAILID = "residentialsocietymaintenance@gmail.com";
    public static final String HELP_MESSAGE = "Please mail to \nresidentialsocietymaintenance@gmail.com\nfor any help regarding the app.";

    public static final String NOT_APPLICABLE = "N/A";

    public static final String MISSING_OLD_PASSWORD = "Please enter your old password";
    public static final String OLD_PASSWORD_INCORRECT = "Your old password is incorrect";
    public static final String MISSING_NEW_PASSWORD = "Please enter your new password";
    public static final String PASSWORD_CHANGED_SUCCESSFULLY = "Password is changed successfully";

    public static final String MISSING_ADDRESS ="Please enter your address" ;


    public static final String MISSING_FEEDBACK_DESCRIPTION = "Please enter feedback";
    public static final String FEEDBACK_POSTED_SUCCESSSFULLY = "Feedback is posted successfully";
    public static final String NOFEEDBACK_DESCRIPTION = "There is no feedback by any of the residents";

    public static final String MISSING_EVENT_VENUE = "Please enter event venue";
    public static final String MISSING_EVENT_TITLE = "Please enter event title";
    public static final String MISSING_EVENT_DESCRIPTION = "Please enter event description";
    public static final String EVENT_ADDED_SUCCESSFULLY = "Event is added successfully";
    public static final String NOEVENT_DESCRIPTION = "Currently there are no events";

    public static final String NOCOMPLAINTS_DESCRIPTION = "There are no complaints by any of the residents";
    public static final String MISSING_DATE = "Please select a date";
    public static final String MISSING_TIME = "Please select a time";


    public static final String INVALID_MAIL = "Please enter valid mail";
    public static final String DETAILS_EDITED_SUCCESSFULLY = "Details are edited successfully";

    public static final String NO_EVENTS = "You cannot post feedback since there are no events";
    public static final String NO_VACANT_FLATS_DESCRIPTION = "There are no vacant flats";
    public static final String DUPLICATE_USERNAME = "Username already exists. Please select a different username";

    // Add Apartment
    public static final String MISSING_APARTMENTNAME = "Please enter Apartment name";
    public static final String MISSING_APARTMENTDESCRIPTION = "Please enter Apartment description";
    public static final String MISSING_APARTMENTADDRESS = "Please enter Apartment address";
    public static final String MISSING_APARTMENTFLATS = "Please enter number of flats in the Apartment";
    public static final String APARTMENT_ADDED_SUCCESSFULLY = "Apartment is added successfully";

    // Add Flat
    public static final String MISSING_FLATNUMBER = "Please enter Flat number";
    public static final String MISSING_FLOORNUMBER = "Please enter Floor number";
    public static final String FLAT_ADDED_SUCCESSFULLY = "Flat is added successfully";

    // Add Maintenance Officer
    public static final String MAINTENANCEOFFICER_ADDED_SUCCESSFULLY = "Maintenance Officer is added successfully";
    public static final String MISSING_MAINTENANCEOFFICER_PROFILEPHOTO = "Please enter maintenance officer photo";
    public static final String UNREGISTERED_OFFICER = "Maintenance Officer is not added by the Admin. You cannot continue" ;;

    // Add Resident
    public static final String RESIDENT_ADDED_SUCCESSFULLY = "Resident is added successfully";
    public static final String EXISTING_APARTMENT = "Existing";
    public static final String UPCOMING_APARTMENT = "Upcoming";
    public static final String UNREGISTERED_RESIDENT = "Maintenance Officer has not added you as Resident. You cannot continue" ;;

    public static final String VACANT_FLAT_TYPE = "Vacant";
    public static final String OCCUPIED_FLAT_TYPE = "Occupied";

    public static final String CANNOT_ADD_RESIDENT = "Admin has not added any flats for this Apartment. So residents cannot be added";
    public static final String CANNOT_ADD_MAINTENANCE_OFFICER = "Maintenance Officer can be added only after adding Apartments.";
    public static final String CANNOT_ADD_FLAT = "Flat can be added only after adding Apartments.";

    public static final String RESIDENT_EVENT_TABLE_NAME = "Resident_Event";

    public static final String MISSING_REMINDER_DESCRIPTION = "Please enter reminder text";
    public static final String REMINDER_POSTED_SUCCESSSFULLY = "Reminder is posted successfully";
    public static final String CANNOT_POST_REMINDER = "Reminder can be posted only after adding residents";
    public static final String TOPIC_POSTED_SUCCESSFULLY = "New topic is posted successfullly";
    public static final String MISSING_TOPIC_DESCRIPTION = "Please enter topic description";
    public static final String MISSING_TOPIC_TITLE = "Please enter topic title";

    public static final String RESIDENT = "Resident";
    public static final String OFFICER = "Officer";
    public static final String ADMIN = "Admin";

    public static final long ADMIN_ID = 1234;
    public static final String NODISCUSSIONS_DESCRIPTION = "There are no topics to discuss";
    public static final String MISSING_COMMENT = "Please enter comment text";
    public static final String NODISCUSSIONS_IN_THIS_TOPIC_DESCRIPTION = "There are no discussions in this topic";
    public static final String COMMENT_POSTED_SUCCESSFULLY = "Comment is posted successfully";
    public static final String MISSING_ELECTION_TITLE = "Please enter a title for the election";
    public static final String MISSING_ELECTION_DESCRIPTION = "Please enter a description for the election";
    public static final String ELECTION_ADDED_SUCCESSFULLY = "Election is added successfully";
    public static final String MISSING_QUESTION = "Please enter opinion poll question";
    public static final String MISSING_OPTION1 = "Please enter first option";
    public static final String MISSING_OPTION2 = "Please enter second option";

    public static final String CANDIDATE_MISSING = "Please select candidates";
    public static final String ONLY_ONE_CANDIDATE = "Please select more than one candidate";

    public static final String CANDIDATE_ELECTION = "Candidate";
    public static final String OPINIONPOLL_ELECTION = "OpinionPoll";

    public static final String NOELECTION_DESCRIPTION = "There are no elections currently";
    public static final String NO_CANDIDATES = "There should be more than one candidate for the elections";
    public static final String VOTE_CAST_SUCCESSFULLY = "Your vote is cast successfully";

    public static final String NOCOMPLAINT_DESCRIPTION = "Currently there are no complaints by any of the visitors";

    public static final int NEW_COMPLAINT = 0;
    public static final int OPEN_COMPLAINT = 1;
    public static final int PENDING_COMPLAINT = 2;
    public static final int  RESOLVED_COMPLAINT = 3;
    public static final int CLOSED_COMPLAINT = 4;

    public static final String[] status = {"NEW", "OPEN", "PENDING", "RESOLVED", "CLOSED"};
    public static final String COMPLAINTPOSTING_PROGRESS = "Posting Complaint...";
    public static final String COMPLAINT_POSTED_SUCCESSFULLY = "Complaint is posted successfully";
    public static final String STATUS_UPDATED_SUCCESSFULY = "Status is updated successfully";
    public static final String INVALID_STATUS = "You cannot select a status lower than the previous one";


    public static final String MISSING_COMPLAINT_DESCRIPTION = "Please enter a description for the complaint";
    public static final String RESULT_POSTED_SUCCESSFULLY = "Results are posted successfully";

    public static final String MISSING_VEHICLENUMBER = "Please enter vehicle number";
    public static final String BOOKING_SLOT_PROGRESS = "Booking being processed... Please wait.";


    public static final String SLOT_BOOKED_SUCCESSFULLY = "Slot is booked successfully";
    public static final String SELECT_SLOT = "Please select a slot";

    public static final String NO_FLAT_TO_DELETE = "There are no vacant flats to delete";
    public static final String FLAT_DELETED_SUCCESSFULLY = "Flat is deleted successfully";
    public static final String NO_RESIDENT_TO_DELETE = "There are no residents to delete";
    public static final String RESIDENT_DELETED_SUCCESSFULLY = "Resident is deleted successfully";
    public static final String MISSING_RESIDENT_PROFILEPHOTO = "Please enter a profile photo for the resident";
}
