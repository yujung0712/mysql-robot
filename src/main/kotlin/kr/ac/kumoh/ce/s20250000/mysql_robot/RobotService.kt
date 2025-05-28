package kr.ac.kumoh.ce.s20250000.mysql_robot

import org.springframework.stereotype.Service

@Service
class RobotService(val repository: RobotRepository) {
//    fun getAllRobots(): List<Robot> {
//        return repository.findAll()
//    }

    fun getAllRobots(): List<Robot> = repository.findAll()

    fun getRobotWithWeapons(): List<EquipmentDto> {
        return repository.findAllEquipment()
    }

    // Robot select (ID 사용)
    fun getRobotById(id: Int): Robot? = repository.findById(id).orElse(null)

    // Robot insert (C)
    fun createRobot(robot: Robot): Robot {
        robot.id = 0 // ID는 자동생성되므로 0으로 설정
        return repository.save(robot)
    }

    // Robot update (U)
    fun updateRobot(id: Int, robotUpdateDto: RobotUpdateDto): Robot? {
        val existingRobot = repository.findById(id).orElse(null) ?: return null

        robotUpdateDto.name?.let { existingRobot.name = it }
        robotUpdateDto.model?.let { existingRobot.model = it }
        robotUpdateDto.manufacturer?.let { existingRobot.manufacturer = it }
        robotUpdateDto.robotClass?.let { existingRobot.robotClass = it }

        return repository.save(existingRobot)
    }

    // Robot delete (D)
    fun deleteRobot(id: Int): Boolean =
        repository.existsById(id).also {
            if (it) repository.deleteById(id)
        }

//    fun deleteRobot(id: Int): Boolean {
//        return if (repository.existsById(id)) {
//            repository.deleteById(id)
//            true
//        } else {
//            false
//        }
//    }

}