package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class WinningStatisticsTest : BehaviorSpec({
    given("로또를 5장 구매했을 때") {
        val purchasedLottoNumbers = lottoNumbersListOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 6),
            listOf(10, 20, 30, 40, 15, 16),
        )
        val winningLottoNumbersNumbersNumbers = winningLottoNumberOf(1, 2, 3, 30, 31, 32, 5)

        `when`("4장이 3개의 수가 일치하는 로또들의 통계를 내면") {
            val result = WinningStatistics.create(purchasedLottoNumbers, winningLottoNumbersNumbersNumbers)

            then("당첨 통계의 4등의 카운트는 4이다.") {
                result.getNumberOfMatchCount(Rank.FIFTH) shouldBe 4
            }
        }
    }

    given("로또를 14장 구매했을 때") {
        val unMatchingLottoNumbers = lottoNumberOf(1, 2, 3, 4, 5, 6)
        val matchingLottoNumbers = lottoNumberOf(21, 22, 23, 4, 5, 6)
        val purchasedLottos = List(13) { unMatchingLottoNumbers } + matchingLottoNumbers
        val winningLottoNumbersNumbersNumbers = winningLottoNumberOf(21, 22, 23, 30, 31, 32, 5)

        `when`("4등 1장만 당첨 됐으면") {
            val result = WinningStatistics.create(purchasedLottos, winningLottoNumbersNumbersNumbers)

            then("수익률은 0.35 이다. (소수점 두자리까지 표시)") {
                result.calculateRateOfReturn(PurchaseAmount(14000)).toString() shouldBe 0.35.toString()
            }
        }
    }
})
