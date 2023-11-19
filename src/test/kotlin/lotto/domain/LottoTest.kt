package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
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
}
