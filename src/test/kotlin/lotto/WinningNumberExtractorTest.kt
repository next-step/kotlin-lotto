package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockkObject
import io.mockk.unmockkAll
import lotto.domain.LottoTicketBundle
import lotto.utils.RandomNumberGenerator

class WinningNumberExtractorTest : StringSpec({
    "로또 당첨 개수에 따른 티켓 개수를 추출할 수 있다." {
        val ticketSize = 1
        mockkObject(RandomNumberGenerator)

        every { RandomNumberGenerator.generate(1..45) }.returnsMany(1, 2, 3, 4, 5, 6)
        val tickets = LottoTicketBundle(ticketSize).lottoTickets
        val lottoWinning = WinningNumberExtractor().process(tickets, setOf(1, 2, 3, 4, 5, 6))

        lottoWinning.result[6] shouldBe ticketSize

        unmockkAll()
    }
})
