package com.example.wmdesigns.listview_data;
import android.os.Parcel;
import android.os.Parcelable;

public class UserMessage implements Parcelable {
    private String messageText;
    private String email;
    protected UserMessage(Parcel in) {
        messageText = in.readString();
        email = in.readString();
    }

    public static final Creator<UserMessage> CREATOR = new Creator<UserMessage>() {
        @Override
        public UserMessage createFromParcel(Parcel in) {
            return new UserMessage(in);
        }

        @Override
        public UserMessage[] newArray(int size) {
            return new UserMessage[size];
        }
    };

    public UserMessage(String messageText, String email) {
        this.messageText = messageText;
        this.email = email;
    }
    public String getMessageText() {
        return messageText;
    }
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(messageText);
        dest.writeString(email);
    }
}
