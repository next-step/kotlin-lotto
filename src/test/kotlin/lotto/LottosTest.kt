package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottosTest : StringSpec({
    "구입금액에 해당하는 개수만큼 로또를 생성한다" {
        val lottos = Lottos.of(purchaseAmount = 2000)

        lottos.size shouldBe 2
    }

    "일치하는 개수 별 당첨 로또 개수를 구한다" {
        val lottos = Lottos(
            listOf(
                Lotto.of(listOf(1, 2, 3, 4, 5, 6)),
                Lotto.of(listOf(1, 2, 3, 7, 8, 9)),
                Lotto.of(listOf(1, 2, 6, 7, 8, 9)),
            )
        )

        val winningLottoCount = lottos.getWinningLottoCountByMatchCount(
            winningLotto = Lotto.of(listOf(1, 2, 3, 41, 42, 43)),
            matchCount = 3
        )

        winningLottoCount shouldBe 2
    }

    "수익률을 구한다" {
        val lottos = Lottos(
            listOf(
                Lotto.of(listOf(1, 2, 3, 4, 5, 6)),
                Lotto.of(listOf(1, 2, 3, 7, 8, 9)),
                Lotto.of(listOf(1, 2, 6, 7, 8, 9)),
            )
        )

        val totalProfitRate = lottos.getTotalProfitRate(
            winningLotto = Lotto.of(listOf(1, 2, 3, 41, 42, 43)),
        )

        totalProfitRate shouldBe 3.33.toBigDecimal() // (= 5000 * 2 / 1000 * 3)
    }
})
