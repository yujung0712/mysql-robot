package kr.ac.kumoh.ce.s20250000.mysql_robot

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/robots")
class RobotController(val service: RobotService) {
//    @GetMapping("/")
//    fun welcome(): String {
//        return "Welcome to Robot Server"
//    }

    @GetMapping
    fun getAllRobots(): ResponseEntity<List<Robot>> {
        val robots = service.getAllRobots()
        return ResponseEntity.ok(robots)
    }

    @GetMapping("/with-weapons")
    fun getRobotsWithWeapons(): ResponseEntity<List<EquipmentDto>> {
        return ResponseEntity.ok(service.getRobotWithWeapons())
    }

    // Robot select (ID 사용)
    @GetMapping("/{id}")
    fun getRobotById(@PathVariable id: Int): ResponseEntity<Robot> {
        val robot = service.getRobotById(id)
        return if (robot != null) {
            // 200 OK
            ResponseEntity.ok(robot)
        } else {
            // 404 Not Found
            ResponseEntity.notFound().build()
        }
    }

    // Robot insert (C)
    @PostMapping
    fun createRobot(@RequestBody robot: Robot): ResponseEntity<Robot> {
        val createdRobot = service.createRobot(robot)
        // 201 Created
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRobot)
    }

    // Robot update (U)
    @PutMapping("/{id}")
    fun updateRobot(
        @PathVariable id: Int,
        @RequestBody robotUpdateDto: RobotUpdateDto
    ): ResponseEntity<Robot> {
        val updatedRobot = service.updateRobot(id, robotUpdateDto)
        return if (updatedRobot != null) {
            ResponseEntity.ok(updatedRobot)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    // Robot delete (D)
    @DeleteMapping("/{id}")
    fun deleteRobot(@PathVariable id: Int): ResponseEntity<Void> {
        val deleted = service.deleteRobot(id)
        return if (deleted) {
            // 204 No Content (정상 삭제)
            ResponseEntity.noContent().build()
        } else {
            // 404 Not Found (매칭되는 ID 없음)
            ResponseEntity.notFound().build()
        }
    }
}