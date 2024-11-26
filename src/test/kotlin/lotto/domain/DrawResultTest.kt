package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.doubles.shouldBeExactly
import io.kotest.matchers.shouldBe
import lotto.domain.RankReward.RANK_1
import lotto.domain.RankReward.RANK_2
import lotto.domain.RankReward.RANK_4

class DrawResultTest : StringSpec({
    "당첨로또 추첨은 개수별 일치하는 로또수를 반환한다" {
        val winningLotto = WinningLotto(LottoNumbers(setOf(1, 2, 3, 4, 5, 6)))

        val rank1Lotto1 = Lotto(LottoNumbers(setOf(1, 2, 3, 4, 5, 6)))
        val rank1Lotto2 = Lotto(LottoNumbers(setOf(1, 2, 3, 4, 5, 6)))

        val rank2Lotto1 = Lotto(LottoNumbers(setOf(1, 2, 3, 4, 5, 21)))
        val rank2Lotto2 = Lotto(LottoNumbers(setOf(1, 2, 3, 4, 5, 22)))
        val rank2Lotto3 = Lotto(LottoNumbers(setOf(1, 2, 3, 4, 5, 23)))

        val drawResult =
            DrawResult.from(
                winningLotto = winningLotto,
                purchaseLotteries =
                    listOf(
                        rank1Lotto1,
                        rank1Lotto2,
                        rank2Lotto1,
                        rank2Lotto2,
                        rank2Lotto3,
                    ),
            )

        drawResult.findLottoCount(RANK_1).count shouldBe 2
        drawResult.findLottoCount(RANK_2).count shouldBe 3
    }

    "구입 금액과 결과를 계산하여 수익률을 반환한다" {
        val drawResult = DrawResult(mapOf(RANK_4 to LottoCount(1)))

        drawResult.getProfitRate(Money(1_000_000)) shouldBeExactly 0.005
    }
})
