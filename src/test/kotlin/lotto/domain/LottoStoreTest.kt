package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoStoreTest : StringSpec({
    "should combine manual and auto tickets correctly" {
        val lottoGenerator = RandomLottoGenerator()
        val lottoStore = LottoStore(lottoGenerator)

        val manualTickets =
            LottoTickets(
                listOf(
                    Lotto.of(listOf(1, 2, 3, 4, 5, 6)),
                    Lotto.of(listOf(7, 8, 9, 10, 11, 12)),
                ),
            )
        val autoTicketAmount = PurchaseAmount(6000).calculateAutoTicketAmount(TicketCount(manualTickets.size()))
        val combinedTickets =
            lottoStore.sell(autoTicketAmount).let { autoTickets ->
                LottoTickets.combine(manualTickets.getTickets(), autoTickets.getTickets())
            }

        combinedTickets.size() shouldBe 6
        combinedTickets.getTickets().take(2) shouldBe manualTickets.getTickets()
        combinedTickets.getTickets().drop(2).all { it.getNumbers().size == 6 } shouldBe true
    }
})
