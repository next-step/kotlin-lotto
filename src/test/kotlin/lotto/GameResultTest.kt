package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto.prize.Prize
import lotto.vo.Money

class GameResultTest : FreeSpec({
    "당첨 통계에서 통해 게임의 수익률을 확인할 수 있다" {
        forAll(
            row(
                listOf(
                    Prize.MATCH_3 to 1,
                    Prize.MATCH_4 to 0,
                    Prize.MATCH_5 to 0,
                    Prize.MATCH_6 to 0,
                ),
                14000, 5000 / 14000.toDouble()
            ),
            row(
                listOf(
                    Prize.MATCH_3 to 1,
                    Prize.MATCH_4 to 1,
                    Prize.MATCH_5 to 1,
                    Prize.MATCH_6 to 1,
                ),
                14000, (2001555000) / 14000.toDouble()
            )
        ) { prizes, totalPrice, expectedProfitRate ->
            val sut = GameResult(
                prizes, Money(totalPrice)
            )

            val result = sut.profitRate

            result shouldBe expectedProfitRate
        }
    }
})
