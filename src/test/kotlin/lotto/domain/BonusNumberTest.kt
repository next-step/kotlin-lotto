package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class BonusNumberTest {
    @Test
    fun `보너스 번호는 로또 티켓의 번호와 중복될 수 없다`() {
        val lottoTicket = LottoTicket.from(setOf(1, 2, 3, 4, 5, 6))
        shouldThrow<IllegalArgumentException> {
            BonusNumber.of(LottoNumber(6), lottoTicket)
        }.also {
            it.message shouldBe "보너스 번호는 로또 티켓의 번호와 중복될 수 없습니다"
        }
    }
}
