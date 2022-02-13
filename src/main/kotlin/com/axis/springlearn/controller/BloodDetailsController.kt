package com.axis.springlearn.controller
import com.axis.springlearn.model.BloodDetails
import com.axis.springlearn.service.BloodDetailsDAO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/")
class BloodDetailsController {
    @Autowired
    var bloodDetailsDAO: BloodDetailsDAO? = null

    /* to save a blood bank */
    @PostMapping("/blood-details")
    fun createBloodDetails(@RequestBody bd: BloodDetails?): BloodDetails {
        return bloodDetailsDAO!!.save(bd!!)
    }

    @GetMapping("/blood-details/{location}")
    fun getBloodBankByLocation(@PathVariable(value = "location") location: String?): List<BloodDetails?>? {
        return bloodDetailsDAO!!.getBloodBankByLocation(location)
    }

    /* get all blood banks */
    @get:GetMapping("/blood-details")
    val allBloodDetails: List<BloodDetails?>
        get() {
            println("getAll")
            return bloodDetailsDAO!!.findAll()
        }

    /* Delete a product */
    @DeleteMapping("/blood-details/{id}")
    fun deleteBloodDetails(@PathVariable(value = "id") bdId: Long?): ResponseEntity<BloodDetails> {
        val bd = bloodDetailsDAO!!.findOne(bdId!!)
            ?: return ResponseEntity.notFound().build()
        bloodDetailsDAO!!.delete(bd.get())
        return ResponseEntity.ok().build()
    }

    @PutMapping("/blood-details/")
    fun updateBloodDetails( @RequestBody bd: BloodDetails): ResponseEntity<BloodDetails> {
        val bdOld = bloodDetailsDAO!!.findOne(bd.blood_id!!)
            ?: return ResponseEntity.notFound().build()
        bd.blood_id = bdOld.get().blood_id
        bloodDetailsDAO!!.save(bd)
        return ResponseEntity.ok().build()
    }
}