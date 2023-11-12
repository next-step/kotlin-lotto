package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoMachineTest : FunSpec({
    val lottoMachine = LottoMachine(5000)

    test("구입 금액에 대한 총 로또 발급 갯수를 출력 한 뒤 로또 발급 갯수 확인") {
        lottoMachine.getCountOfLotto() shouldBe 5
        lottoMachine.getLottoList().size shouldBe 5
    }

    test("로또 수익률 계산") {
        val totalPrize = 5_000
        val totalEarning = LottoMachine.calculateTotalEarning(totalPrize, 14)
        totalEarning shouldBe 0.35
    }
})
