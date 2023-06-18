package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottosResultSpec : DescribeSpec({
    describe("수익률 검증") {
        context("로또 구입 비용이 5000원이고 로또 당첨 금액이 5000원이면") {
            val lottosResult = LottosResult(
                totalCost = 5000,
                winningResults = mapOf(
                    LottoRank.FIFTH to 1,
                    LottoRank.FOURTH to 0,
                    LottoRank.THIRD to 0,
                    LottoRank.FIRST to 0,
                ),
            )

            it("수익률은 1.0 이다.") {
                lottosResult.returnOfRate shouldBe 1.0
            }
        }

        context("로또 구입 비용이 5000원이고 로또 당첨 금액이 10000원이면") {
            val lottosResult = LottosResult(
                totalCost = 5000,
                winningResults = mapOf(
                    LottoRank.FIFTH to 2,
                    LottoRank.FOURTH to 0,
                    LottoRank.THIRD to 0,
                    LottoRank.FIRST to 0,
                ),
            )

            it("수익률은 2.0 이다.") {
                lottosResult.returnOfRate shouldBe 2.0
            }
        }

        context("로또 구입 비용이 20000원이고 로또 당첨 금액이 5000원이면") {
            val lottosResult = LottosResult(
                totalCost = 20000,
                winningResults = mapOf(
                    LottoRank.FIFTH to 1,
                    LottoRank.FOURTH to 0,
                    LottoRank.THIRD to 0,
                    LottoRank.FIRST to 0,
                ),
            )

            it("수익률은 0.25 이다.") {
                lottosResult.returnOfRate shouldBe 0.25
            }
        }
    }
})
