package lotto.domain.lotto.ticket

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldNotBe

class LottoTicketContainerTest : FunSpec({

    context("LottoTicketContainer가 정상적으로 생성된다") {
        withData(
            nameFn = { "count=$it" },
            (1..100)
        ) { totalTicketCount ->
            val lottoTicketContainer = LottoTicketContainer(totalTicketCount)

            lottoTicketContainer shouldNotBe null
            lottoTicketContainer shouldHaveSize totalTicketCount
        }
    }
})
