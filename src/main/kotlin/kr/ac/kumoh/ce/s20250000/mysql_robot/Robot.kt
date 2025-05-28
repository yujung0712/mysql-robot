package kr.ac.kumoh.ce.s20250000.mysql_robot

import jakarta.persistence.*

@Entity
@Table(name = "Mechanic")
data class Robot(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    var name: String,
    var model: String,
    var manufacturer: String,
    @Column(name = "class")
    var robotClass: String,
)

@Entity
data class Weapon(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val name: String,
    val type: String,
    val damage: Int,
    val ability: String,
)

@Entity
data class Equipment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    var mechanicId: Int,
    var weaponId: Int,
    val location: String,
    val quantity: Int
)