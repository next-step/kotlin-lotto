package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoMachineTest : FunSpec({
    test("구입 금액을 입력하면 구입 금액에 해당하는 로또 개수를 반환한다.") {
        // given
        val lottoMachine = LottoMachine()
        val purchaseAmount = 14000
        val expected = 14

        // when
        val count = lottoMachine.getNumberOfTickets(purchaseAmount)

        // then
        count shouldBe expected
    }
})
