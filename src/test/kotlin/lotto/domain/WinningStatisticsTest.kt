package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class WinningStatisticsTest : BehaviorSpec({
    given("로또를 5장 구매했을 때") {
        val purchasedLottos = listOf(
            DEFAULT_LOTTO_NUMBERS,
            DEFAULT_LOTTO_NUMBERS,
            DEFAULT_LOTTO_NUMBERS,
            DEFAULT_LOTTO_NUMBERS,
            LottoNumbers(
                listOf(
                    LottoNumber(10),
                    LottoNumber(11),
                    LottoNumber(12),
                    LottoNumber(13),
                    LottoNumber(14),
                    LottoNumber(15),
                )
            )
        )
        val winningLottoNumbers = WinningLottoNumbers(
            LottoNumbers(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(30),
                    LottoNumber(31),
                    LottoNumber(32),
                )
            ),
            LottoNumber(5)
        )
        `when`("4장이 3개의 수가 일치하는 로또들의 통계를 내면") {
            val result = WinningStatistics.create(purchasedLottos, winningLottoNumbers)

            then("당첨 통계의 4등의 카운트는 4이다.") {
                result.getNumberOfMatchCount(Rank.FIFTH) shouldBe 4
            }

            then("당첨금이 없는 수의 개수는 무시하므로 전체 카운트는 4다.") {
                val sum = result.statistics
                    .filter { it.key != Rank.MISS }
                    .values.sum()
                sum shouldBe 4
            }
        }
    }

    given("로또를 14장 구매했을 때") {
        val purchaseAmount = PurchaseAmount(14000)
        val purchasedLotteries = MutableList(purchaseAmount.getNumberOfLotto() - 1) { DEFAULT_LOTTO_NUMBERS }
        purchasedLotteries.add(
            LottoNumbers(
                listOf(
                    LottoNumber(21),
                    LottoNumber(22),
                    LottoNumber(23),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6),
                )
            )
        )
        val winningLottoNumbers = WinningLottoNumbers(
            LottoNumbers(
                listOf(
                    LottoNumber(21),
                    LottoNumber(22),
                    LottoNumber(23),
                    LottoNumber(30),
                    LottoNumber(31),
                    LottoNumber(32),
                )
            ),
            LottoNumber(5)
        )

        `when`("4등 1장만 당첨 됐으면") {
            val result = WinningStatistics.create(purchasedLotteries, winningLottoNumbers)

            then("수익률은 0.35 이다. (소수점 두자리까지 표시)") {
                result.calculateRateOfReturn(purchaseAmount).toString() shouldBe 0.35.toString()
            }
        }
    }
}) {
    companion object {
        private val DEFAULT_LOTTO_NUMBERS =
            LottoNumbers(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6),
                )
            )
    }
}
