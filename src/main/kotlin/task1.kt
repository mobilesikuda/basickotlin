import java.io.File

var listFiles = HashMap<String, List<String>>()

fun checkPermission(key: String, operation: String): Boolean {

    if (listFiles.size == 0 ) listFiles = fillHashFiles("files.txt")

    return listFiles[key]?.contains(operation) ?: false

}

fun fillHashFiles(filename: String): HashMap<String, List<String>> {
    val file = File(filename)
    val listFiles = HashMap<String, List<String>>()

    if (!file.canRead()) return listFiles
    file.readLines()
        .forEach {
            val pairFile = it.split("-")

            val modificator =
                if (pairFile.size > 1) pairFile[1].trim().split(",")
                else listOf<String>()

            listFiles.put( pairFile[0].trim(), modificator)
        }

    return listFiles
}

fun main() {

    val listFiles = fillHashFiles("files.txt")

    //check one operation on list
    val checkOperation = "DELETE"

    listFiles.forEach { it ->
        val permit = checkPermission(it.key, checkOperation)
        println("${it.key} $checkOperation -> $permit")

    }
}




