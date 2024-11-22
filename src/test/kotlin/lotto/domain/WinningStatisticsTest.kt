package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.math.BigDecimal
import java.math.RoundingMode

class WinningStatisticsTest : BehaviorSpec({
    Given("구입한 로또와 당첨 번호가 주어졌을 때") {
        val winningLotto = WinningLotto(Lotto(setOf(1, 2, 3, 4, 5, 6)))
        val purchasedLottos =
            PurchasedLottos(
                listOf(
                    Lotto(setOf(1, 2, 3, 4, 5, 6)),
                    Lotto(setOf(1, 2, 3, 4, 7, 8)),
                    Lotto(setOf(1, 2, 3, 7, 8, 9)),
                    Lotto(setOf(7, 8, 9, 10, 11, 12)),
                ),
            )
        val winningStatistics = WinningStatistics(winningLotto)

        When("통계를 계산하면") {
            winningStatistics.calculateStatistics(purchasedLottos)

            Then("각 Rank의 매칭 개수가 올바르게 계산된다") {
                winningStatistics.count(Rank.SIX) shouldBe 1
                winningStatistics.count(Rank.FOUR) shouldBe 1
                winningStatistics.count(Rank.THREE) shouldBe 1
                winningStatistics.count(Rank.MISS) shouldBe 1
            }

            Then("총 상금이 올바르게 계산된다") {
                winningStatistics.totalPrize() shouldBe BigDecimal("2000055000")
            }
        }
    }

    Given("구입한 로또 개수와 당첨 번호가 주어졌을 때") {
        val winningLotto = WinningLotto(Lotto(setOf(1, 2, 3, 4, 5, 6)))
        val purchasedLottos =
            PurchasedLottos(
                listOf(
                    Lotto(setOf(1, 2, 3, 7, 15, 16)),
                    Lotto(setOf(1, 2, 3, 14, 17, 18)),
                    Lotto(setOf(11, 21, 31, 7, 8, 9)),
                    Lotto(setOf(7, 8, 9, 10, 11, 12)),
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
