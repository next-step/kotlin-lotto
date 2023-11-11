package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.api.Test

class LottoNumberTest {

    @Test
    fun `로또 번호는 1~45 사이의 수이다`() {
        shouldThrow<IllegalArgumentException> {
            LottoNumber.from(46)
        }
    }
}
