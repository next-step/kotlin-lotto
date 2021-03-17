package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class LottoWonNumberTests {
    @Test
    fun `6개 미만이면 에러가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoWonNumber(
                setOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(1)
                ),
                LottoNumber(10)
            )
        }
    }

    @Test
    fun `6개 이상이면 문제가 없다`() {
        assertDoesNotThrow {
            LottoWonNumber(
                setOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6)
                ),
                LottoNumber(10)
            )
        }
    }
}
