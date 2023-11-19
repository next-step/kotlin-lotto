package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoGameResultTest : FunSpec({

    test("로또 게임 결과는 등수별 당첨 결과를 갖는다.") {
        val purchaseMoney = 1_000L
        val winningLottoNumbers = setOf(1, 2, 3, 4, 5, 6)
        val lottos = listOf(
            Lotto(setOf(1, 2, 3, 4, 5, 6)),
            Lotto(setOf(10, 20, 30, 4, 5, 6)),
        )

        val lottoGameResult = LottoGameResult(purchaseMoney, winningLottoNumbers, lottos)

        lottoGameResult.lottoWinningResults shouldBe listOf(
            LottoWinningResult(LottoPrize.FIRST, 1),
            LottoWinningResult(LottoPrize.SECOND, 0),
            LottoWinningResult(LottoPrize.THIRD, 0),
            LottoWinningResult(LottoPrize.FOURTH, 1),
        )
    }

    test("로또 게임 결과는 수익률을 갖는다.") {
        val purchaseMoney = 1_000L
        val winningLottoNumbers = setOf(1, 2, 3, 4, 5, 6)
        val lottos = listOf(Lotto(setOf(1, 2, 3, 4, 5, 6)))

        val lottoGameResult = LottoGameResult(purchaseMoney, winningLottoNumbers, lottos)

        lottoGameResult.totalRateOfReturn shouldBe LottoPrize.FIRST.prizeMoney.toDouble() / purchaseMoney.toDouble()
    }
})
