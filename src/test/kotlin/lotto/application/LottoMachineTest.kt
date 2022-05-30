package lotto.application

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.doubles.shouldBeGreaterThanOrEqual
import lotto.domain.LottoBundle
import lotto.domain.WinningLotto
import lotto.domain.vo.LottoNumber

class LottoMachineTest : StringSpec({
    "로또 기계를 생성할수 있다" {
        shouldNotThrow<Throwable> { LottoMachine(PurchaseFactory.create(2_000, 1)) }
    }

    "자동 로또를 구입할수 있다" {
        val purchase = PurchaseFactory.create(2_000, 0)
        val autoLottos = LottoMachine(purchase).buyAuto()

        autoLottos shouldHaveSize purchase.purchaseCounts.autoLottoCount.count
    }

    "수동 로또를 구입할수 있다" {
        val purchase = PurchaseFactory.create(2_000, 1)
        val manualLottos = LottoMachine(purchase).buyManual(listOf("1,2,3,4,5,6"))

        manualLottos shouldHaveSize purchase.purchaseCounts.manualLottoCount.count
        manualLottos.first().lottoNumbers shouldContainAll setOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )
    }

    "수동 로또 구입수와 입력한 수동 로또 번호수가 일치 하지 않으면 Exception을 던진다" {
        val purchase = PurchaseFactory.create(2_000, 2)

        shouldThrow<IllegalArgumentException> { LottoMachine(purchase).buyManual(listOf("1,2,3,4,6,8")) }
    }

    "로또 당첨 결과를 알수 있다" {
        val lottos = lottoMachine.buyAuto()
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 45)

        lottoMachine.drawLottoBundle(LottoBundle(lottos), winningLotto).winningRate shouldBeGreaterThanOrEqual 0.0
    }
}) {
    companion object {
        private val lottoMachine = LottoMachine(PurchaseFactory.create(2_000, 1))
    }
}
