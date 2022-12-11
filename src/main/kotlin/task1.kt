import java.io.File

fun checkPermission(item: Pair<String, List<Modificator>>): List<Pair<Modificator, Boolean>> {
    val file = File(item.first)
    val result = mutableListOf<Pair<Modificator, Boolean>>()
    item.second.forEach() {
        when (it) {
            Modificator.READ ->
                if(file.canRead()) result.add(Modificator.READ to true)
                else result.add(Modificator.READ to false)
            Modificator.WRITE ->
                if(file.canWrite()) result.add(Modificator.WRITE to true)
            else result.add(Modificator.WRITE to false)
            Modificator.EXECUTE ->
                if(file.canExecute()) result.add(Modificator.EXECUTE to true)
                else result.add(Modificator.EXECUTE to false)
        }
    }
    return result.toList()
}

enum class Modificator {
    READ,
    WRITE,
    EXECUTE
}

fun main() {

    val list = listOf(
        "test1.txt" to listOf(Modificator.READ),
        "test2.txt" to listOf(Modificator.READ, Modificator.WRITE),
        "test3.txt" to listOf(Modificator.EXECUTE),
    )

    list.forEach { it ->
        val permission = checkPermission(it)
        println(it.first)
        permission.forEach { elem ->
            println("${elem.first} -> ${elem.second}")
        }
    }
}

