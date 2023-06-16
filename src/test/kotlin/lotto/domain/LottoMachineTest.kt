package lotto.domain

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.doubles.shouldBeLessThan
import io.kotest.matchers.shouldBe

class LottoMachineTest : AnnotationSpec() {

    @Test
    fun `로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다`() {

        LottoMachine.buyLotto(14000)
        LottoMachine.lottoCount shouldBe 14
        LottoMachine.buyedLottoes.size shouldBe 14
        LottoMachine.buyedLottoes.forEach {
            it.size shouldBe 6
        }
    }
    @Test
    fun `당첨결과를 설정할 수 있어야한다`() {
        LottoMachine.buyLotto(14000)
        val winNumbers = listOf(1, 2, 3, 4, 5, 6)
        LottoMachine.setWinNumbers(winNumbers)
        LottoMachine.rateOfReturn shouldBeLessThan 1.0
    }

}
