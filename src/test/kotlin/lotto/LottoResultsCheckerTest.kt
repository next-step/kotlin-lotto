package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoResultsCheckerTest : StringSpec({
    "구매한 로또 목록과 당첨 번호를 비교해서 등수 별 개수를 기록한다" {
        val firstPrize = setOf(1, 2, 3, 4, 5, 6)
        val lottos =
            Lottos(
                listOf(
                    Lotto(firstPrize),
                    Lotto(setOf(1, 2, 3, 4, 5, 45)),
                    Lotto(setOf(1, 2, 3, 4, 44, 45)),
                    Lotto(setOf(1, 2, 3, 43, 44, 45)),
                    Lotto(setOf(1, 2, 42, 43, 44, 45)),
                    Lotto(setOf(1, 41, 42, 43, 44, 45)),
                    Lotto(setOf(40, 41, 42, 43, 44, 45)),
                ),
            )
        val winningNumbers = WinningNumbers(firstPrize)

        val lottoResults = LottoResultChecker.check(lottos, winningNumbers)

        val expected = mapOf(LottoRank.FIRST to 1, LottoRank.FIRST to 1, LottoRank.SECOND to 1, LottoRank.THIRD to 1, LottoRank.FORTH to 1)
        lottoResults.resultCountByRank shouldBe expected
    }
})
