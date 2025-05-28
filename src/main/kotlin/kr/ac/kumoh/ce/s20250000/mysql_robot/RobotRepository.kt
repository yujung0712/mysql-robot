package kr.ac.kumoh.ce.s20250000.mysql_robot

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface RobotRepository : JpaRepository<Robot, Int> {
    @Query("""
        SELECT new kr.ac.kumoh.ce.s20250000.mysql_robot.EquipmentDto(
            r.name as robotName,
            r.model,
            r.robotClass,
            e.location,
            e.quantity,
            w.name as weaponName,
            w.type as weaponType,
            w.damage,
            w.ability
        )
        FROM Robot r
        LEFT JOIN Equipment e ON r.id = e.mechanicId
        LEFT JOIN Weapon w ON e.weaponId = w.id
        ORDER BY r.name DESC, e.location
    """)
    fun findAllEquipment(): List<EquipmentDto>
}