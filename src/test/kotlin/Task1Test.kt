import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Task1Test {

    @Test
    fun test() {
        assertEquals(checkPermission("бюджетный_солдат", "DELETE"), false, "Первый элемент не имеет модификатора DELETE")
        assertEquals(checkPermission("скромный_сигарета.tif", "SHARE"), true,"У четвертого элемента есть модификатор SHARE")

    }
}