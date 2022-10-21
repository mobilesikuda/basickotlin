package homework5

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Task3Test {

    @Test
    fun test() {
        assertEquals(checkPassword("Dfs6d"), false, "Длина должна быть больше 6 символов")
        assertEquals(checkPassword("Цfsadd"), false, "Должна быть одна цифра")
        assertEquals(checkPassword("7fsaяя"), false, "Должнам быть одна заглавная буква")
        assertEquals(checkPassword("Dfьььs5a"), false, "Не должно быть повторяющихся трех знаков подряд")
        assertEquals(checkPassword("Dfs5a88"), true, "Пароль должен проходить")
    }

}