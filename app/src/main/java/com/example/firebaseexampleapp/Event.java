package com.example.firebaseexampleapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.ParseException;

/**
 * This class implements the Parcelable interface so that Event objects can be passed through the intent
 * https://code.tutsplus.com/tutorials/how-to-pass-data-between-activities-with-android-parcelable--cms-29559
 *
 */
public class Event implements Parcelable
{
    private String eventName;
    private String eventDate;
    private int year;
    private int month;
    private int day;
    //private Date date;
    private String key;

    public static final Parcelable.Creator<Event> CREATOR = new Parcelable.Creator<Event>() {

        @Override
        public Event createFromParcel(Parcel parcel) {
            return new Event(parcel);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[0];
        }
    };


    public Event(Parcel parcel) {
        eventName = parcel.readString();
        eventDate = parcel.readString();
        month = parcel.readInt();
        year = parcel.readInt();
        day = parcel.readInt();
        key = parcel.readString();

    }

    public Event(String eventName, String eventDate, int year, int month, int day) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.year = year;
        this.month = month;
        this.day = day;
        this.key = "no key yet";
    }

    public Event(String eventName, String eventDate, int year, int month, int day, String key) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.year = year;
        this.month = month;
        this.day = day;
        this.key = key;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(eventName);
        dest.writeString(eventDate);
        dest.writeInt(month);
        dest.writeInt(year);
        dest.writeInt(day);
        dest.writeString(key);

        // need to add the Date object

        /**
         * If your Parcelable class will have child classes, you'll need to
         * take some extra care with the describeContents() method. This will
         * let you identify the specific child class that should be created by
         * the Parcelable.Creator. You can read more about how this works on
         * Stack Overflow.
         *
         * https://stackoverflow.com/questions/4778834/purpose-of-describecontents-of-parcelable-interface
         */
    }

    public boolean equals(Event other) {
        return this.eventDate.equals(other.eventDate) && this.eventName.equals(other.eventName);
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public int getYear(){ return year;}

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }


    /**
     * This method creates the display ready version of the Event that will show up
     * in the listview when we show all events.
     * @return
     */
    public String toString() {
        String str = "";
        if (month == 1)
            str += "Jan ";
        else if (month == 2)
            str += "Feb ";
        else if (month == 3)
            str += "Mar ";
        else if (month == 4)
            str += "Apr ";
        else if (month == 5)
            str += "May ";
        else if (month == 6)
            str += "Jun ";
        else if (month == 7)
            str += "Jul ";
        else if (month == 8)
            str += "Aug ";
        else if (month == 9)
            str += "Sep ";
        else if (month == 10)
            str += "Oct ";
        else if (month == 11)
            str += "Nov ";
        else
            str += "Dec ";


        // Extra space to keep it looking uniform in listview
        if (day < 10)
            str += "  ";

        str += day;
        str += ", " + year + "   " + eventName;

        return str;
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
