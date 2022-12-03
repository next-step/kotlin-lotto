package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.vo.PurchaseAmount

class LottoMachineTest : FunSpec({
    context("createLottoNumbers()") {
        test("1000원 당 6개의 로또 번호들을 반환한다.") {
            val purchaseAmount = PurchaseAmount(3000)
            val actual = LottoMachine.createLottoNumbers(purchaseAmount)

            actual.size shouldBe 3
        }
    }
})
