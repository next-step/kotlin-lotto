package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class LottoTest {

    @ParameterizedTest
    @ValueSource(ints = [5, 7])
    fun `잘못된 숫자 갯수로 로또 생성 시 예외 발생`(size: Int) {
        assertThrows<IllegalArgumentException> {
            val numbers = (0 until size).toList().toIntArray()
            Lotto(*numbers)
        }
    }

    @Test
    fun `중복된 숫자로 로또 생성 시 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            Lotto(1, 2, 3, 4, 5, 1)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1, 2, 3, 0, 5, 6", "46, 1, 2, 3, 4, 5"])
    fun `1 ~ 45 이외의 숫자로 로또 생성시 예외 발생`(numbers: String) {
        val invalidNumbers = numbers.split(",").map { it.trim().toInt() }.toIntArray()

        assertThrows<IllegalArgumentException> {
            Lotto(*invalidNumbers)
        }
    }
}
