package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class LottoTicketKoTest : StringSpec({
    "당첨 결과" {
        mapOf(
            LottoNumbers(listOf(1, 2, 3, 4, 5, 6)) to WinResult.FIRST,
            LottoNumbers(listOf(1, 2, 3, 4, 5, 44)) to WinResult.THIRD,
            LottoNumbers(listOf(1, 2, 3, 4, 5, 45)) to WinResult.THIRD,
            LottoNumbers(listOf(1, 2, 3, 4, 44, 45)) to WinResult.FOURTH,
            LottoNumbers(listOf(1, 2, 3, 43, 44, 45)) to WinResult.FIFTH,
            LottoNumbers(listOf(1, 2, 42, 43, 44, 45)) to WinResult.LOSE,
        ).forAll { (winNumbers, winResult) ->
            val bonusNumber = 44
            LottoTicket(LottoNumbers(listOf(1, 2, 3, 4, 5, 6))).getWinResult(
                LottoTicket(winNumbers),
                bonusNumber,
            ) shouldBe winResult
        }
    }
})
