package lottoTest

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import lotto.domain.Lottery
import lotto.domain.Lotto
import lotto.domain.LottoMachine
import lotto.domain.PurchasedLottery

data class LottoMachineTestData(
    val purchaseAmount: Int,
    val manualLottery: Lottery,
    val expectedAutoCount: Int
)

class LottoMachineTest : FunSpec({
    context("로또를 수동과 자동 섞어서 구매") {
        withData(
            listOf(
                LottoMachineTestData(
                    10000,
                    Lottery(
                        listOf(
                            Lotto(listOf(1, 2, 3, 4, 5, 6)),
                            Lotto(listOf(1, 2, 3, 4, 5, 7)),
                        )
                    ),
                    8
                ),
                LottoMachineTestData(
                    8500,
                    Lottery(
                        listOf()
                    ),
                    8
                ),
                LottoMachineTestData(
                    3200,
                    Lottery(
                        listOf(
                            Lotto(listOf(1, 2, 3, 4, 5, 6)),
                            Lotto(listOf(1, 2, 3, 4, 5, 7)),
                            Lotto(listOf(1, 2, 3, 4, 5, 8)),
                        )
                    ),
                    0
                ),
            )
        ) { (purchaseAmount, manualLottery, expectedAutoCount) ->
            val purchasedLottery: PurchasedLottery =
                LottoMachine.purchase(purchaseAmount = purchaseAmount, manualLottery = manualLottery)

            purchasedLottery.getManualCount() shouldBe manualLottery.getCount()
            purchasedLottery.getAutoCount() shouldBe expectedAutoCount
        }
    }
})
