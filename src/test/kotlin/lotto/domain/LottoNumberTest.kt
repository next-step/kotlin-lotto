package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumberTest {
    @Test
    internal fun `로또숫자는 1에서 45사이의 숫자만 가능하다`() {
        var lottoNumber1 = LottoNumber(1)
        var lottoNumber2 = LottoNumber(1)
        (lottoNumber1 == lottoNumber2) shouldBe true

        assertThrows<IllegalArgumentException> {
            LottoNumber(46)
        }
    }
}
