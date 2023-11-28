package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoTicketsTest : StringSpec({
    val winningNumber = WinningNumber(
        LottoTicket(
            listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) },
        ),
        LottoNumber(7)
    )

    "LottoTickets should provide correct RankResult" {
        val actual = LottoTickets(
            listOf(
                LottoTicket(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }),
                LottoTicket(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }),
                LottoTicket(listOf(1, 2, 3, 4, 5, 7).map { LottoNumber(it) }),
                LottoTicket(listOf(1, 2, 3, 4, 5, 8).map { LottoNumber(it) }),
                LottoTicket(listOf(1, 2, 3, 4, 5, 8).map { LottoNumber(it) }),
                LottoTicket(listOf(1, 2, 3, 4, 8, 9).map { LottoNumber(it) }),
                LottoTicket(listOf(1, 2, 3, 11, 12, 13).map { LottoNumber(it) }),
                LottoTicket(listOf(11, 12, 13, 14, 15, 16).map { LottoNumber(it) })
            )
        ).getRankResult(winningNumber)

        val expected = RankResult(
            mapOf(
                Rank.FirstPlace to 2,
                Rank.SecondPlace to 1,
                Rank.ThirdPlace to 2,
                Rank.FourthPlace to 1,
                Rank.FifthPlace to 1,
                Rank.LastPlace to 1
            )
        )

        actual shouldBe expected
    }
})
