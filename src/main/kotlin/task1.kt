import java.io.File

fun checkPermission(item: Pair<String, List<String>>, operation: String): Boolean {

    return item.second.contains(operation)

}

fun fillListFiles(filename: String): List<Pair<String, List<String>>> {
    val file = File(filename)
    val listFiles: MutableList<Pair<String, List<String>>> = mutableListOf()

    if (!file.canRead()) return listOf()
    file.readLines()
        .forEach {
            val pairFile = it.split("-")

            val modificator =
                if (pairFile.size > 1) pairFile[1].trim().split(",")
                else listOf<String>()

            listFiles.add(Pair(pairFile[0].trim(), modificator))
        }

    return listFiles.toList()
}

fun main() {

    val listFiles = fillListFiles("files.txt")

    //check one operation on list
    val checkOperation = "DELETE"

    listFiles.forEach { it ->
        val permit = checkPermission(it, checkOperation)
        println("${it.first} $checkOperation -> $permit")

    }
}

