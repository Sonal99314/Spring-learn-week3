package com.axis.springlearn.repository

import com.axis.springlearn.model.Donor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query


interface DonorRepository : JpaRepository<Donor?, Long?> {
    @Query(value = "SELECT * FROM donor WHERE email = :email and password= :password", nativeQuery = true)
    fun donorLogin(email: String?, password: String?): Donor?

    @Query(value = "SELECT * FROM donor WHERE location = :location", nativeQuery = true)
    fun getDonorByLocation(location: String?): List<Donor?>?

    @Query(value = "SELECT *  FROM donor WHERE email = :email", nativeQuery = true)
    fun findOneByEmail(email: String?): Donor?
}