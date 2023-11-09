package lotto.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RoundTest : StringSpec({

    val game1: Game = Game(LottoNumbers(1, 2, 3, 4, 5, 6))
    val game2: Game = Game(LottoNumbers(7, 8, 9, 10, 11, 12))
    val game3: Game = Game(LottoNumbers(1, 11, 21, 31, 41, 31, 22))
    val game4: Game = Game(LottoNumbers(2, 22, 32, 42, 43, 44))
    val round: Round = Round(listOf(game1, game2, game3, game4))

    val matched6: WinningNumbers = WinningNumbers(LottoNumbers(1, 2, 3, 4, 5, 6), LottoNumber(22))
    val matched5: WinningNumbers = WinningNumbers(LottoNumbers(2, 3, 4, 5, 6, 37), LottoNumber(22))
    val matched4: WinningNumbers = WinningNumbers(LottoNumbers(3, 4, 5, 6, 37, 38), LottoNumber(22))
    val matched3: WinningNumbers = WinningNumbers(LottoNumbers(4, 5, 6, 37, 38, 39), LottoNumber(22))

    "6개의 로또 번호가 일치 하면 1등 당첨자로 집계 해야 한다" {
        val actual = round.winnerAggregate(matched6)
        actual.countOfRank(Rank.FIRST) shouldBe 1
        actual.countOfRank(Rank.SECOND) shouldBe 0
        actual.countOfRank(Rank.THIRD) shouldBe 0
        actual.countOfRank(Rank.FOURTH) shouldBe 0
        actual.countOfRank(Rank.FIFTH) shouldBe 0
    }

    "5개의 로또 번호가 일치 하고 보너스볼이 일치하면 2등 당첨자로 집계 해야 한다" {
        val actual = round.winnerAggregate(matched5)
        actual.countOfRank(Rank.FIRST) shouldBe 0
        actual.countOfRank(Rank.SECOND) shouldBe 1
        actual.countOfRank(Rank.THIRD) shouldBe 0
        actual.countOfRank(Rank.FOURTH) shouldBe 0
        actual.countOfRank(Rank.FIFTH) shouldBe 0
    }

    "5개의 로또 번호가 일치 하고 보너스볼이 일치하지 않으면 3등 당첨자로 집계 해야 한다" {
        val actual = round.winnerAggregate(matched5)
        actual.countOfRank(Rank.FIRST) shouldBe 0
        actual.countOfRank(Rank.SECOND) shouldBe 0
        actual.countOfRank(Rank.THIRD) shouldBe 1
        actual.countOfRank(Rank.FOURTH) shouldBe 0
        actual.countOfRank(Rank.FIFTH) shouldBe 0
    }

    "4개의 로또 번호가 일치 하면 4등 당첨자로 집계 해야 한다" {
        val actual = round.winnerAggregate(matched4)
        actual.countOfRank(Rank.FIRST) shouldBe 0
        actual.countOfRank(Rank.SECOND) shouldBe 0
        actual.countOfRank(Rank.THIRD) shouldBe 0
        actual.countOfRank(Rank.FOURTH) shouldBe 1
        actual.countOfRank(Rank.FIFTH) shouldBe 0
    }

    "3개의 로또 번호가 일치 하면 5등 당첨자로 집계 해야 한다" {
        val actual = round.winnerAggregate(matched3)
        actual.countOfRank(Rank.FIRST) shouldBe 0
        actual.countOfRank(Rank.SECOND) shouldBe 0
        actual.countOfRank(Rank.THIRD) shouldBe 0
        actual.countOfRank(Rank.FOURTH) shouldBe 0
        actual.countOfRank(Rank.FIFTH) shouldBe 1
    }
})
