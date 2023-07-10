package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import lotto.dto.LottoNumbers

class LottoTicketsKoTest : StringSpec({
    val testLottoTicket = LottoTicket(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)))

    "당첨 수익률 확인" {
        mapOf(
            LottoNumbers(listOf(1, 2, 3, 4, 5, 6)) to 2000000.0f,
            LottoNumbers(listOf(1, 2, 3, 4, 5, 45)) to 1500.0f,
            LottoNumbers(listOf(40, 41, 42, 43, 44, 45)) to 0.0f,
        ).forAll { (winNumbers, yield) ->
            val bonusNumber = 44
            LottoTickets(Money(1000), listOf(testLottoTicket)).getWinStats(
                LottoTicket(winNumbers),
                bonusNumber,
            ).yield shouldBe yield
        }
    }
})
