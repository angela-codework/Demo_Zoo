package com.test.zoo.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * db table entity of zoo_info.
 */
@Entity(tableName = "zoo_info")
@Parcelize
data class ZooInfo (
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "E_no") val no: String?,
    @ColumnInfo(name = "E_Category") val category: String?,
    @ColumnInfo(name = "E_Name") val name: String?,
    @ColumnInfo(name = "E_Pic_URL") val pic: String?,
    @ColumnInfo(name = "E_Info") val info: String?,
    @ColumnInfo(name = "E_Memo") val memo: String?,
    @ColumnInfo(name = "E_Geo") val geo: String?,
    @ColumnInfo(name = "E_URL") val url: String?
): Parcelable