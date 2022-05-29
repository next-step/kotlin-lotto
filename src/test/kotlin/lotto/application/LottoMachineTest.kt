package lotto.application

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.doubles.shouldBeGreaterThanOrEqual
import lotto.application.vo.Purchase
import lotto.domain.WinningLotto

class LottoMachineTest : StringSpec({
    "로또 기계를 생성할수 있다" {
        shouldNotThrow<Throwable> { LottoMachine(Purchase(2_000, 1)) }
    }

    "자동 로또를 구입할수 있다" {
        val purchase = Purchase(2_000, 0)
        val lottoBundle = LottoMachine(purchase).buy(emptyList())

        lottoBundle.lottos shouldHaveSize purchase.purchaseCounts.autoLottoCount.count
    }

    "수동 로또를 구입할수 있다" {
        val purchase = Purchase(2_000, 2)
        val lottoBundle = LottoMachine(purchase).buy(listOf("1,2,3,4,5,6", "1,2,3,4,6,8"))

        lottoBundle.lottos shouldHaveSize purchase.purchaseCounts.manualLottoCount.count
    }

    "수동 로또 구입수와 입력한 수동 로또 번호수가 일치 하지 않으면 Exception을 던진다" {
        val purchase = Purchase(2_000, 2)

        shouldThrow<IllegalArgumentException> { LottoMachine(purchase).buy(listOf("1,2,3,4,6,8")) }
    }

    "자동, 수동 로또를 구입할수 있다" {
        val purchase = Purchase(2_000, 1)
        val lottoBundle = LottoMachine(purchase).buy(listOf("1,2,3,4,5,6"))

        lottoBundle.lottos shouldHaveSize purchase.purchaseCounts.autoLottoCount.count + purchase.purchaseCounts.manualLottoCount.count
    }

    "로또 당첨 결과를 알수 있다" {
        val lottoBundle = lottoMachine.buy(emptyList())
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 45)

        lottoMachine.drawLottoBundle(lottoBundle, winningLotto).winningRate shouldBeGreaterThanOrEqual 0.0
    }
}) {
    companion object {
        private val lottoMachine = LottoMachine(Purchase(2_000, 1))
    }
}
