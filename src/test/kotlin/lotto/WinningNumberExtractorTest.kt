package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockkObject
import io.mockk.unmockkObject
import lotto.domain.LottoTicketBundle
import lotto.domain.WinningNumbers
import lotto.utils.RandomNumberGenerator

internal class WinningNumberExtractorTest : StringSpec({
    "로또 당첨 개수에 따른 티켓 개수를 추출할 수 있다." {
        val amount = 1000
        mockkObject(RandomNumberGenerator)

        every { RandomNumberGenerator.generate(1..45) }.returnsMany(1, 2, 3, 4, 5, 6)
        val tickets = LottoTicketBundle(amount).lottoTickets
        val lottoWinning = WinningNumberExtractor.process(tickets, WinningNumbers(setOf(1, 2, 3, 4, 5, 6), 7))

        val ticketResult = TicketResult(6, false)
        lottoWinning.result[ticketResult] shouldBe 1

        unmockkObject(RandomNumberGenerator)
    }

    "로또 당첨 개수가 5개이고, 보너스 볼이 맞다면 2등에 당첨된다." {
        val amount = 1000
        mockkObject(RandomNumberGenerator)

        every { RandomNumberGenerator.generate(1..45) }.returnsMany(1, 2, 3, 4, 5, 7)
        val tickets = LottoTicketBundle(amount).lottoTickets
        val lottoWinning = WinningNumberExtractor.process(tickets, WinningNumbers(setOf(1, 2, 3, 4, 5, 6), 7))

        val ticketResult = TicketResult(5, true)
        lottoWinning.result[ticketResult] shouldBe 1

        unmockkObject(RandomNumberGenerator)
    }
})
