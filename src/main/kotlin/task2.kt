import java.io.File

val dictionaryEN = HashMap<String, String>()
val dictionaryRU = HashMap<String, String>()

fun makeHaspMap(filename: String): HashMap<String, String> {
    val dictionary = HashMap<String, String>()

    val buffer = File(filename).bufferedReader()
    val iterator = buffer.lines().iterator()

    while (iterator.hasNext()) {
        val fullString = iterator.next()
        val pair = fullString.split("-")

        dictionary.put(pair[0].trim(), pair[1].trim())

        if (pair.size > 1) {
            pair[1].split(",").forEach {
                dictionary.put(it.trim(), pair[0].trim())
            }
        }
    }
    return dictionary
}


fun main() {

    val dictionary = makeHaspMap("translations.txt")

    println("size=${dictionary.size}")

    dictionary.filter { it.key == "первобытный" }
        .forEach { println(it.value) }

}

