
package com.boongg.store.Models.Requests.AvailableBikes;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RcFile implements Parcelable
{

    @SerializedName("fullUrl")
    @Expose
    private String fullUrl;
    @SerializedName("_id")
    @Expose
    private String _id;
    public final static Creator<RcFile> CREATOR = new Creator<RcFile>() {


        @SuppressWarnings({
            "unchecked"
        })
        public RcFile createFromParcel(Parcel in) {
            return new RcFile(in);
        }

        public RcFile[] newArray(int size) {
            return (new RcFile[size]);
        }

    }
    ;

    protected RcFile(Parcel in) {
        this.fullUrl = ((String) in.readValue((String.class.getClassLoader())));
        this._id = ((String) in.readValue((String.class.getClassLoader())));
    }

    public RcFile() {
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(fullUrl);
        dest.writeValue(_id);
    }

    public int describeContents() {
        return  0;
    }

}
