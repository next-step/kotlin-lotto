package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.doubles.shouldBeExactly
import io.kotest.matchers.shouldBe
import lotto.domain.RankReward.FIRST
import lotto.domain.RankReward.FOURTH
import lotto.domain.RankReward.SECOND

class DrawResultTest : StringSpec({
    "당첨로또 추첨은 개수별 일치하는 로또수를 반환한다" {
        val winningLotto =
            WinningLotto(
                lottoNumbers = LottoNumbers.from(setOf(1, 2, 3, 4, 5, 6)),
                bonus = LottoNumber(45),
            )

        val firstLotto1 = Lotto(LottoNumbers.from(setOf(1, 2, 3, 4, 5, 6)))
        val firstLotto2 = Lotto(LottoNumbers.from(setOf(1, 2, 3, 4, 5, 6)))

        val secondLotto1 = Lotto(LottoNumbers.from(setOf(1, 2, 3, 4, 5, 45)))
        val secondLotto2 = Lotto(LottoNumbers.from(setOf(1, 2, 3, 4, 45, 6)))
        val secondLotto3 = Lotto(LottoNumbers.from(setOf(1, 2, 3, 45, 5, 6)))

        val drawResult =
            DrawResult.from(
                winningLotto = winningLotto,
                purchaseLotteries =
                    listOf(
                        firstLotto1,
                        firstLotto2,
                        secondLotto1,
                        secondLotto2,
                        secondLotto3,
                    ),
            )

        drawResult.getLottoCount(FIRST).count shouldBe 2
        drawResult.getLottoCount(SECOND).count shouldBe 3
    }

    "구입 금액과 결과를 계산하여 수익률을 반환한다" {
        val drawResult = DrawResult(mapOf(FOURTH to LottoCount(1)))

        drawResult.getProfitRate(Money(1_000_000)) shouldBeExactly 0.05
    }
})
