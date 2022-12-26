import java.io.File

const val fileDictionary = "translations.txt"

//val regSplitExp = "(?:^|,)(?=[^\\(]|(\\()?)\\(?((?(1)[^\\)]*|[^,\\))*])\\(?(?=,|\$)".toRegex()
val regSplitExp:String = ","
val dictionaryEN = HashMap<String, List<String>>()
val dictionaryRU = HashMap<String, List<String>>()

fun main() {

    val word = "первобытный"

    val list = translateWord(word)
    println("Word $word: ")
    list.forEach { print("$it, ") }

}

fun translateWord(s: String): List<String> {
    if (dictionaryEN.size == 0) makeDictionaryEN()
    if (dictionaryRU.size == 0) makeDictionaryRU()

    return dictionaryEN[s] ?: dictionaryRU[s] ?: listOf("Word not found!!!")

}

private fun makeDictionaryEN() {

    val buffer = File(fileDictionary).bufferedReader()
    val iterator = buffer.lines().iterator()

    while (iterator.hasNext()) {
        val fullString = iterator.next()
        val pair = fullString.split("-")
        val word = pair[0].trim()
        pair[1].trim().split(regSplitExp).also { dictionaryEN.put(word, it) }
    }
}

private fun makeDictionaryRU() {
    val dictionary = HashMap<String, MutableList<String>>()

    val buffer = File(fileDictionary).bufferedReader()
    val iterator = buffer.lines().iterator()

    while (iterator.hasNext()) {
        val fullString = iterator.next()
        val pair = fullString.split("-")
        val word = pair[0].trim()
        pair[1].split(regSplitExp).forEach {
            dictionary[it]?.also { _ ->
                dictionary[it.trim()]?.add(word)
            } ?: dictionary.put(it.trim(), mutableListOf(word))
        }
    }

    dictionary.forEach { dictionaryRU[it.key] = it.value }
}


