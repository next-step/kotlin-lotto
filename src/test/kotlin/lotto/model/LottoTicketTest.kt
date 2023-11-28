package lotto.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import lotto.view.order.impl.LottoAutomaticOrderStrategy

class LottoTicketTest : StringSpec({

    "6개의 로또 번호가 일치 하면 1등 당첨자로 집계 해야 한다" {
        val ticket = LottoTicket(
            LottoAutomaticOrderStrategy.issue(20) +
                LottoGame(1, 2, 3, 4, 5, 6)
        )
        val winingNumbers = WinningNumbers(LottoGame(1, 2, 3, 4, 5, 6), LottoNumber(7))
        val actual = ticket.winnerAggregate(winingNumbers)

        actual.countOfRank(Rank.FIRST) shouldBeGreaterThanOrEqual 1
        actual.countOfRank(Rank.SECOND) shouldBeGreaterThanOrEqual 0
        actual.countOfRank(Rank.THIRD) shouldBeGreaterThanOrEqual 0
        actual.countOfRank(Rank.FOURTH) shouldBeGreaterThanOrEqual 0
        actual.countOfRank(Rank.FIFTH) shouldBeGreaterThanOrEqual 0
    }

    "5개의 로또 번호가 일치 하고 보너스볼이 일치하면 2등 당첨자로 집계 해야 한다" {
        val secondWinningNumbers = LottoGame(1, 2, 3, 4, 5, 22)
        val ticket = LottoTicket(
            LottoAutomaticOrderStrategy.issue(20) +
                secondWinningNumbers
        )
        val winingNumbers = WinningNumbers(LottoGame(1, 2, 3, 4, 5, 6), LottoNumber(22))
        val actual = ticket.winnerAggregate(winingNumbers)

        actual.countOfRank(Rank.FIRST) shouldBeGreaterThanOrEqual 0
        actual.countOfRank(Rank.SECOND) shouldBeGreaterThanOrEqual 1
        actual.countOfRank(Rank.THIRD) shouldBeGreaterThanOrEqual 0
        actual.countOfRank(Rank.FOURTH) shouldBeGreaterThanOrEqual 0
        actual.countOfRank(Rank.FIFTH) shouldBeGreaterThanOrEqual 0
    }

    "5개의 로또 번호가 일치 하고 보너스볼이 일치하지 않으면 3등 당첨자로 집계 해야 한다" {
        val thirdWinningNumbers = LottoGame(1, 2, 3, 4, 5, 11)
        val ticket = LottoTicket(
            LottoAutomaticOrderStrategy.issue(20) +
                thirdWinningNumbers
        )
        val winingNumbers = WinningNumbers(LottoGame(1, 2, 3, 4, 5, 6), LottoNumber(22))
        val actual = ticket.winnerAggregate(winingNumbers)

        actual.countOfRank(Rank.FIRST) shouldBeGreaterThanOrEqual 0
        actual.countOfRank(Rank.SECOND) shouldBeGreaterThanOrEqual 0
        actual.countOfRank(Rank.THIRD) shouldBeGreaterThanOrEqual 1
        actual.countOfRank(Rank.FOURTH) shouldBeGreaterThanOrEqual 0
        actual.countOfRank(Rank.FIFTH) shouldBeGreaterThanOrEqual 0
    }

    "4개의 로또 번호가 일치 하면 4등 당첨자로 집계 해야 한다" {
        val fourthWinningNumbers = LottoGame(1, 2, 3, 4, 12, 11)
        val ticket = LottoTicket(
            LottoAutomaticOrderStrategy.issue(20) +
                fourthWinningNumbers
        )
        val winingNumbers = WinningNumbers(LottoGame(1, 2, 3, 4, 5, 6), LottoNumber(22))
        val actual = ticket.winnerAggregate(winingNumbers)

        actual.countOfRank(Rank.FIRST) shouldBeGreaterThanOrEqual 0
        actual.countOfRank(Rank.SECOND) shouldBeGreaterThanOrEqual 0
        actual.countOfRank(Rank.THIRD) shouldBeGreaterThanOrEqual 0
        actual.countOfRank(Rank.FOURTH) shouldBeGreaterThanOrEqual 1
        actual.countOfRank(Rank.FIFTH) shouldBeGreaterThanOrEqual 0
    }

    "3개의 로또 번호가 일치 하면 5등 당첨자로 집계 해야 한다" {
        val fifthWinningNumbers = LottoGame(1, 2, 3, 13, 12, 11)
        val ticket = LottoTicket(
            LottoAutomaticOrderStrategy.issue(20) +
                fifthWinningNumbers
        )
        val winingNumbers = WinningNumbers(LottoGame(1, 2, 3, 4, 5, 6), LottoNumber(22))
        val actual = ticket.winnerAggregate(winingNumbers)

        actual.countOfRank(Rank.FIRST) shouldBeGreaterThanOrEqual 0
        actual.countOfRank(Rank.SECOND) shouldBeGreaterThanOrEqual 0
        actual.countOfRank(Rank.THIRD) shouldBeGreaterThanOrEqual 0
        actual.countOfRank(Rank.FOURTH) shouldBeGreaterThanOrEqual 0
        actual.countOfRank(Rank.FIFTH) shouldBeGreaterThanOrEqual 1
    }
})
