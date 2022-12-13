import java.io.File

fun makeHaspMap(filename: String): HashMap<String, String> {
    val list = HashMap<String, String>()

    val buffer = File(filename).bufferedReader()
    val iterator = buffer.lines().iterator()

    while (iterator.hasNext()) {
        val fullString = iterator.next()
        val pair = fullString.split("-")

        list.put(pair[0].trim(), pair[1].trim())

        if (pair.size > 1) {
            pair[1].split(",").forEach {
                list.put(it.trim(), pair[0].trim())
            }
        }
    }
    return list
}


fun main() {

    val list = makeHaspMap("translations.txt")

    println("size=${list.size}")

    list.filter { it.key == "первобытный" }
        .forEach { println(it.value) }

}

