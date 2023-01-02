package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

/**
 * @see LottoStore
 */
class LottoStoreTest : FunSpec({

    test("buyLotto") {
        val cash = Cash(1000)
        val unusedTickets = LottoStore.buyLotto(cash)

        unusedTickets.getTicketCount() shouldBe 1
    }
})
