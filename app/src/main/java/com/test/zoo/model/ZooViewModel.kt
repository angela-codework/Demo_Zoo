package com.test.zoo.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.paging.toLiveData
import com.test.zoo.database.ZooDatabase

/**
 * An AndroidViewModel with extra string param
 */
class ZooViewModel(app: Application, value: String): AndroidViewModel(app) {
    private val dao = ZooDatabase.getInstance(app).zooDao()
    //save result zoo section list to live data
    val zooInfoList = dao.getInfoByCategory(value).toLiveData(pageSize = 5)
    //save result plant list to live data
    val plantList = dao.getPlantByLoc(value).toLiveData(pageSize = 3)

}