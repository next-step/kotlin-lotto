package lotto.domain

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe

class LottoRankTest : ExpectSpec({

    expect("일치 개수를 입력하면 당첨금별 카운트를 반환한다.") {
        val matchResult =
            LottoPrize.values().map { MatchResult(it.matchingCount, it == LottoPrize.SECOND) }
        val rank = LottoRank(matchResult, Amount(1000))

        val winningCount = rank.getWinningCount()

        LottoPrize.values().forEach {
            winningCount[it] shouldBe 1
        }
    }

    context("당첨금이 5만원인 경우 수익률 계산") {
        val matchResult = listOf(MatchResult(LottoPrize.FOURTH.matchingCount, false))

        expect("구매 비용이 5천원인 경우 수익률은 10.0 이다.") {
            val rank = LottoRank(matchResult, Amount(5_000))
            val profitRate = rank.getProfitRate()

            profitRate.value shouldBe 10.0
        }

        expect("구매 비용이 5만원인 경우 수익률은 1.0 이다.") {
            val rank = LottoRank(matchResult, Amount(50_000))
            val profitRate = rank.getProfitRate()

            profitRate.value shouldBe 1.0
        }

        expect("구매 비용이 50만원인 경우 수익률은 0.1 이다.") {
            val rank = LottoRank(matchResult, Amount(500_000))
            val profitRate = rank.getProfitRate()

            profitRate.value shouldBe 0.1
        }
    }
})
