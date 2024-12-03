package lotto.domain

import io.kotest.assertions.assertSoftly
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class LottoResultCheckerTest : FreeSpec({
    "구매한 로또 목록과 당첨 번호를 비교해서 등수 별 개수를 기록한다" {
        val firstPrizeLotto = Lotto(1, 2, 3, 4, 5, 6)
        val userLottos =
            UserLottos(
                listOf(
                    firstPrizeLotto,
                    Lotto(1, 2, 3, 4, 5, 45),
                    Lotto(1, 2, 3, 4, 44, 45),
                    Lotto(1, 2, 3, 43, 44, 45),
                    Lotto(1, 2, 42, 43, 44, 45),
                    Lotto(1, 41, 42, 43, 44, 45),
                    Lotto(40, 41, 42, 43, 44, 45),
                ),
            )
        val winningLotto = WinningLotto(firstPrizeLotto)

        val lottoResults = LottoResultChecker.check(userLottos, winningLotto)

        assertSoftly {
            lottoResults.getWinningLottoCountBy(LottoRank.FIRST) shouldBe 1
            lottoResults.getWinningLottoCountBy(LottoRank.SECOND) shouldBe 1
            lottoResults.getWinningLottoCountBy(LottoRank.THIRD) shouldBe 1
            lottoResults.getWinningLottoCountBy(LottoRank.FORTH) shouldBe 1
        }
    }
})
