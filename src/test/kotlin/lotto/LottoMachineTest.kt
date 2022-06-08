package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoMachine
import lotto.domain.Money
import lotto.domain.Tickets
import lotto.util.lottoOf

class LottoMachineTest : FreeSpec({
    "입력된 금앤만큼 자동으로 로또를 발행한다." {
        val tickets = LottoMachine().buy(Money(14500), null)
        tickets.count() shouldBe 14
    }
    "입력된 금앤만큼 자동과 수동으로 로또를 발행한다." {
        val tickets = LottoMachine().buy(
            Money(14500),
            Tickets(
                listOf(
                    lottoOf(1, 2, 3, 4, 5, 6),
                    lottoOf(1, 2, 3, 4, 5, 6),
                    lottoOf(1, 2, 3, 4, 5, 6),
                    lottoOf(1, 2, 3, 4, 5, 6),
                )
            )
        )
        tickets.count() shouldBe 14
    }
})
