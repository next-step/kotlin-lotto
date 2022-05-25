package lotto.application

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.doubles.shouldBeGreaterThanOrEqual
import lotto.application.vo.Amount
import lotto.application.vo.Purchase
import lotto.domain.WinningLotto

class LottoMachineTest : StringSpec({
    "로또 기계를 생성할수 있다" {
        shouldNotThrow<Throwable> { LottoMachine(Purchase(Amount(2_000))) }
    }

    "자동 로또를 구입할수 있다" {
        val purchase = Purchase(Amount(2_000))
        val lottoBundle = LottoMachine(purchase).buyAuto()

        lottoBundle.lottos shouldHaveSize purchase.lottoPurchaseCount
    }

    "로또 당첨 결과를 알수 있다" {
        val lottoBundle = lottoMachine.buyAuto()
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6))

        lottoMachine.drawLottoBundle(lottoBundle, winningLotto).winningRate shouldBeGreaterThanOrEqual 0.0
    }
}) {
    companion object {
        private val lottoMachine = LottoMachine(Purchase(Amount(10_000)))
    }
}
