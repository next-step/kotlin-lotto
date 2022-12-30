package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import lotto.domain.strategy.LottoAutoGenerateStrategy
import lotto.domain.strategy.LottoManualGenerateStrategy

internal class LottoTicketBundleTest : StringSpec({
    "로또 n개를 만들 수 있다." {
        val lottoTicketCount = LottoTicketCount(5, 0)
        val lottoTicketBundle = LottoTicketBundle(lottoTicketCount, listOf(LottoAutoGenerateStrategy(), LottoManualGenerateStrategy()))
        lottoTicketBundle shouldNotBe null
        lottoTicketBundle.lottoTickets.size shouldBe 5
    }
})
