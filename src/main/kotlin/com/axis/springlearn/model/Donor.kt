package com.axis.springlearn.model

import org.springframework.data.jpa.domain.support.AuditingEntityListener
import javax.persistence.*


@Entity
@Table(name = "donor")
@EntityListeners(AuditingEntityListener::class)
data class Donor (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var donor_id: Long,
    var name: String,
    var email: String,
    var contact_number: String,
    var location: String,
    var password: String,
    var blood_group: String,
    var gender: String,
    var age: Int = 0
)