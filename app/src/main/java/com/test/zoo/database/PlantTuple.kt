package com.test.zoo.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * table "plant_info" projection column.
 */
@Parcelize
data class PlantTuple (
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "F_Name_Ch") val name: String?,
    @ColumnInfo(name = "F_AlsoKnown") val alsoKnown: String?,
    @ColumnInfo(name = "F_Location") val location: String?,
    @ColumnInfo(name = "F_Name_En") val nameEn: String?,
    @ColumnInfo(name = "F_Name_Latin") val nameLat: String?,
    @ColumnInfo(name = "F_Family") val family: String?,
    @ColumnInfo(name = "F_Genus") val genus: String?,
    @ColumnInfo(name = "F_Brief") val brief: String?,
    @ColumnInfo(name = "F_Feature") val feature: String?,
    @ColumnInfo(name = "F_Function&Application") val app: String?,
    @ColumnInfo(name = "F_Pic01_ALT") val pic1Alt: String?,
    @ColumnInfo(name = "F_Pic01_URL") val pic1Url: String?,
    @ColumnInfo(name = "F_Pic02_ALT") val pic2Alt: String?,
    @ColumnInfo(name = "F_Pic02_URL") val pic2Url: String?,
    @ColumnInfo(name = "F_Pic03_ALT") val pic3Alt: String?,
    @ColumnInfo(name = "F_Pic03_URL") val pic3Url: String?,
    @ColumnInfo(name = "F_Pic04_ALT") val pic4Alt: String?,
    @ColumnInfo(name = "F_Pic04_URL") val pic4Url: String?,
    @ColumnInfo(name = "F_Update") val update: String?

): Parcelable