package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.prize.Prize
import lotto.test.lottoNumbersOf
import lotto.vo.LottoNumber
import lotto.vo.Money
import lotto.vo.WinningNumbers

class LottosTest : FreeSpec({
    "로또 저장소는 당첨 번호와 추가 번호를 받아 구매한 로또의 당첨 통계를 집계한다." - {
        val lottos = Lottos.from(
            Lotto.from(lottoNumbersOf(1, 2, 3, 4, 5, 6)),
            Lotto.from(lottoNumbersOf(1, 2, 3, 4, 5, 7)),
            Lotto.from(lottoNumbersOf(1, 2, 3, 4, 7, 8)),
            Lotto.from(lottoNumbersOf(1, 2, 7, 10, 11, 12)),
        )
        val winningNumbers = WinningNumbers(lottoNumbersOf(1, 2, 3, 4, 5, 6), LottoNumber.from(7))

        val result = lottos.playWith(winningNumbers)

        result shouldBe GameResult(
            prizes = listOf(
                Prize.MATCH_3 to 0,
                Prize.MATCH_4 to 1,
                Prize.MATCH_5 to 0,
                Prize.MATCH_5_BONUS to 1,
                Prize.MATCH_6 to 1,
            ),
            paidPrice = Money(4000),
        )
    }
})
