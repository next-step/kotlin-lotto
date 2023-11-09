package lotto.model

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoResultTest : FunSpec({
    test("일치한 번호 개수에 따라 티켓 카운트가 올바른지 테스트") {
        val matchedCount = 6
        val lottoPrizes = listOf(LottoPrize.create(matchedCount))
        val lottoResult = LottoResult(lottoPrizes, 0.0)

        val result = lottoResult.groupWinningTicketsCountByMatchedCount()

        result[matchedCount] shouldBe 1
    }

    test("일치한 번호가 존재하지 않는 티켓만 존재할 경우 모든 당첨 티켓 카운팅이 0인지 테스트") {
        val matchedCount = 0
        val lottoPrizes = listOf(LottoPrize.create(matchedCount))
        val lottoResult = LottoResult(lottoPrizes, 0.0)

        val result = lottoResult.groupWinningTicketsCountByMatchedCount()
            .values
            .sum()

        result shouldBe 0
    }
})
