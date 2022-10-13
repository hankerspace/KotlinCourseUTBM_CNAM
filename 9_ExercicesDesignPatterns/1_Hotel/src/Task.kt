import java.util.*

enum class RoomType(val price: Double) {
    ECO(100.0), CONFORT(200.0), CONFORT_PLUS(300.0)
}
data class Room(val number: Int, val type: RoomType, val maxPersons: Int)

data class Record(val roomType: RoomType, val nights: Int, val persons: Int) {
    val reservationNumber: Int = Random().nextInt(100000)
    val price = roomType.price * nights

    override fun toString(): String {
        return "$persons personne(s) pour $nights nuits en $roomType à $price euros (reservation $reservationNumber)"
    }
}

data class Assignment(val room: Room, val record: Record) {
    fun isOverClassed(): Boolean {
        return room.type.price > record.price
    }

    override fun toString(): String {
        return "Chambre ${room.number} : $record"
    }
}

fun main() {
    val rooms = listOf(
        Room(1, RoomType.ECO, 2),
        Room(2, RoomType.ECO, 2),
        Room(3, RoomType.ECO, 2),
        Room(4, RoomType.CONFORT, 2),
        Room(5, RoomType.CONFORT, 2),
        Room(6, RoomType.CONFORT, 2),
        Room(7, RoomType.CONFORT_PLUS, 2),
        Room(8, RoomType.CONFORT_PLUS, 2),
        Room(9, RoomType.CONFORT_PLUS, 2)
    )
    val records = listOf(
        Record(RoomType.ECO, 2, 1),
        Record(RoomType.CONFORT, 2, 1),
        Record(RoomType.CONFORT_PLUS, 2, 1),
        Record(RoomType.ECO, 2, 2),
        Record(RoomType.CONFORT, 2, 2),
        Record(RoomType.CONFORT_PLUS, 2, 2),
        Record(RoomType.ECO, 2, 3),
        Record(RoomType.CONFORT, 2, 3),
        Record(RoomType.CONFORT_PLUS, 2, 3)
    )
    val assignments = rooms.zip(records).map { Assignment(it.first, it.second) }
    println("Chambres assignées : ")
    assignments.filter { !it.isOverClassed() }.forEach { println(it) }
    println("Chambres assignées en surclassé : ")
    assignments.filter { it.isOverClassed() }.forEach { println(it) }
}