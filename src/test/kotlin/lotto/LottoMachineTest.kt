package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoMachineTest : FunSpec({
    val lottoMachine = LottoMachine(5000)

    test("구입 금액에 대한 총 로또 발급 갯수를 출력 한 뒤 로또 발급 갯수 확인") {
        lottoMachine.count shouldBe 5
        lottoMachine.getLottoList().size shouldBe 5
    }

    test("당첨 숫자를 확인") {
        val lottoMachine = LottoMachine(1000)
        val lottos = lottoMachine.lottos

        val winningNumber: List<Int> = lottos.flatMap { lotto -> lotto.numbers }
        lottoMachine.checkWinningNumbers(winningNumber)[6] shouldBe 1
    }

    test("로또 수익률 계산") {
        val lottoMachine = LottoMachine(14000)
        val totalPrize = 5000
        val totalEarning = lottoMachine.calculateTotalEarning(totalPrize)
        totalEarning shouldBe 0.35
    }
})
