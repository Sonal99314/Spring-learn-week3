package com.axis.springlearn.service

import com.axis.springlearn.model.Donor
import com.axis.springlearn.repository.DonorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*


@Service
class DonorDAO (@Autowired var donorRepository: DonorRepository){

    fun save(donor: Donor): Donor {
        return donorRepository.save(donor)
    }

    fun delete(donor: Donor) {
        donorRepository.delete(donor)
    }

    fun findOneByEmail(email: String?): Donor? {
        // return null;
        return donorRepository.findOneByEmail(email)
    }

    fun findAll(): List<Donor?> {
        return donorRepository.findAll()
    }

    fun findOne(did: Long): Optional<Donor?> {
        // return null;
        return donorRepository.findById(did)
    }

    fun login(donor: Donor): Donor? {
        return donorRepository!!.donorLogin(donor.email,donor.password)
    }

    fun getDonorByLocation(location: String?): List<Donor?>? {
        return donorRepository!!.getDonorByLocation(location)
    }
}