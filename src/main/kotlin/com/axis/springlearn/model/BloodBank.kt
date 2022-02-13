package com.axis.springlearn.model

import javax.persistence.*


@Entity
@Table(name = "blood_bank")
class BloodBank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var blood_bank_id: Long? = null
    var name: String? = null
    var email: String? = null
    var password: String? = null
    var contact_number: String? = null
    var role: String? = null
    var address: String? = null
    var location: String? = null
}