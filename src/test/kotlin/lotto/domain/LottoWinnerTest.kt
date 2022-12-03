package lotto.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class LottoWinnerTest : FreeSpec({

    val lotto = listOf(
        Lotto(listOf(1, 2, 3, 4, 5, 6)),
        Lotto(listOf(10, 11, 12, 13, 14, 15))
    )
    val luckyLotto = listOf(1, 2, 3, 4, 5, 6)

    "findWinLottoList" - {

        "구매한 로또중 당첨된 금액들을 반환한다." {
            val lottoWinner = LottoWinner(luckyLotto, lotto)

            val rewardList = lottoWinner.findWinLottoList()

            rewardList shouldBe listOf(Reward.FIRST)
        }
    }
})
