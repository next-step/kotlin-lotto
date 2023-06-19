package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.test.lottoNumbersOf
import lotto.vo.Money

class LottosTest : FreeSpec({
    "로또 저장소는 당첨 번호를 받아 구매한 로또들의 당첨 통계를 집계한다." - {
        val lottos = Lottos.from(
            Lotto.from(lottoNumbersOf(1, 2, 3, 4, 5, 6)),
            Lotto.from(lottoNumbersOf(1, 2, 3, 4, 5, 7)),
            Lotto.from(lottoNumbersOf(1, 2, 3, 7, 8, 9)),
            Lotto.from(lottoNumbersOf(1, 2, 7, 10, 11, 12)),
        )
        val winningNumbers = lottoNumbersOf(1, 2, 3, 4, 5, 6)

        val result = lottos.playWith(winningNumbers)

        result shouldBe GameResult(
            prizes = listOf(
                WinningPrize.MATCH_3 to 1,
                WinningPrize.MATCH_4 to 0,
                WinningPrize.MATCH_5 to 1,
                WinningPrize.MATCH_6 to 1,
            ),
            paidPrice = Money(4000),
        )
    }
})
