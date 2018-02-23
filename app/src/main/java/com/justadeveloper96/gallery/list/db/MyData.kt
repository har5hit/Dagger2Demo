package com.justadeveloper96.gallery.list.db

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey




/**
 * Created by harshith on 28/6/17.
 */
@Entity
public class MyData{

    @PrimaryKey(autoGenerate = true)
    public var id: Int = 0

    public var text1:String = "dummy"

    public var text2:String = "content"

    override fun toString(): String {
        return "MyData(text1='$text1', text2='$text2')"
    }


}