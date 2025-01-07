package lotto

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import lotto.domain.LottoNumber
import org.junit.jupiter.api.Test

class LottoNumberTest {
    @Test
    fun `로또 넘버는 1부터 45 이내 이다`() {
        (1..45).forEach {
            shouldNotThrow<IllegalArgumentException> {
                LottoNumber(it)
            }
        }
    }

    @Test
    fun `로또 넘버는 0이 될 수 없다`() {
        shouldThrow<IllegalArgumentException> {
            LottoNumber(0)
        }
    }

    @Test
    fun `로또 넘버는 100이 될 수 없다`() {
        shouldThrow<IllegalArgumentException> {
            LottoNumber(100)
        }
    }
}
