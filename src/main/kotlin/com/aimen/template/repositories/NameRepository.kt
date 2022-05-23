package com.aimen.template.repositories

import com.aimen.template.entities.Names
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface NameRepository : JpaRepository<Names, UUID> {

}