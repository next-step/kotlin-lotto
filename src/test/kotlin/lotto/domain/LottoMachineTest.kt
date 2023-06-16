package lotto.domain

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class LottoMachineTest : AnnotationSpec() {

    @Test
    fun `로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다`() {

        LottoMachine.buyLotto(14000)
        LottoMachine.lottoCount shouldBe 14
        LottoMachine.buyedLotto.size shouldBe 14
        LottoMachine.buyedLotto.forEach {
            it.size shouldBe 6
        }
    }

}
