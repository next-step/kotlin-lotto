package lotto.domain.lotto.ticket

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class LottoTicketContainerTest : FunSpec({

    context("LottoTicketContainer가 정상적으로 생성된다") {
        withData(
            nameFn = { "count=$it" },
            (1..100)
        ) { totalTicketCount ->
            val lottoTicketContainer = LottoTicketContainer.havingSizeOf(totalTicketCount)

            lottoTicketContainer shouldNotBe null
            lottoTicketContainer shouldHaveSize totalTicketCount
        }
    }

    context("LottoTicketContainer에 동일한 번호를 가진 티켓을 중복으로 가질 수 있다") {
        val fixedLottoTicket = LottoTicket.randomGenerate()

        withData(
            nameFn = { "LottoTicketContainer(${it.second})" },
            (1..100).map { it to (1..it).map { fixedLottoTicket }.toList() }
        ) { (duplicatedTicketCount, lottoTicketList) ->
            val lottoTicketContainer = LottoTicketContainer(lottoTicketList)

            lottoTicketContainer shouldNotBe null
            lottoTicketContainer shouldHaveSize duplicatedTicketCount
            lottoTicketContainer.count { it == fixedLottoTicket } shouldBe duplicatedTicketCount
        }
    }
})
