
package com.boongg.store.Models.Requests.AvailableBikes;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AvailableBike implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private String _id;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("vehicleModel")
    @Expose
    private String vehicleModel;
    @SerializedName("engineCapacity")
    @Expose
    private Integer engineCapacity;
    @SerializedName("year")
    @Expose
    private Integer year;
    @SerializedName("kmTravel")
    @Expose
    private Integer kmTravel;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("chassisNumber")
    @Expose
    private String chassisNumber;
    @SerializedName("engineNumber")
    @Expose
    private String engineNumber;
    @SerializedName("registrationNumber")
    @Expose
    private String registrationNumber;
    @SerializedName("purchaseCost")
    @Expose
    private Integer purchaseCost;
    @SerializedName("sellCost")
    @Expose
    private Integer sellCost;
    @SerializedName("statusType")
    @Expose
    private StatusType statusType;
    @SerializedName("_storeKey")
    @Expose
    private String _storeKey;
    @SerializedName("__v")
    @Expose
    private Integer __v;
    @SerializedName("owner")
    @Expose
    private List<Owner> owner = null;
    @SerializedName("licenceFiles")
    @Expose
    private List<LicenceFile> licenceFiles = null;
    @SerializedName("pucFiles")
    @Expose
    private List<PucFile> pucFiles = null;
    @SerializedName("rcFiles")
    @Expose
    private List<RcFile> rcFiles = null;
    @SerializedName("id")
    @Expose
    private String id;
    public final static Creator<AvailableBike> CREATOR = new Creator<AvailableBike>() {


        @SuppressWarnings({
            "unchecked"
        })
        public AvailableBike createFromParcel(Parcel in) {
            return new AvailableBike(in);
        }

        public AvailableBike[] newArray(int size) {
            return (new AvailableBike[size]);
        }

    }
    ;

    protected AvailableBike(Parcel in) {
        this._id = ((String) in.readValue((String.class.getClassLoader())));
        this.brand = ((String) in.readValue((String.class.getClassLoader())));
        this.vehicleModel = ((String) in.readValue((String.class.getClassLoader())));
        this.engineCapacity = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.year = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.kmTravel = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.color = ((String) in.readValue((String.class.getClassLoader())));
        this.chassisNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.engineNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.registrationNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.purchaseCost = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.sellCost = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.statusType = ((StatusType) in.readValue((StatusType.class.getClassLoader())));
        this._storeKey = ((String) in.readValue((String.class.getClassLoader())));
        this.__v = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.owner, (Owner.class.getClassLoader()));
        in.readList(this.licenceFiles, (LicenceFile.class.getClassLoader()));
        in.readList(this.pucFiles, (PucFile.class.getClassLoader()));
        in.readList(this.rcFiles, (RcFile.class.getClassLoader()));
        this.id = ((String) in.readValue((String.class.getClassLoader())));
    }

    public AvailableBike() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public Integer getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Integer engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getKmTravel() {
        return kmTravel;
    }

    public void setKmTravel(Integer kmTravel) {
        this.kmTravel = kmTravel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Integer getPurchaseCost() {
        return purchaseCost;
    }

    public void setPurchaseCost(Integer purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    public Integer getSellCost() {
        return sellCost;
    }

    public void setSellCost(Integer sellCost) {
        this.sellCost = sellCost;
    }

    public StatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(StatusType statusType) {
        this.statusType = statusType;
    }

    public String get_storeKey() {
        return _storeKey;
    }

    public void set_storeKey(String _storeKey) {
        this._storeKey = _storeKey;
    }

    public Integer get__v() {
        return __v;
    }

    public void set__v(Integer __v) {
        this.__v = __v;
    }

    public List<Owner> getOwner() {
        return owner;
    }

    public void setOwner(List<Owner> owner) {
        this.owner = owner;
    }

    public List<LicenceFile> getLicenceFiles() {
        return licenceFiles;
    }

    public void setLicenceFiles(List<LicenceFile> licenceFiles) {
        this.licenceFiles = licenceFiles;
    }

    public List<PucFile> getPucFiles() {
        return pucFiles;
    }

    public void setPucFiles(List<PucFile> pucFiles) {
        this.pucFiles = pucFiles;
    }

    public List<RcFile> getRcFiles() {
        return rcFiles;
    }

    public void setRcFiles(List<RcFile> rcFiles) {
        this.rcFiles = rcFiles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(_id);
        dest.writeValue(brand);
        dest.writeValue(vehicleModel);
        dest.writeValue(engineCapacity);
        dest.writeValue(year);
        dest.writeValue(kmTravel);
        dest.writeValue(color);
        dest.writeValue(chassisNumber);
        dest.writeValue(engineNumber);
        dest.writeValue(registrationNumber);
        dest.writeValue(purchaseCost);
        dest.writeValue(sellCost);
        dest.writeValue(statusType);
        dest.writeValue(_storeKey);
        dest.writeValue(__v);
        dest.writeList(owner);
        dest.writeList(licenceFiles);
        dest.writeList(pucFiles);
        dest.writeList(rcFiles);
        dest.writeValue(id);
    }

    public int describeContents() {
        return  0;
    }

}
