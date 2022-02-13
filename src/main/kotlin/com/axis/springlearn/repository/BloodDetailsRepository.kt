package com.axis.springlearn.repository

import com.axis.springlearn.model.BloodDetails
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query


interface BloodDetailsRepository : JpaRepository<BloodDetails?, Long?> {
    @Query(value = "SELECT * FROM blood_details WHERE location = :location", nativeQuery = true)
    fun getBloodBankByLocation(location: String?): List<BloodDetails?>?
}