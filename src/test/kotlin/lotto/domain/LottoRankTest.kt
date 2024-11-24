package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoRankTest : StringSpec({
    fun verifyLottoRank(
        matchCount: Int,
        expectedRank: LottoRank,
        expectedPrize: Int,
    ) {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        var matchingTicket: LottoTicket? = null
        while (matchingTicket == null) {
            val lottoTickets = List(14000) { LottoTicket() }
            matchingTicket =
                lottoTickets.firstOrNull { ticket ->
                    ticket.matchCount(winningNumbers) == matchCount
                }
        }

        val rank = LottoRank.from(matchingTicket!!.matchCount(winningNumbers))
        rank shouldBe expectedRank
        rank.prize shouldBe expectedPrize
    }

    "구매한 로또 목록에서 당첨 번호와 일치하는 게 3개이면 5등이다. (5000원)" {
        verifyLottoRank(3, LottoRank.FIFTH, 5000)
    }

    "구매한 로또 목록에서 당첨 번호와 일치하는 게 4개이면 4등이다. (50000원)" {
        verifyLottoRank(4, LottoRank.FOURTH, 50_000)
    }

    "구매한 로또 목록에서 당첨 번호와 일치하는 게 5개이면 3등이다. (1500000원)" {
        verifyLottoRank(5, LottoRank.THIRD, 1_500_000)
    }

    "구매한 로또 목록에서 당첨 번호와 일치하는 게 6개이면 1등이다. (2000000000원)" {
        verifyLottoRank(6, LottoRank.FIRST, 2_000_000_000)
    }

    "로또 번호는 6개, 1부터 45 사이의 숫자, 중복 불가여야 한다." {
        shouldThrow<IllegalArgumentException> {
            LottoTicket(listOf(1, 2, 3, 4, 5))
        }
        shouldThrow<IllegalArgumentException> {
            LottoTicket(listOf(1, 2, 3, 4, 5, 5))
        }
        shouldThrow<IllegalArgumentException> {
            LottoTicket(listOf(1, 2, 3, 4, 5, 46))
        }
    }
})
