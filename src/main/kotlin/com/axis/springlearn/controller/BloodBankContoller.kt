package com.axis.springlearn.controller

import com.axis.springlearn.model.Donor
import com.axis.springlearn.service.DonorDAO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*



@RestController
@RequestMapping("/")
class DonorController {
    @Autowired
    var donorDAO: DonorDAO? = null

    /* to save a blood bank */
    @PostMapping("/donor")
    fun createDonor( @RequestBody donor: Donor?): Donor {
        return donorDAO!!.save(donor!!)
    }

    /* get all blood banks */
    @get:GetMapping("/donor")
    val allDonors: List<Donor?>
        get() {
            println("getAll")
            return donorDAO!!.findAll()
        }

    /* Delete a product */
    @DeleteMapping("/donor/{id}")
    fun deleteDonor(@PathVariable(value = "id") dId: Long?): ResponseEntity<Donor> {
        val donor = donorDAO!!.findOne(dId!!) ?: return ResponseEntity.notFound().build()
        donorDAO!!.delete(donor.get())
        return ResponseEntity.ok().build()
    }

    @PostMapping("/donor/login")
    fun login( @RequestBody donor: Donor?): Donor? {
        return donorDAO!!.login(donor!!)
    }

    @PutMapping("/donor/")
    fun updateDonor( @RequestBody donor: Donor): ResponseEntity<Donor> {
        val donorOld = donorDAO!!.findOneByEmail(donor.email) ?: return ResponseEntity.notFound().build()
        donor.donor_id = donorOld.donor_id
        donorDAO!!.save(donor)
        return ResponseEntity.ok().build()
    }
}