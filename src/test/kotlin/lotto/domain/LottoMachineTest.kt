package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.vo.PurchaseAmount

class LottoMachineTest : FunSpec({
    context("createAutoLottoNumbers()") {
        test("수동 로또 개수를 뺀, 1000원 당 6개의 로또 번호(자동)를 반환한다.") {
            val purchaseAmount = PurchaseAmount(4000)
            val manualLottoCount = 1
            val actual = LottoMachine.createAutoLottoNumbers(purchaseAmount, manualLottoCount)

            actual.size shouldBe 3
        }
    }
})
