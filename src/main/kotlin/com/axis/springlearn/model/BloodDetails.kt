package com.axis.springlearn.model

import org.springframework.data.jpa.domain.support.AuditingEntityListener
import javax.persistence.*


@Entity
@Table(name = "blood_details")
@EntityListeners(AuditingEntityListener::class)
class BloodDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var blood_id: Long? = null
    var organization_name: String? = null
    var contact_number: String? = null
    var address: String? = null
    var location: String? = null
    var blood_group: String? = null
    var status = false
    var quantity = 0
}