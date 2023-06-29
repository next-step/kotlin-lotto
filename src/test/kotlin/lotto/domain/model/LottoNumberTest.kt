package lotto.domain.model

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.api.Test

class LottoNumberTest {
    @Test
    fun `1 미만 또는 45를 초과하는 숫자는 IllegalArgumentException이 발생합니다`() {
        shouldThrow<IllegalArgumentException> {
            LottoNumber.from(0)
        }
        shouldThrow<IllegalArgumentException> {
            LottoNumber.from(46)
        }
    }

    @Test
    fun `1 이상 45 이하의 숫자는 예외가 발생하지 않습니다`() {
        shouldNotThrow<IllegalArgumentException> {
            for (i in 1..45) {
                LottoNumber.from(i)
            }
        }
    }
}
