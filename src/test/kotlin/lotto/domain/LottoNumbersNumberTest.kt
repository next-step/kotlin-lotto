package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumber
import org.junit.jupiter.api.Test

class LottoNumbersNumberTest {

    @Test
    fun `로또 번호를 생성한다`() {
        val lottoNumber = LottoNumber(1)
        lottoNumber.number shouldBe 1
    }

    @Test
    fun `로또 번호는 45를 넘을 수 없다`() {
        shouldThrow<IllegalArgumentException> { LottoNumber(46) }
    }

    @Test
    fun `로또 번호는 음수일 수 없다`() {
        shouldThrow<IllegalArgumentException> { LottoNumber(-1) }
    }
}
