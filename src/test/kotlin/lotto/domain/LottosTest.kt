package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.math.BigDecimal
import java.math.RoundingMode

class LottosTest : FunSpec({
    test("구입금액에 해당하는 개수만큼 로또를 생성한다") {
        val lottos = Lottos.of(purchaseAmount = 2000, lottoGenerator = RandomLottoGenerator())

        lottos.size shouldBe 2
    }

    test("상금별 당첨 로또 개수를 구한다.") {
        val winningLotto = Lotto.of(listOf(1, 2, 3, 7, 8, 10))
        val secondPrizeLotto = Lotto.of(listOf(1, 2, 3, 7, 8, 9))
        val thirdPrizeLotto = Lotto.of(listOf(1, 2, 3, 7, 8, 11))
        val fourthPrizeLotto = Lotto.of(listOf(1, 2, 3, 7, 5, 6))
        val missPrizeLotto = Lotto.of(listOf(1, 2, 4, 5, 6, 9))
        val lottos = Lottos(
            listOf(
                winningLotto,
                secondPrizeLotto,
                thirdPrizeLotto,
                fourthPrizeLotto,
                fourthPrizeLotto,
                fourthPrizeLotto,
                missPrizeLotto
            )
        )

        val winningLottoCountsByPrize =
            lottos.getWinningCountsByPrize(WinningLotto(winningLotto, LottoNumber(9)))

        winningLottoCountsByPrize[Prize.FIRST] shouldBe 1
        winningLottoCountsByPrize[Prize.SECOND] shouldBe 1
        winningLottoCountsByPrize[Prize.THIRD] shouldBe 1
        winningLottoCountsByPrize[Prize.FOURTH] shouldBe 3
        winningLottoCountsByPrize[Prize.FIFTH] shouldBe 0
        winningLottoCountsByPrize.contains(Prize.MISS) shouldBe false
    }

    test("총 수익률을 계산한다") {
        val winningLotto = Lotto.of(listOf(1, 2, 3, 7, 8, 10))
        val secondPrizeLotto = Lotto.of(listOf(1, 2, 3, 7, 8, 9))
        val thirdPrizeLotto = Lotto.of(listOf(1, 2, 3, 7, 8, 11))
        val fourthPrizeLotto = Lotto.of(listOf(1, 2, 3, 7, 5, 6))
        val fifthPrizeLotto = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
        val missPrizeLotto = Lotto.of(listOf(1, 2, 4, 5, 6, 9))
        val lottos = Lottos(
            listOf(
                winningLotto,
                secondPrizeLotto,
                thirdPrizeLotto,
                fourthPrizeLotto,
                fifthPrizeLotto,
                missPrizeLotto
            )
        )

        val totalProfitRate: BigDecimal =
            lottos.getTotalProfitRate(WinningLotto(winningLotto, LottoNumber(9)))

        totalProfitRate shouldBe BigDecimal(338592.50).setScale(2, RoundingMode.HALF_UP)
    }
})
