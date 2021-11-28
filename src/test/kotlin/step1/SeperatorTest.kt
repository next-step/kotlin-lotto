package step1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class SeperatorTest {

    private val seperator = Seperator()

    @ParameterizedTest
    @ValueSource(strings = ["3,2:1", "1,2:3", "5,2,3", "6:2:1"])
    fun `연산에 필요한 숫자 분류`(expression: String) {
        val numbers = seperator.getNumbers(expression)
        assertEquals(3, numbers.size)
        assertEquals(2, numbers[1])
    }

}
