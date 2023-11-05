package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoAccountantSpec : FunSpec({
    test("로또 총 상금이 계산된다") {
        val lottoResult = listOf(
            LottoResult(matchedNumberCount = 1, ticketCount =  5),
            LottoResult(matchedNumberCount = 2, ticketCount =  10),
        )
        val prizeInfo = listOf(
            WinningPrize(matchedCount = 1, Amount(1000)),
            WinningPrize(matchedCount = 2, Amount(2000)),
        )

        val result = LottoAccountant.getTotalPrizeAmount(lottoResult, prizeInfo)

        result shouldBe Amount(5 * 1000 + 10 * 2000)
    }
})
