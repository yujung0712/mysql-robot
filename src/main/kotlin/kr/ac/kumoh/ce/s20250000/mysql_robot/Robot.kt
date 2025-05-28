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