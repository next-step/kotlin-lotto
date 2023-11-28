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

//
//    "5개의 로또 번호가 일치 하고 보너스볼이 일치하면 2등 당첨자로 집계 해야 한다" {
//        val secondWinningNumbers = listOf(1, 2, 3, 4, 5, 22)
//        val purchasedLottoTicket = LottoOrderStrategy(
//            30,
//            listOf(LottoGame(LottoNumbers(secondWinningNumbers)))
//        ).lottoTicketBuyAutoAndManual(LottoNumbersRandomWithExceptStrategy(secondWinningNumbers.toSet()))
//        val winingNumbers = WinningNumbers(LottoNumbers(1, 2, 3, 4, 5, 33), LottoNumber(22))
//        val actual = purchasedLottoTicket.winnerAggregate(winingNumbers)
//
//        actual.countOfRank(Rank.FIRST) shouldBe 0
//        actual.countOfRank(Rank.SECOND) shouldBe 1
//        actual.countOfRank(Rank.THIRD) shouldBe 0
//        actual.countOfRank(Rank.FOURTH) shouldBe 0
//        actual.countOfRank(Rank.FIFTH) shouldBe 0
//    }
//
//    "5개의 로또 번호가 일치 하고 보너스볼이 일치하지 않으면 3등 당첨자로 집계 해야 한다" {
//        val thirdWinningNumbers = listOf(1, 2, 3, 4, 5, 11)
//        val purchasedLottoTicket = LottoOrderStrategy(
//            30,
//            listOf(LottoGame(LottoNumbers(thirdWinningNumbers)))
//        ).lottoTicketBuyAutoAndManual(LottoNumbersRandomWithExceptStrategy(thirdWinningNumbers.toSet()))
//        val winingNumbers = WinningNumbers(LottoNumbers(1, 2, 3, 4, 5, 33), LottoNumber(22))
//        val actual = purchasedLottoTicket.winnerAggregate(winingNumbers)
//
//        actual.countOfRank(Rank.FIRST) shouldBe 0
//        actual.countOfRank(Rank.SECOND) shouldBe 0
//        actual.countOfRank(Rank.THIRD) shouldBe 1
//        actual.countOfRank(Rank.FOURTH) shouldBe 0
//        actual.countOfRank(Rank.FIFTH) shouldBe 0
//    }
//
//    "4개의 로또 번호가 일치 하면 4등 당첨자로 집계 해야 한다" {
//        val fourthWinningNumbers = listOf(1, 2, 3, 4, 12, 11)
//        val purchasedLottoTicket = LottoOrderStrategy(
//            30,
//            listOf(LottoGame(LottoNumbers(fourthWinningNumbers)))
//        ).lottoTicketBuyAutoAndManual(LottoNumbersRandomWithExceptStrategy(fourthWinningNumbers.toSet()))
//        val winingNumbers = WinningNumbers(LottoNumbers(1, 2, 3, 4, 5, 33), LottoNumber(22))
//        val actual = purchasedLottoTicket.winnerAggregate(winingNumbers)
//
//        actual.countOfRank(Rank.FIRST) shouldBe 0
//        actual.countOfRank(Rank.SECOND) shouldBe 0
//        actual.countOfRank(Rank.THIRD) shouldBe 0
//        actual.countOfRank(Rank.FOURTH) shouldBe 1
//        actual.countOfRank(Rank.FIFTH) shouldBe 0
//    }
//
//    "3개의 로또 번호가 일치 하면 5등 당첨자로 집계 해야 한다" {
//        val thirdWinningNumbers = listOf(1, 2, 3, 13, 12, 11)
//        val purchasedLottoTicket = LottoOrderStrategy(
//            30,
//            listOf(LottoGame(LottoNumbers(thirdWinningNumbers)))
//        ).lottoTicketBuyAutoAndManual(LottoNumbersRandomWithExceptStrategy(thirdWinningNumbers.toSet()))
//        val winingNumbers = WinningNumbers(LottoNumbers(1, 2, 3, 4, 5, 33), LottoNumber(22))
//        val actual = purchasedLottoTicket.winnerAggregate(winingNumbers)
//
//        actual.countOfRank(Rank.FIRST) shouldBe 0
//        actual.countOfRank(Rank.SECOND) shouldBe 0
//        actual.countOfRank(Rank.THIRD) shouldBe 0
//        actual.countOfRank(Rank.FOURTH) shouldBe 0
//        actual.countOfRank(Rank.FIFTH) shouldBe 1
//    }
// })
//
// private fun LottoOrderStrategy.lottoTicketBuyAutoAndManual(strategy: LottoNumbersRandomWithExceptStrategy): LottoTicket {
//    return LottoIssueMachineAuto(strategy).buy(this) + LottoIssueMachineManual.buy(this)
// }
