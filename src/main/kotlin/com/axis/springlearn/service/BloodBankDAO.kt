package com.axis.springlearn.service

import com.axis.springlearn.model.BloodBank
import com.axis.springlearn.repository.BloodBankRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*


@Service
class BloodBankDAO {
    @Autowired
    var bloodBankRepository: BloodBankRepository? = null
    fun save(bb: BloodBank): BloodBank {
        return bloodBankRepository!!.save(bb)
    }

    fun delete(bb: BloodBank) {
        bloodBankRepository!!.delete(bb)
    }

    fun deleteByEmail(email: String?): Int {
        return bloodBankRepository!!.deleteByEmail(email)
    }

    fun findAll(): List<BloodBank?> {
        return bloodBankRepository!!.findAll()
    }

    fun findOneByEmail(email: String?): BloodBank? {
        // return null;
        return bloodBankRepository!!.findOneByEmail(email)
    }

    fun findOne(bbid: Long): Optional<BloodBank?> {
        // return null;
        return bloodBankRepository!!.findById(bbid)
    }

    fun login(bb: BloodBank): BloodBank? {
        return bloodBankRepository!!.bloodBankLogin(bb.email, bb.password)
    }

    fun getBloodBankByLocation(location: String?): List<BloodBank?>? {
        println(location)
        return bloodBankRepository!!.getBloodBankByLocation(location)
    }
}