package lotto.domain.analysis

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.lottonumber.LottoNumber
import lotto.domain.lottonumber.LottoNumbers
import lotto.domain.lottonumber.WinLottoNumbers
import lotto.domain.shop.LottoGame
import math.PositiveNumber

class RealLottoResultAnalystTest : BehaviorSpec({

    fun makeLottoNumbers(vararg lottoNumbers: Int): LottoNumbers {
        return LottoNumbers(lottoNumbers.map { LottoNumber(it) })
    }

    fun makeLottoGame(vararg lottoNumbers: Int): LottoGame {
        return LottoGame(makeLottoNumbers(*lottoNumbers))
    }

    Given("당첨된 등급 목록은") {
        val request = LottoAnalysisRequest(
            lottoGames = listOf(makeLottoGame(1, 2, 3, 4, 5, 6)),
            lottoPurchaseAmount = PositiveNumber(1_000),
            lastWeekWinLottoNumbers = WinLottoNumbers(
                makeLottoNumbers(1, 2, 3, 4, 5, 6),
                LottoNumber(40),
            )
        )
        val winRanks = LottoResultAnalyst().analyze(request)
            .lottoWinRankAnalysisResults
            .map { it.lottoWinRank }
        Then("내림차순 정렬 되어있다") {
            winRanks shouldBe LottoWinRank.values().sortedDescending()
        }
    }

    Given("1개의 로또가 1등에 당첨 되었다면") {
        val request = LottoAnalysisRequest(
            lottoGames = listOf(makeLottoGame(1, 2, 3, 4, 5, 6)),
            lottoPurchaseAmount = PositiveNumber(1_000),
            lastWeekWinLottoNumbers = WinLottoNumbers(
                makeLottoNumbers(1, 2, 3, 4, 5, 6),
                LottoNumber(40),
            )
        )
        val result = LottoResultAnalyst().analyze(request)

        Then("당첨된 1등 로또는 1개이다") {
            result.rankCounts(LottoWinRank.FIRST) shouldBe PositiveNumber(1)
        }

        Then("수익률은 2,000,000이다") {
            result.revenue.rateOfReturn shouldBe 2_000_000
        }
    }

    Given("1개의 로또가 2등에 당첨 되었다면") {
        val request = LottoAnalysisRequest(
            lottoGames = listOf(makeLottoGame(1, 2, 3, 4, 5, 6)),
            lottoPurchaseAmount = PositiveNumber(1_000),
            lastWeekWinLottoNumbers = WinLottoNumbers(
                makeLottoNumbers(1, 2, 3, 4, 5, 7),
                LottoNumber(6),
            )
        )
        val result = LottoResultAnalyst().analyze(request)

        Then("당첨된 2등 로또는 1개이다") {
            result.rankCounts(LottoWinRank.SECOND) shouldBe PositiveNumber(1)
        }

        Then("수익률은 30,000이다") {
            result.revenue.rateOfReturn shouldBe 30_000
        }
    }

    Given("1개의 로또가 3등에 당첨 되었다면") {
        val request = LottoAnalysisRequest(
            lottoGames = listOf(makeLottoGame(1, 2, 3, 4, 5, 6)),
            lottoPurchaseAmount = PositiveNumber(1_000),
            lastWeekWinLottoNumbers = WinLottoNumbers(
                makeLottoNumbers(1, 2, 3, 4, 5, 7),
                LottoNumber(40),
            )
        )
        val result = LottoResultAnalyst().analyze(request)

        Then("당첨된 3등 로또는 1개이다") {
            result.rankCounts(LottoWinRank.THIRD) shouldBe PositiveNumber(1)
        }

        Then("수익률은 15,000이다") {
            result.revenue.rateOfReturn shouldBe 1_500
        }
    }

    Given("1개의 로또가 4등에 당첨 되었다면") {
        val request = LottoAnalysisRequest(
            lottoGames = listOf(makeLottoGame(1, 2, 3, 4, 5, 6)),
            lottoPurchaseAmount = PositiveNumber(1_000),
            lastWeekWinLottoNumbers = WinLottoNumbers(
                makeLottoNumbers(1, 2, 3, 4, 7, 8),
                LottoNumber(40),
            )
        )
        val result = LottoResultAnalyst().analyze(request)

        Then("당첨된 4등 로또는 1개이다") {
            result.rankCounts(LottoWinRank.FOURTH) shouldBe PositiveNumber(1)
        }

        Then("수익률은 50이다") {
            result.revenue.rateOfReturn shouldBe 50
        }
    }

    Given("1개의 로또가 5등에 당첨 되었다면") {
        val request = LottoAnalysisRequest(
            lottoGames = listOf(makeLottoGame(1, 2, 3, 4, 5, 6)),
            lottoPurchaseAmount = PositiveNumber(1_000),
            lastWeekWinLottoNumbers = WinLottoNumbers(
                makeLottoNumbers(1, 2, 3, 7, 8, 9),
                LottoNumber(40),
            )
        )
        val result = LottoResultAnalyst().analyze(request)

        Then("당첨된 5등 로또는 1개이다") {
            result.rankCounts(LottoWinRank.FIFTH) shouldBe PositiveNumber(1)
        }

        Then("수익률은 5이다") {
            result.revenue.rateOfReturn shouldBe 5
        }
    }

    Given("1개의 로또가 당첨되지 않았다면") {
        val request = LottoAnalysisRequest(
            lottoGames = listOf(makeLottoGame(1, 2, 3, 4, 5, 6)),
            lottoPurchaseAmount = PositiveNumber(1_000),
            lastWeekWinLottoNumbers = WinLottoNumbers(
                makeLottoNumbers(10, 11, 12, 13, 14, 15),
                LottoNumber(40),
            )
        )
        val result = LottoResultAnalyst().analyze(request)

        Then("모든 당첨 로또는 0개이다") {
            LottoWinRank.values().forEach {
                result.rankCounts(it) shouldBe PositiveNumber(0)
            }
        }
        Then("수익률은 0이다") {
            result.revenue.rateOfReturn shouldBe 0
        }
    }

    Given("5개의 로또가") {
        val lottoGames = listOf(
            makeLottoGame(1, 2, 3, 4, 5, 6),
            makeLottoGame(1, 2, 3, 4, 5, 40),
            makeLottoGame(1, 2, 3, 4, 5, 7),
            makeLottoGame(1, 2, 3, 4, 7, 8),
            makeLottoGame(1, 2, 3, 7, 8, 9),
        )
        val lottoPurchaseAmount = PositiveNumber(5_000)

        When("1, 2, 3, 4, 5등에 당첨 되었다면") {
            val winLottoNumbers = WinLottoNumbers(
                makeLottoNumbers(1, 2, 3, 4, 5, 6),
                LottoNumber(40),
            )
            val request = LottoAnalysisRequest(lottoGames, lottoPurchaseAmount, winLottoNumbers)
            val result = LottoResultAnalyst().analyze(request)
            Then("모든 등수의 당첨 개수는 1개이다") {
                val winRankCounts = result.lottoWinRankAnalysisResults.map { it.ranksCount }
                winRankCounts.all { it.value == 1 } shouldBe true
            }
            Then("수익률은 406,311이다") {
                result.revenue.rateOfReturn shouldBe 406311
            }
        }
    }
})
