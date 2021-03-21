package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class LottoWonNumbersTests {
    @Test
    fun `6개 이지만, 중첩되면은 안된다`() {
        assertThrows<IllegalArgumentException> {
            LottoWonNumbers(setOf(1, 2, 3, 4, 5, 1), 10)
        }
    }

    @Test
    fun `6개 이상이면 문제가 없다`() {
        assertDoesNotThrow {
            LottoWonNumbers(setOf(1, 2, 3, 4, 5, 6), 10)
        }
    }

    @Test
    fun `6개 미만이면 문제가 된다`() {
        assertThrows<IllegalArgumentException> {
            LottoWonNumbers(setOf(1, 2, 3, 4, 5), 10)
        }
    }

    @Test
    fun `기존 로또 번호와 보너스 번호는 겹치면 안된다`() {
        assertThrows<IllegalArgumentException> {
            LottoWonNumbers(setOf(1, 2, 3, 4, 5, 6), 6)
        }
    }
}
