package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class LottoWonNumbersTests {
    @Test
    fun `6개 미만이면 에러가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoWonNumbers(
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
            LottoWonNumbers(
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

    @Test
    fun `기존 로또 번호와 보너스 번호는 겹치면 안된다`() {
        assertThrows<IllegalArgumentException> {
            LottoWonNumbers(
                setOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6)
                ),
                LottoNumber(6)
            )
        }
    }
}
