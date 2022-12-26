import java.io.File

val hashMapFiles = HashMap<String, List<String>>()

fun checkPermission(key: String, operation: String): Boolean {

    if (hashMapFiles.size == 0 )  fillHashFiles("files.txt")

    return hashMapFiles[key]?.contains(operation) ?: false

}

fun fillHashFiles(filename: String): Boolean {
    val file = File(filename)

    if (!file.canRead()) return false
    file.readLines()
        .forEach {
            val pairFile = it.split("-")

            val listMod =
                if (pairFile.size > 1) pairFile[1].trim().split(",")
                else emptyList()

            hashMapFiles[pairFile[0].trim()] = listMod
        }

    return true
}

fun main() {

    fillHashFiles("files.txt")

    //check one operation on list
    val checkOperation = "DELETE"

    hashMapFiles.forEach { it ->
        val permit = checkPermission(it.key, checkOperation)
        println("${it.key} $checkOperation -> $permit")

    }
}




