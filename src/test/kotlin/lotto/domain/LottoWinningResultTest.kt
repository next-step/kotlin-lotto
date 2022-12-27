package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class LottoWinningResultTest : StringSpec({
    "LottoTicketResult 결과에 따른 최종 당첨 금액을 계산할 수 있다." {
        val lottoWinningResult = LottoWinningResult(mapOf(LottoTicketResult(5, true) to 1))
        lottoWinningResult.totalAmount() shouldBe 30000000
    }
})
