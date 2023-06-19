package lotto.domain.analysis

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto.domain.lottonumber.LottoNumber
import lotto.domain.lottonumber.LottoNumbers
import lotto.domain.lottonumber.WinLottoNumbers
import lotto.domain.money.Money
import lotto.domain.money.sum
import lotto.domain.shop.LottoGame
import math.PositiveNumber

class RealLottoResultAnalystTest : BehaviorSpec({

    Given("로또 구매 내역과 지난주 당첨 번호가 주어 졌을 때") {

        fun makeLottoNumbers(vararg lottoNumbers: Int): LottoNumbers {
            return LottoNumbers(lottoNumbers.map { LottoNumber(it) })
        }

        fun makeLottoGame(vararg lottoNumbers: Int): LottoGame {
            return LottoGame(makeLottoNumbers(*lottoNumbers))
        }

        Then("내림차순 정렬 된 당첨 등급 목록을 반환한다") {
            val request = LottoAnalysisRequest(
                lottoGames = listOf(makeLottoGame(1, 2, 3, 4, 5, 6)),
                lottoPurchaseAmount = PositiveNumber(1_000),
                lastWeekWinLottoNumbers = WinLottoNumbers(
                    makeLottoNumbers(1, 2, 3, 4, 5, 6),
                    LottoNumber(40),
                )
            )
            val result = LottoResultAnalyst().analyze(request)
            val winRanks = result.lottoWinRankAnalysisResults.map { it.lottoWinRank }
            winRanks shouldBe LottoWinRank.values().sortedDescending()
        }

        Then("당첨된 등급은 당첨된 등급 개수를 반환한다") {
            val request = LottoAnalysisRequest(
                lottoGames = listOf(
                    makeLottoGame(1, 2, 3, 4, 5, 6),
                    makeLottoGame(1, 2, 3, 4, 5, 7),
                    makeLottoGame(1, 2, 3, 4, 7, 8),
                    makeLottoGame(1, 2, 3, 7, 8, 9),
                ),
                lottoPurchaseAmount = PositiveNumber(4_000),
                lastWeekWinLottoNumbers = WinLottoNumbers(
                    makeLottoNumbers(1, 2, 3, 4, 5, 6),
                    LottoNumber(40),
                )
            )
            val result = LottoResultAnalyst().analyze(request)
            val winRankCounts = result.lottoWinRankAnalysisResults.map { it.ranksCount }
            winRankCounts.all { it.value == 1 } shouldBe true
        }

        Then("당첨 안된 등급은 당첨 개수를 0으로 반환한다") {
            val request = LottoAnalysisRequest(
                lottoGames = listOf(makeLottoGame(10, 11, 12, 13, 14, 15)),
                lottoPurchaseAmount = PositiveNumber(1_000),
                lastWeekWinLottoNumbers = WinLottoNumbers(
                    makeLottoNumbers(1, 2, 3, 4, 5, 6),
                    LottoNumber(40),
                )
            )
            val result = LottoResultAnalyst().analyze(request)
            val winRankCounts = result.lottoWinRankAnalysisResults.map { it.ranksCount }
            winRankCounts shouldBe LottoWinRank.values().sortedDescending().map { PositiveNumber(0) }
        }

        forAll(
            row(
                listOf(makeLottoGame(10, 11, 12, 13, 14, 15)),
                WinLottoNumbers(
                    makeLottoNumbers(1, 2, 3, 4, 5, 6),
                    LottoNumber(40),
                ),
                Revenue(
                    totalCost = Money(1_000),
                    totalRevenue = Money(0),
                )
            ),
            row(
                listOf(makeLottoGame(1, 2, 3, 4, 5, 6)),
                WinLottoNumbers(
                    makeLottoNumbers(1, 2, 3, 4, 5, 6),
                    LottoNumber(40),
                ),
                Revenue(
                    totalCost = Money(1_000),
                    totalRevenue = LottoWinRank.FIRST.winAmount,
                )
            ),
            row(
                listOf(
                    makeLottoGame(1, 2, 3, 4, 5, 6),
                    makeLottoGame(1, 2, 3, 4, 5, 7),
                    makeLottoGame(1, 2, 3, 4, 7, 8),
                    makeLottoGame(1, 2, 3, 7, 8, 9),
                ),
                WinLottoNumbers(
                    makeLottoNumbers(1, 2, 3, 4, 5, 6),
                    LottoNumber(40),
                ),
                Revenue(
                    totalCost = Money(4_000),
                    totalRevenue = LottoWinRank.values().map { it.winAmount }.sum(),
                )
            ),
        ) { lottoGames, lastWeekWinLottoNumbers, expectedRevenue ->
            Then("수익률을 반환한다") {
                val request = LottoAnalysisRequest(
                    lottoGames = lottoGames,
                    lottoPurchaseAmount = PositiveNumber(lottoGames.size * 1_000),
                    lastWeekWinLottoNumbers = lastWeekWinLottoNumbers
                )
                val result = LottoResultAnalyst().analyze(request)
                result.revenue shouldBe expectedRevenue
            }
        }
    }
})
