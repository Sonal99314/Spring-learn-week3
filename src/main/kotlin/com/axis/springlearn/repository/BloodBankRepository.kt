package com.axis.springlearn.repository

import com.axis.springlearn.model.BloodBank
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.transaction.annotation.Transactional


interface BloodBankRepository : JpaRepository<BloodBank?, Long?> {
    @Query(value = "SELECT * FROM blood_bank WHERE email = :email and password= :password", nativeQuery = true)
    fun bloodBankLogin(email: String?, password: String?): BloodBank?

    @Query(value = "SELECT * FROM blood_bank WHERE location = :location", nativeQuery = true)
    fun getBloodBankByLocation(location: String?): List<BloodBank?>?

    @Modifying
    @Transactional
    @Query(value = "DELETE  FROM blood_bank WHERE email = :email", nativeQuery = true)
    fun deleteByEmail(email: String?): Int

    @Query(value = "SELECT *  FROM blood_bank WHERE email = :email", nativeQuery = true)
    fun findOneByEmail(email: String?): BloodBank?
}