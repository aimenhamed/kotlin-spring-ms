package com.aimen.template.entities

import org.hibernate.annotations.Type
import java.util.*
import javax.persistence.*

@Entity
class Names (
    @Id
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
    var id: UUID? = null,

    @Column
    var name: String
)