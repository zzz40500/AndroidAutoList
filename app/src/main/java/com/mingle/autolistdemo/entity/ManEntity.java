package com.mingle.autolistdemo.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.mingle.autolist.AutoData;


/**
 * @author zwm
 * @version 2.0
 * @ClassName TestData
 * @Description TODO(这里用一句话描述这个类的作用)
 * @date 2015/8/27.
 */
public class ManEntity extends AutoData implements Parcelable {

    /**
     * name : 王五
     * age : 15
     * height : 140cm
     */

    public int id;
    public String name;
    public int age;
    public String height;
    public ManEntity() {
    }


    @Override
    public String getIdentifies() {
        return id+"";
    }

    //--------------Parcelable----------//
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeInt(this.age);
        dest.writeString(this.height);
    }



    protected ManEntity(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.age = in.readInt();
        this.height = in.readString();
    }

    public static final Creator<ManEntity> CREATOR = new Creator<ManEntity>() {
        public ManEntity createFromParcel(Parcel source) {
            return new ManEntity(source);
        }

        public ManEntity[] newArray(int size) {
            return new ManEntity[size];
        }
    };
}
