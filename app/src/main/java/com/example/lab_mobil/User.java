package com.example.lab_mobil;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    String name,surname,nam_sur;


//---------------------------------------------
    public User(String name, String surname, String nam_sur) {
        this.name = name;
        this.surname = surname;
        this.nam_sur = nam_sur;
    }

    protected User(Parcel in) {
        name = in.readString();
        surname = in.readString();
        nam_sur = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(surname);
        dest.writeString(nam_sur);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
