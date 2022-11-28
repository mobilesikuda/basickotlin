package homework11


const val operationAND = " and "
const val operationOR = " or "

fun query(block: SqlSelectContext.() -> Unit ): SqlSelectBuilder {
    val context = SqlSelectContext()
    context.block()
    if (!context.str.contains(" from ")) throw Exception()
    if (context.str.startsWith(" from ")) context.str.insert(0, "select *")
    return SqlSelectBuilder(context.str)
}

//fun query(builder: SqlSelectBuilder ) {
//    str.append(builder.toString())
//}

enum class StateWhere {
    NONE,
    AND,
    OR
}

@DslMarker
annotation class SqlMarker

@SqlMarker
class SqlSelectContext {
    val str = StringBuilder()
    private var stateWhere = StateWhere.NONE

//    fun query(builder: SqlSelectBuilder ) {
//        str.append(builder.toString())
//    }
    fun select(vararg args: String) {
        str.append("select ")
        if (args.isNotEmpty()) {
            str.append(args.first())
            for (i in 1 until args.size) str.append(", ").append(args[i])
        } else str.append(" * ")
    }

    fun from(s: String) {
        str.append(" from $s")
    }

    fun from(builder: SqlSelectBuilder) {
        str.append(" from ")
        str.append(builder.build())
    }

    fun where(s: () -> Unit) {
        str.append(" where ")
        s()
    }

    fun or(s: () -> Unit) {
        stateWhere = StateWhere.OR
        str.append("(")
        s()
        if (str.endsWith(operationOR))
            str.delete(str.length - operationOR.length, str.length)
        str.append(")")
        stateWhere = StateWhere.NONE
    }

    fun and(s: () -> Unit) {
        stateWhere = StateWhere.AND
        str.append("(")
        s()
        if (str.endsWith(operationAND))
            str.delete(str.length - operationAND.length, str.length)
        str.append(")")
        stateWhere = StateWhere.NONE
    }

    infix fun String.nonEq(b: Int) {
        str.append("$this != $b")
        fillStateWhere()
    }

    infix fun String.nonEq(b: String?) {
        if (b == null) str.append("$this !is null")
        else str.append("$this != '$b'")
        fillStateWhere()
    }

    infix fun String.eq(s: Int) {
        str.append("$this = $s")
        fillStateWhere()
    }

    infix fun String.eq(s: String?) {
        if (s == null) str.append("$this is null")
        else str.append("$this = '$s'")
        fillStateWhere()
    }

    fun fillStateWhere() {
        when (stateWhere) {
            StateWhere.AND -> str.append(operationAND)
            StateWhere.OR -> str.append(operationOR)
            else -> str.append("")        }
    }
}

class SqlSelectBuilder(private val builder: StringBuilder) {
    //var str = StringBuilder()
    //var stateWhere = homework11.stateWhere.NONE
    fun build() = builder.toString()
}

