package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

class LottoResultSpec : FunSpec({
    test("해당 하는 상금이 조회된다") {
        val matchedCount = 1
        val prizeAmount = Amount(1000)
        val prizesInfo = listOf(
            WinningPrize(matchedCount, prizeAmount),
            WinningPrize(2, Amount(2000)),
        )
        val ticketCount = 2
        val lottoResult = LottoResult(matchedNumberCount = matchedCount, ticketCount = ticketCount)

        val result = lottoResult.calculatePrize(prizesInfo)

        result.shouldNotBeNull()
        result shouldBe prizeAmount * ticketCount
    }
})
