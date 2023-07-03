package lotto.service

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import lotto.domain.Rank

class LottoCalculatorTest : FunSpec({
    context("로또 일치 개수별 당첨금을 확인한다.") {
        withData(
            0 to 0,
            1 to 0,
            2 to 0,
            3 to 5_000,
            4 to 50_000,
            5 to 1_500_000,
            6 to 2_000_000_000,
        ) { (matchCount, expectedMoney) ->
            val money = LottoCalculator.calculatePrizeMoney(Rank.of(matchCount, false))
            money shouldBe expectedMoney
        }
    }

    context("로또가 5개 일치하고 보너스볼이 일치하면 상금이 30,000,000원이다.") {
        val money = LottoCalculator.calculatePrizeMoney(Rank.of(5, true))
        money shouldBe 30_000_000
    }
})
