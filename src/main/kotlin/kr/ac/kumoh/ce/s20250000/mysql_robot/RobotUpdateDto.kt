package kr.ac.kumoh.ce.s20250000.mysql_robot

data class RobotUpdateDto(
    val name: String?,
    val model: String?,
    val manufacturer: String?,
    val robotClass: String?
)