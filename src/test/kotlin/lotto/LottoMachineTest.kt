package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoMachine
import lotto.domain.Money

class LottoMachineTest : FreeSpec({
    "입력된 금앤만큼 로또를 발행한다." {
        val tickets = LottoMachine().buy(Money(14500))
        tickets.size shouldBe 14
    }
})
