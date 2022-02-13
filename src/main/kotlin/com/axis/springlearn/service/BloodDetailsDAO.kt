package com.axis.springlearn.service

import com.axis.springlearn.model.BloodDetails
import com.axis.springlearn.repository.BloodDetailsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*


@Service
class BloodDetailsDAO {
    @Autowired
    var bloodDetailsRepository: BloodDetailsRepository? = null
    fun save(bd: BloodDetails): BloodDetails {
        return bloodDetailsRepository!!.save(bd)
    }

    fun delete(bd: BloodDetails) {
        bloodDetailsRepository!!.delete(bd)
    }

    fun findAll(): List<BloodDetails?> {
        return bloodDetailsRepository!!.findAll()
    }

    fun findOne(bdid: Long): Optional<BloodDetails?> {
        // return null;
        return bloodDetailsRepository!!.findById(bdid)
    }

    fun getBloodBankByLocation(location: String?): List<BloodDetails?>? {
        return bloodDetailsRepository!!.getBloodBankByLocation(location)
    }
}
