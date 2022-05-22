package lotto.domain

import io.kotest.assertions.assertSoftly
import io.kotest.core.spec.style.DescribeSpec
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
                        LottoRank.NOTTING,
                    )
                )
                val countByLottoRanks = lottoRanks.count()
                assertSoftly {
                    countByLottoRanks[LottoRank.FIRST] shouldBe 1
                    countByLottoRanks[LottoRank.SECOND] shouldBe 1
                    countByLottoRanks[LottoRank.THIRD] shouldBe 1
                    countByLottoRanks[LottoRank.FOURTH] shouldBe 2
                    countByLottoRanks[LottoRank.NOTTING] shouldBe 1
                }
            }
        }
    }

    describe("profitRate") {
        context("수익률을 구할 수 있다") {
            it("구매금액 2_000, 당첨금액 5_000") {
                val lottoRanks = LottoRanks(
                    listOf(
                        LottoRank.FOURTH,
                        LottoRank.NOTTING,
                    )
                )

                lottoRanks.profitRate(Money.of(2_000)) shouldBe "2.50".toBigDecimal()
            }

            it("구매금액 5_000, 당첨금액 1_550_000") {
                val lottoRanks = LottoRanks(
                    listOf(
                        LottoRank.SECOND,
                        LottoRank.THIRD,
                        LottoRank.NOTTING,
                        LottoRank.NOTTING,
                        LottoRank.NOTTING,
                    )
                )

                lottoRanks.profitRate(Money.of(5_000)) shouldBe "310.00".toBigDecimal()
            }
        }
    }
})
