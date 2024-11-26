package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.math.BigDecimal
import java.math.RoundingMode

class WinningStatisticsTest : BehaviorSpec({
    Given("구입한 로또와 당첨 번호가 주어졌을 때") {
        val validWinningLotto = Lotto.from(setOf(1, 2, 3, 4, 5, 6))
        val winningLotto = WinningLotto(validWinningLotto, BonusNumber.create(7, validWinningLotto))
        val purchasedLottos =
            PurchasedLottos(
                listOf(
                    Lotto.from(setOf(1, 2, 3, 4, 5, 6)),
                    Lotto.from(setOf(1, 2, 3, 4, 7, 8)),
                    Lotto.from(setOf(1, 2, 3, 7, 8, 9)),
                    Lotto.from(setOf(7, 8, 9, 10, 11, 12)),
                ),
            )
        val winningStatistics = WinningStatistics(winningLotto)

        When("통계를 계산하면") {
            winningStatistics.calculateStatistics(purchasedLottos)

            Then("각 Rank의 매칭 개수가 올바르게 계산된다") {
                winningStatistics.count(Rank.FIRST) shouldBe MatchedCount(1)
                winningStatistics.count(Rank.FOURTH) shouldBe MatchedCount(1)
                winningStatistics.count(Rank.FIFTH) shouldBe MatchedCount(1)
                winningStatistics.count(Rank.MISS) shouldBe MatchedCount(1)
            }

            Then("총 상금이 올바르게 계산된다") {
                winningStatistics.totalPrize() shouldBe BigDecimal("2000055000")
            }
        }
    }

    Given("구입한 로또 개수와 당첨 번호가 주어졌을 때") {
        val validWinningLotto = Lotto.from(setOf(1, 2, 3, 4, 5, 6))
        val winningLotto = WinningLotto(validWinningLotto, BonusNumber.create(7, validWinningLotto))
        val purchasedLottos =
            PurchasedLottos(
                listOf(
                    Lotto.from(setOf(1, 2, 3, 7, 15, 16)),
                    Lotto.from(setOf(1, 2, 3, 14, 17, 18)),
                    Lotto.from(setOf(11, 21, 31, 7, 8, 9)),
                    Lotto.from(setOf(7, 8, 9, 10, 11, 12)),
                ),
            )
        val winningStatistics =
            WinningStatistics(winningLotto)
                .calculateStatistics(purchasedLottos)

        When("구입 금액 대비 수익률을 계산하면") {
            val profitRate = winningStatistics.profitRate(purchasedLottos.lottos.size)

            Then("수익률이 올바르게 계산된다") {
                profitRate shouldBe 2.50.toBigDecimal().setScale(2, RoundingMode.HALF_UP)
            }
        }
    }
})