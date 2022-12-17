package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.vo.PurchaseAmount

class LottoMachineTest : FunSpec({
    context("createLottoNumbers()") {
        test("1000원 당 6개의 로또 번호(수동 + 자동)를 반환한다.") {
            val purchaseAmount = PurchaseAmount(3000)
            val manualLottoNumbers = listOf(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 4, 5, 6))
            val actual = LottoMachine.createLottoNumbers(purchaseAmount, manualLottoNumbers)

            actual.size shouldBe 3
        }
    }
})
