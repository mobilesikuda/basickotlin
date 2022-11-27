package homework11


const val operationAND = " and "
const val operationOR = " or "

fun query(s: () -> Unit): SqlSelectBuilder {
    SqlSelectBuilder.str.clear()
    s()
    if (!SqlSelectBuilder.str.contains(" from ")) throw Exception()
    if (SqlSelectBuilder.str.startsWith(" from ")) SqlSelectBuilder.str.insert(0, "select *")
    return SqlSelectBuilder
}

fun select(vararg args: String) {
    SqlSelectBuilder.str.append("select ")
    if (args.isNotEmpty()) {
        SqlSelectBuilder.str.append(args.first())
        for (i in 1 until args.size) SqlSelectBuilder.str.append(", ").append(args[i])
    } else SqlSelectBuilder.str.append(" * ")
}

fun from(s: String) {
    SqlSelectBuilder.str.append(" from $s")
}

fun where(s: () -> Unit) {
    SqlSelectBuilder.str.append(" where ")
    s()
}

fun or(s: () -> Unit){
    SqlSelectBuilder.stateWhere = stateWhere.OR
    SqlSelectBuilder.str.append("(")
    s()
    if (SqlSelectBuilder.str.endsWith(operationOR))
        SqlSelectBuilder.str.delete(SqlSelectBuilder.str.length - operationOR.length, SqlSelectBuilder.str.length)
    SqlSelectBuilder.str.append(")")
    SqlSelectBuilder.stateWhere = stateWhere.NONE
}

fun and(s: () -> Unit) {
    SqlSelectBuilder.stateWhere = stateWhere.AND
    SqlSelectBuilder.str.append("(")
    s()
    if (SqlSelectBuilder.str.endsWith(operationAND))
        SqlSelectBuilder.str.delete(SqlSelectBuilder.str.length - operationAND.length, SqlSelectBuilder.str.length)
    SqlSelectBuilder.str.append(")")
    SqlSelectBuilder.stateWhere = stateWhere.NONE
}

infix fun String.nonEq(b: Int) {
    SqlSelectBuilder.str.append("$this != $b")
    fillStateWhere()
}

infix fun String.nonEq(b: String?) {
    if (b == null) SqlSelectBuilder.str.append("$this !is null")
    else SqlSelectBuilder.str.append("$this != '$b'")
    fillStateWhere()
}

infix fun String.eq(s: Int) {
    SqlSelectBuilder.str.append("$this = $s")
    fillStateWhere()
}

infix fun String.eq(s: String?) {
    if (s == null) SqlSelectBuilder.str.append("$this is null")
    else SqlSelectBuilder.str.append("$this = '$s'")
    fillStateWhere()
}

fun fillStateWhere() {
    when (SqlSelectBuilder.stateWhere) {
        stateWhere.AND -> SqlSelectBuilder.str.append(operationAND)
        stateWhere.OR -> SqlSelectBuilder.str.append(operationOR)
        else -> null
    }
}

object SqlSelectBuilder {
    var str = StringBuilder()
    var stateWhere = homework11.stateWhere.NONE
    fun build() = str.toString()
}

enum class stateWhere {
    NONE,
    AND,
    OR
}