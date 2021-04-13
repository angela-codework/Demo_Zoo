package com.test.zoo.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * db table entity of plant_info.
 */
@Entity(tableName = "plant_info")
data class Plant(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "F_Name_Ch") val name: String?,
    @ColumnInfo(name = "F_Summary") val summary: String?,
    @ColumnInfo(name = "F_Keywords") val keywords: String?,
    @ColumnInfo(name = "F_AlsoKnown") val alsoKnown: String?,
    @ColumnInfo(name = "F_Geo") val geo: String?,
    @ColumnInfo(name = "F_Location") val location: String?,
    @ColumnInfo(name = "F_Name_En") val nameEn: String?,
    @ColumnInfo(name = "F_Name_Latin") val nameLat: String?,
    @ColumnInfo(name = "F_Family") val family: String?,
    @ColumnInfo(name = "F_Genus") val genus: String?,
    @ColumnInfo(name = "F_Brief") val brief: String?,
    @ColumnInfo(name = "F_Feature") val feature: String?,
    @ColumnInfo(name = "F_Function&Application") val app: String?,
    @ColumnInfo(name = "F_Code") val code: String?,
    @ColumnInfo(name = "F_Pic01_ALT") val pic1Alt: String?,
    @ColumnInfo(name = "F_Pic01_URL") val pic1Url: String?,
    @ColumnInfo(name = "F_Pic02_ALT") val pic2Alt: String?,
    @ColumnInfo(name = "F_Pic02_URL") val pic2Url: String?,
    @ColumnInfo(name = "F_Pic03_ALT") val pic3Alt: String?,
    @ColumnInfo(name = "F_Pic03_URL") val pic3Url: String?,
    @ColumnInfo(name = "F_Pic04_ALT") val pic4Alt: String?,
    @ColumnInfo(name = "F_Pic04_URL") val pic4Url: String?,
    @ColumnInfo(name = "F_pdf01_ALT") val pdf1Alt: String?,
    @ColumnInfo(name = "F_pdf01_URL") val pdf1Url: String?,
    @ColumnInfo(name = "F_pdf02_ALT") val pdf2Alt: String?,
    @ColumnInfo(name = "F_pdf02_URL") val pdf2Url: String?,
    @ColumnInfo(name = "F_Voice01_ALT") val voice1Alt: String?,
    @ColumnInfo(name = "F_Voice01_URL") val voice1Url: String?,
    @ColumnInfo(name = "F_Voice02_ALT") val voice2Alt: String?,
    @ColumnInfo(name = "F_Voice02_URL") val voice2Url: String?,
    @ColumnInfo(name = "F_Voice03_ALT") val voice3Alt: String?,
    @ColumnInfo(name = "F_Voice03_URL") val voice3Url: String?,
    @ColumnInfo(name = "F_Vedio_URL") val videoUrl: String?,
    @ColumnInfo(name = "F_Update") val update: String?,
    @ColumnInfo(name = "F_CID") val cid: String?
)