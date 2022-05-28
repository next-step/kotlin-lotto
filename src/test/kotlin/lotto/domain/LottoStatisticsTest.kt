package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

class LottoStatisticsTest : BehaviorSpec({

    Given("로또 통계는") {
        When("LottoMatch와 Count가 입렵되면") {
            val statistics = LottoStatistics(
                mapOf(
                    LottoMatch.ZERO to 1,
                    LottoMatch.ONE to 0,
                    LottoMatch.TWO to 1,
                    LottoMatch.THREE to 0,
                    LottoMatch.FOUR to 1,
                    LottoMatch.FIVE to 0,
                    LottoMatch.FIVE_WITH_BONUS to 1,
                    LottoMatch.SIX to 0
                )
            )

            Then("0개 일치 개수를 반환한다") {
                statistics[LottoMatch.ZERO] shouldBe 1
            }

            Then("1개 일치 개수를 반환한다") {
                statistics[LottoMatch.ONE] shouldBe 0
            }

            Then("2개 일치 개수를 반환한다") {
                statistics[LottoMatch.TWO] shouldBe 1
            }

            Then("3개 일치 개수를 반환한다") {
                statistics[LottoMatch.THREE] shouldBe 0
            }

            Then("4개 일치 개수를 반환한다") {
                statistics[LottoMatch.FOUR] shouldBe 1
            }

            Then("5개 일치 개수를 반환한다") {
                statistics[LottoMatch.FIVE] shouldBe 0
            }

            Then("5개 + 보너스 번호 일치 개수를 반환한다") {
                statistics[LottoMatch.FIVE_WITH_BONUS] shouldBe 1
            }

            Then("6개 일치 개수를 반환한다") {
                statistics[LottoMatch.SIX] shouldBe 0
            }

            Then("총 수익율을 반환한다") {
                statistics.getProfit() shouldBe BigDecimal("7512.5")
            }
        }
    }
})
