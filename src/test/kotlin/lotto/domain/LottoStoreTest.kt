package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoStoreTest : StringSpec({
    "should sell the given number of lotto tickets" {
        val lottoGenerator = RandomLottoGenerator()
        val purchaseCalculator = DefaultLottoPurchaseCalculator()
        val lottoStore = LottoStore(lottoGenerator, purchaseCalculator)

        val amount = 9000
        val tickets = lottoStore.sell(amount)

        tickets.size shouldBe 9
        tickets.all { it.getNumbers().size == 6 } shouldBe true
        tickets.all { ticket -> ticket.getNumbers().all { it.number in 1..45 } } shouldBe true
    }
})
