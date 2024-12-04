package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class StatisticsTest : DescribeSpec({
    describe("사용자의 당첨 로또를 집계한다") {
        lateinit var winningLotto: WinningLotto
        beforeTest { winningLotto = WinningLotto(Lotto(1, 2, 3, 4, 5, 6), LottoNumber(10)) }

        context("당첨된 경우") {
            it("1등") {
                val sut = Statistics(winningLotto, listOf(Lotto(1, 2, 3, 4, 5, 6)))
                val actual = sut.groupByLottoRank()
                actual.size shouldBe 1
                actual[0].rank shouldBe 1
                actual[0].count shouldBe 1
            }

            it("5등 여러장 당첨된 경우") {
                val lottos =
                    listOf(
                        Lotto(1, 2, 3, 14, 15, 16),
                        Lotto(11, 12, 13, 4, 5, 6),
                        Lotto(1, 22, 33, 44, 5, 6),
                        Lotto(1, 22, 23, 24, 5, 6),
                    )

                val sut = Statistics(winningLotto, lottos)
                val actual = sut.groupByLottoRank()

                actual.size shouldBe 1
                actual[0].rank shouldBe 5
                actual[0].count shouldBe 4
            }
        }

        context("낙첨인 경우") {
            it("집계하지 않는다") {
                val sut = Statistics(winningLotto, listOf(Lotto(11, 12, 13, 14, 15, 16)))
                val actual = sut.groupByLottoRank()
                actual.size shouldBe 0
            }
        }

        context("전체 로또중에 일부만 당첨된 경우") {
            it("당첨된 로또를 등수 내림차순으로 집계한다") {
                val lottos =
                    listOf(
                        Lotto(1, 22, 33, 44, 5, 6),
                        Lotto(1, 22, 23, 24, 5, 6),
                        Lotto(1, 2, 3, 24, 25, 6),
                        Lotto(1, 2, 3, 4, 15, 16),
                        Lotto(1, 2, 33, 34, 5, 6),
                        Lotto(1, 2, 3, 4, 5, 10),
                        Lotto(1, 2, 3, 4, 5, 6),
                        Lotto(11, 12, 13, 14, 15, 6),
                    )
                        .shuffled()

                val sut = Statistics(winningLotto, lottos)
                val actual = sut.groupByLottoRank()
                println(actual)

                actual.size shouldBe 4
                actual[0].rank shouldBe 5 // crack
                actual[0].count shouldBe 2

                actual[1].rank shouldBe 4
                actual[1].count shouldBe 3

                actual[2].rank shouldBe 2
                actual[2].count shouldBe 1

                actual[3].rank shouldBe 1
                actual[3].count shouldBe 1
            }
        }
    }
})
