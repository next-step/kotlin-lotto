package lotto.domain

import io.kotest.assertions.assertSoftly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import lotto.vo.Money

class LottoRanksTest : DescribeSpec({

    describe("count") {
        context("당첨 결과 별 수를 구할 수 있다") {
            it("1등 1개, 2등 1개, 3등 1개, 4등 2개, 미 당첨 1개") {
                val lottoRanks = LottoRanks(
                    listOf(
                        LottoRank.FIRST,
                        LottoRank.SECOND,
                        LottoRank.THIRD,
                        LottoRank.FOURTH,
                        LottoRank.FOURTH,
                        LottoRank.NOTHING,
                    )
                )
                val countByLottoRanks = lottoRanks.count()
                assertSoftly {
                    countByLottoRanks[LottoRank.FIRST] shouldBe 1
                    countByLottoRanks[LottoRank.SECOND] shouldBe 1
                    countByLottoRanks[LottoRank.THIRD] shouldBe 1
                    countByLottoRanks[LottoRank.FOURTH] shouldBe 2
                    countByLottoRanks[LottoRank.NOTHING] shouldBe 1
                }
            }
        }
    }

    describe("profitRate") {
        context("당첨 결과와 구매 금액이 주어졌을 때") {
            it("당첨 금액의 수익률(소수점 2자리, 반올림)을 구할 수 있다") {
                val lottoRanks = LottoRanks(listOf(LottoRank.FIFTH, LottoRank.NOTHING)) // 5_000원
                listOf(
                    Money.of(1_000) to "5.00".toBigDecimal(),
                    Money.of(2_000) to "2.50".toBigDecimal(),
                    Money.of(3_000) to "1.67".toBigDecimal(),
                    Money.of(4_000) to "1.25".toBigDecimal(),
                ).forAll { (buyingAmount, profitRate) ->
                    lottoRanks.profitRate(buyingAmount) shouldBe profitRate
                }
            }
        }
    }
})
