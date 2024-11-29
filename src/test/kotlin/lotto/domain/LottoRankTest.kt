package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoRankTest : StringSpec({
    fun verifyLottoRank(
        matchCount: Int,
        bonusNumber: BonusNumber?,
        expectedRank: LottoRank,
        expectedPrize: Int,
    ) {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        var matchingTicket: LottoTicket? = null
        while (matchingTicket == null) {
            val lottoTickets = List(15000) { LottoTicket() }
            matchingTicket =
                lottoTickets.firstOrNull { ticket ->
                    when {
                        expectedRank == LottoRank.SECOND && bonusNumber != null ->
                            ticket.matchCount(winningNumbers) == matchCount &&
                                ticket.hasBonusNumber(bonusNumber)
                        expectedRank == LottoRank.THIRD && bonusNumber != null ->
                            ticket.matchCount(winningNumbers) == matchCount &&
                                !ticket.hasBonusNumber(bonusNumber)
                        else -> ticket.matchCount(winningNumbers) == matchCount
                    }
                }
        }

        val rank =
            LottoRank.from(
                matchingTicket!!.matchCount(winningNumbers),
                bonusNumber?.let { matchingTicket!!.hasBonusNumber(it) } ?: false,
            )

        rank shouldBe expectedRank
        rank.prize shouldBe expectedPrize
    }

    "구매한 로또 목록에서 당첨 번호와 일치하는 게 0개이면 낙첨이다. (0원)" {
        verifyLottoRank(0, null, LottoRank.NONE, 0)
    }

    "구매한 로또 목록에서 당첨 번호와 일치하는 게 3개이면 5등이다. (5,000원)" {
        verifyLottoRank(3, null, LottoRank.FIFTH, 5000)
    }

    "구매한 로또 목록에서 당첨 번호와 일치하는 게 4개이면 4등이다. (50,000원)" {
        verifyLottoRank(4, null, LottoRank.FOURTH, 50_000)
    }

    "구매한 로또 목록에서 당첨 번호와 일치하는 게 5개이면 3등이다. (1,500,000원)" {
        verifyLottoRank(5, null, LottoRank.THIRD, 1_500_000)
    }

    "구매한 로또 목록에서 당첨 번호와 일치하는 게 5개이고, 남은 한 개의 번호가 보너스 번호와 일치하면 2등이다. (30,000,000원)" {
        val bonusNumber = BonusNumber(7)
        verifyLottoRank(5, bonusNumber, LottoRank.SECOND, 30_000_000)
    }

    "구매한 로또 목록에서 당첨 번호와 일치하는 게 6개이면 1등이다. (2,000,000,000원)" {
        verifyLottoRank(6, null, LottoRank.FIRST, 2_000_000_000)
    }

    // 기존의 로또 번호 검증 테스트는 그대로 유지
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