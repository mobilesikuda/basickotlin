abstract class Man(surname: String, name: String)


class Employee(surname: String, name: String, position: String = "") : Man(surname, name) {

    val pastPosition = mutableSetOf<PastPosition>()
    var department = Department("")
    val room = mutableSetOf<Room>()
    var idCard = IdCard()

    fun deletePastPosition(elem: PastPosition) {
        pastPosition.remove(elem)
    }

    fun deleteRoom(elem: Room) {
        room.remove(elem)
    }

}