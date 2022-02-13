package com.axis.springlearn.controller
// https://medium.com/thecodefountain/design-a-rest-api-with-spring-boot-and-mysql-a5572d94ccc7
import com.axis.springlearn.model.BloodBank
import com.axis.springlearn.service.BloodBankDAO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*



@RestController
@RequestMapping("/")
class BloodBankController {
    @Autowired
    var bloodBankDAO: BloodBankDAO? = null

    /* to save a blood bank */
    @PostMapping("/blood-bank")
    fun createBloodBank( @RequestBody bb: BloodBank?): BloodBank {
        return bloodBankDAO!!.save(bb!!)
    }

    /* get all blood banks */
    @get:GetMapping("/blood-bank")
    val allBloodBanks: List<BloodBank?>
        get() {
            println("getAll")
            return bloodBankDAO!!.findAll()
        }

    /* Delete a product */
    @DeleteMapping("/blood-bank/{email}")
    fun deleteBloodBank(@PathVariable(value = "email") email: String?): ResponseEntity<BloodBank> {
        bloodBankDAO!!.deleteByEmail(email)
        return ResponseEntity.ok().build()
    }

    @PostMapping("/blood-bank/login")
    fun login( @RequestBody bb: BloodBank?): BloodBank? {
        return bloodBankDAO!!.login(bb!!)
    }

    @GetMapping("/blood-bank/{location}")
    fun getBloodBankByLocation(@PathVariable(value = "location") location: String?): List<BloodBank?>? {
        return bloodBankDAO!!.getBloodBankByLocation(location)
    }

    @PutMapping("/blood-bank/")
    fun updateBloodBank( @RequestBody bb: BloodBank): ResponseEntity<BloodBank> {
        val bbOld = bloodBankDAO!!.findOneByEmail(bb.email) ?: return ResponseEntity.notFound().build()
        bb.blood_bank_id = bbOld.blood_bank_id
        bb.password = bbOld.password
        bloodBankDAO!!.save(bb)
        return ResponseEntity.ok().build()
    }
}
