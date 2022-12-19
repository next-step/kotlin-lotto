package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

/**
 * @see LottoStore
 */
class LottoStoreTest : FunSpec({

    test("buyLotto") {
        val cash = Cash(1000)
        val (rest, unusedTickets) = LottoStore.buyLotto(cash)

        (rest == Cash(0)) shouldBe true
        unusedTickets.getTicketCount() shouldBe 1
    }
})
