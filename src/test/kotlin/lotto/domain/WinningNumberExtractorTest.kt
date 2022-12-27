package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockkObject
import io.mockk.unmockkObject
import lotto.utils.RandomNumberGenerator

internal class WinningNumberExtractorTest : StringSpec({
    "로또 당첨 개수에 따른 티켓 개수를 추출할 수 있다." {
        val amount = 1000
        mockkObject(RandomNumberGenerator)

        every { RandomNumberGenerator.generate(1..45) }.returnsMany(1, 2, 3, 4, 5, 6)
        val lottoWinning = WinningNumberExtractor.process(
            LottoTicketBundle(amount),
            WinningNumbers(
                setOf(
                    LottoNumber(1), LottoNumber(2), LottoNumber(3),
                    LottoNumber(4), LottoNumber(5), LottoNumber(6)
                ),
                LottoNumber(7)
            )
        )

        val ticketResult = TicketResult(6, false)
        lottoWinning.result[ticketResult] shouldBe 1

        unmockkObject(RandomNumberGenerator)
    }

    "로또 당첨 개수가 5개이고, 보너스 볼이 맞다면 2등에 당첨된다." {
        val amount = 1000
        mockkObject(RandomNumberGenerator)

        every { RandomNumberGenerator.generate(1..45) }.returnsMany(1, 2, 3, 4, 5, 7)
        val lottoWinning = WinningNumberExtractor.process(
            LottoTicketBundle(amount),
            WinningNumbers(
                setOf(
                    LottoNumber(1), LottoNumber(2), LottoNumber(3),
                    LottoNumber(4), LottoNumber(5), LottoNumber(6)
                ),
                LottoNumber(7)
            )
        )

        val ticketResult = TicketResult(5, true)
        lottoWinning.result[ticketResult] shouldBe 1

        unmockkObject(RandomNumberGenerator)
    }
})
