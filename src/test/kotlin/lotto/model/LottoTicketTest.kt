package lotto.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.model.strategy.LottoNumberRandomWithExceptStrategy

class LottoTicketTest : StringSpec({

    "6개의 로또 번호가 일치 하면 1등 당첨자로 집계 해야 한다" {
        val firstWinningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val purchasedLottoTicket = LottoPurchaseInfo(
            20,
            listOf(Game(LottoNumbers(firstWinningNumbers)))
        ).lottoTicketAutoAndManual(LottoNumberRandomWithExceptStrategy(firstWinningNumbers.toSet()))
        val winingNumbers = WinningNumbers(LottoNumbers(firstWinningNumbers), LottoNumber(7))
        val actual = purchasedLottoTicket.winnerAggregate(winingNumbers)

        actual.countOfRank(Rank.FIRST) shouldBe 1
        actual.countOfRank(Rank.SECOND) shouldBe 0
        actual.countOfRank(Rank.THIRD) shouldBe 0
        actual.countOfRank(Rank.FOURTH) shouldBe 0
        actual.countOfRank(Rank.FIFTH) shouldBe 0
    }

    "5개의 로또 번호가 일치 하고 보너스볼이 일치하면 2등 당첨자로 집계 해야 한다" {
        val secondWinningNumbers = listOf(1, 2, 3, 4, 5, 22)
        val purchasedLottoTicket = LottoPurchaseInfo(
            30,
            listOf(Game(LottoNumbers(secondWinningNumbers)))
        ).lottoTicketAutoAndManual(LottoNumberRandomWithExceptStrategy(secondWinningNumbers.toSet()))
        val winingNumbers = WinningNumbers(LottoNumbers(1, 2, 3, 4, 5, 33), LottoNumber(22))
        val actual = purchasedLottoTicket.winnerAggregate(winingNumbers)

        actual.countOfRank(Rank.FIRST) shouldBe 0
        actual.countOfRank(Rank.SECOND) shouldBe 1
        actual.countOfRank(Rank.THIRD) shouldBe 0
        actual.countOfRank(Rank.FOURTH) shouldBe 0
        actual.countOfRank(Rank.FIFTH) shouldBe 0
    }
//
//    "5개의 로또 번호가 일치 하고 보너스볼이 일치하지 않으면 3등 당첨자로 집계 해야 한다" {
//        val actual = lottoTicket.winnerAggregate(matched5)
//        actual.countOfRank(Rank.FIRST) shouldBe 0
//        actual.countOfRank(Rank.SECOND) shouldBe 0
//        actual.countOfRank(Rank.THIRD) shouldBe 1
//        actual.countOfRank(Rank.FOURTH) shouldBe 0
//        actual.countOfRank(Rank.FIFTH) shouldBe 0
//    }
//
//    "4개의 로또 번호가 일치 하면 4등 당첨자로 집계 해야 한다" {
//        val actual = lottoTicket.winnerAggregate(matched4)
//        actual.countOfRank(Rank.FIRST) shouldBe 0
//        actual.countOfRank(Rank.SECOND) shouldBe 0
//        actual.countOfRank(Rank.THIRD) shouldBe 0
//        actual.countOfRank(Rank.FOURTH) shouldBe 1
//        actual.countOfRank(Rank.FIFTH) shouldBe 0
//    }
//
//    "3개의 로또 번호가 일치 하면 5등 당첨자로 집계 해야 한다" {
//        val actual = lottoTicket.winnerAggregate(matched3)
//        actual.countOfRank(Rank.FIRST) shouldBe 0
//        actual.countOfRank(Rank.SECOND) shouldBe 0
//        actual.countOfRank(Rank.THIRD) shouldBe 0
//        actual.countOfRank(Rank.FOURTH) shouldBe 0
//        actual.countOfRank(Rank.FIFTH) shouldBe 1
//    }
})

private fun LottoPurchaseInfo.lottoTicketAutoAndManual(strategy: LottoNumberRandomWithExceptStrategy): LottoTicket {
    return this.lottoTicketAuto(strategy) + this.lottoTicketManual()
}
