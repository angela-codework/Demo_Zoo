package com.test.zoo.database

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query

/**
 * Get query result.
 */
@Dao
interface ZooDao {
    //get zoo section list by indoor/outdoor
    @Query("SELECT * FROM zoo_info WHERE E_Category is :category")
    fun getInfoByCategory(category: String): DataSource.Factory<Int, ZooInfo>

    //get plant list by zoo section
    @Query("SELECT * FROM plant_info WHERE F_Location LIKE '%' || :loc || '%'")
    fun getPlantByLoc(loc: String): DataSource.Factory<Int, PlantTuple>

}