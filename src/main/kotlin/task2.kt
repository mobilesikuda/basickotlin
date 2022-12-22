import java.io.File

const val fileDictionary = "translations.txt"

//val regSplitExp = "(?:^|,)(?=[^\\(]|(\\()?)\\(?((?(1)[^\\)]*|[^,\\))*])\\(?(?=,|\$)".toRegex()
val regSplitExp = ","
var dictionaryEN = HashMap<String, List<String>>()
var dictionaryRU = HashMap<String, List<String>>()

fun main() {

    val word = "первобытный"

    val list = translateWord(word)
    println("Word $word: ")
    list.forEach { print("$it, ") }

}

fun translateWord(s: String): List<String> {
    if (dictionaryEN.size == 0) dictionaryEN = makeDictionaryEN()
    if (dictionaryRU.size == 0) dictionaryRU = makeDictionaryRU()
    //var list = listOf<String>()

    dictionaryEN[s].also {
        if (it != null) {
            return it.toList()
        }
    }
    dictionaryRU[s].also {
        if (it != null) {
            return it.toList()
        }
    }

    return listOf("Word not found!!!")
}

private fun makeDictionaryEN(): HashMap<String, List<String>> {
    val dictionary = HashMap<String, List<String>>()

    val buffer = File(fileDictionary).bufferedReader()
    val iterator = buffer.lines().iterator()

    while (iterator.hasNext()) {
        val fullString = iterator.next()
        val pair = fullString.split("-")
        val word = pair[0].trim()
        pair[1].trim().split(regSplitExp).also { dictionary.put(word, it) }
    }
    return dictionary
}

private fun makeDictionaryRU(): HashMap<String, List<String>> {
    val dictionary = HashMap<String, MutableList<String>>()
    val dictionaryOut = HashMap<String, List<String>>()

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

    dictionary.forEach { dictionaryOut.put(it.key, it.value) }
    return dictionaryOut
}
//private fun String.onlyLetters() = all { it.isLetter() }

