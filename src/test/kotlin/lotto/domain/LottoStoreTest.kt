package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoStoreTest : StringSpec({
    "should sell the given number of lotto tickets" {
        val lottoGenerator = RandomLottoGenerator()
        val lottoStore = LottoStore(lottoGenerator)

        val amount = 9000
        val tickets = lottoStore.sell(amount)

        tickets.getTickets().size shouldBe 9
    }
})
