package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import lotto.util.AutoNumbers

class LottoTicketsKoTest : StringSpec({
    val testNumbers = object : AutoNumbers {
        override fun generateNumbers(): List<Int> {
            return listOf(1, 2, 3, 4, 5, 6)
        }
    }

    "당첨 수익률 확인" {
        mapOf(
            listOf(1, 2, 3, 4, 5, 6) to 2000000.0f,
            listOf(1, 2, 3, 4, 5, 45) to 1500.0f,
            listOf(40, 41, 42, 43, 44, 45) to 0.0f,
        ).forAll { (winNumbers, yield) ->
            val bonusNumber = 44
            LottoTickets(Money(1000), testNumbers).getWinStats(
                LottoTicket(winNumbers),
                bonusNumber,
            ).yield shouldBe yield
        }
    }
})
