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

    fun lottoTicket(v1: Int, v2: Int, v3: Int, v4: Int, v5: Int, v6: Int): LottoTicket =
        LottoTicket(listOf(v1, v2, v3, v4, v5, v6).map { LottoNumber(it) })

    "LottoTickets should provide correct RankResult" {
        val actual = LottoTickets(
            listOf(
                lottoTicket(1, 2, 3, 4, 5, 6),
                lottoTicket(1, 2, 3, 4, 5, 6),
                lottoTicket(1, 2, 3, 4, 5, 7),
                lottoTicket(1, 2, 3, 4, 5, 8),
                lottoTicket(1, 2, 3, 4, 5, 8),
                lottoTicket(1, 2, 3, 4, 8, 9),
                lottoTicket(1, 2, 3, 11, 12, 13),
                lottoTicket(11, 12, 13, 14, 15, 16)
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
