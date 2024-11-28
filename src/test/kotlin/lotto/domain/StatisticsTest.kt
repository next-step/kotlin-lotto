package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class StatisticsTest : DescribeSpec({
    describe("Statistics test") {
        context("사용자가 구매한 로또 번호가 1등부터 5등까지 당첨 개수를 계산한다") {
            it("1등 3개, 3등 1개") {
                val winningLotto = Lotto.createLotto(listOf(1, 2, 3, 4, 5, 6))
                val userLottos =
                    listOf(
                        Lotto.createLotto(listOf(1, 2, 3, 4, 5, 6)),
                        Lotto.createLotto(listOf(1, 2, 3, 4, 5, 6)),
                        Lotto.createLotto(listOf(1, 2, 3, 4, 5, 6)),
                        Lotto.createLotto(listOf(1, 2, 3, 4, 5, 7)),
                    )

                val actual: List<Statistics> = Statistics.of(userLottos, winningLotto)

                actual[0].rank shouldBe 5
                actual[0].numberOfMatch shouldBe 0

                actual[1].rank shouldBe 4
                actual[1].numberOfMatch shouldBe 0

                actual[2].rank shouldBe 3
                actual[2].numberOfMatch shouldBe 1

                actual[3].rank shouldBe 2
                actual[3].numberOfMatch shouldBe 0

                actual[4].rank shouldBe 1
                actual[4].numberOfMatch shouldBe 3
            }
        }
    }

    describe("earningsRatio test") {
        it("Integer Overflow 발생하지 않도록 헨들링") {
            val statistics = Statistics(rank = 1, numberOfMatch = 2)
            val actual = Statistics.earningsRatio(statistics)
            actual shouldBe 4_000_000_000
        }

        it("3등 3장") {
            val statistics = Statistics(rank = 3, numberOfMatch = 3)
            val actual = Statistics.earningsRatio(statistics)
            actual shouldBe 150000
        }
    }
})
