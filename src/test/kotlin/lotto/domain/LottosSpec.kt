package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottosSpec : DescribeSpec({
    describe("로또 개수 검증") {
        context("로또 목록이 주어지면") {
            it("로또 개수를 반환할 수 있다.") {
                val lottos = Lottos(listOf(Lotto(), Lotto(), Lotto()))

                lottos.size shouldBe 3
            }
        }
    }

    describe("로또 구매 비용 검증") {
        context("로또 목록이 주어지면") {
            it("로또 비용을 반환할 수 있다.") {
                val lottos = Lottos(listOf(Lotto(), Lotto(), Lotto()))

                lottos.cost shouldBe 3000
            }
        }
    }

    describe("(로또 결과) 각 등수의 당첨 횟수 계산 검증") {
        val winningNumbers = LottoNumbers.of(setOf(1, 2, 3, 4, 5, 6))

        context("1등짜리 로또를 1개 갖고 있는 경우") {
            val lottos = Lottos(listOf(Lotto(LottoNumbers.of(setOf(1, 2, 3, 4, 5, 6)))))

            val lottosResult = lottos.calculateResults(winningNumbers)
            it("1등 당첨 횟수는 1이다.") {
                lottosResult.winningResults[LottoRank.FIRST] shouldBe 1
            }
            it("3등 당첨 횟수는 0이다.") {
                lottosResult.winningResults[LottoRank.THIRD] shouldBe 0
            }
            it("4등 당첨 횟수는 0이다.") {
                lottosResult.winningResults[LottoRank.FOURTH] shouldBe 0
            }
            it("5등 당첨 횟수는 0이다.") {
                lottosResult.winningResults[LottoRank.FIFTH] shouldBe 0
            }
        }

        context("1등짜리 로또를 2개 갖고 있는 경우") {
            val lottos = Lottos(
                listOf(
                    Lotto(LottoNumbers.of(setOf(1, 2, 3, 4, 5, 6))),
                    Lotto(LottoNumbers.of(setOf(1, 2, 3, 4, 5, 6))),
                ),
            )

            it("1등 당첨 횟수는 2이다.") {
                val lottosResult = lottos.calculateResults(winningNumbers)

                lottosResult.winningResults[LottoRank.FIRST] shouldBe 2
            }
        }

        context("1등짜리 로또를 1개, 3등짜리 로또를 1개 갖고 있는 경우") {
            val lottos = Lottos(
                listOf(
                    Lotto(LottoNumbers.of(setOf(1, 2, 3, 4, 5, 6))),
                    Lotto(LottoNumbers.of(setOf(1, 2, 3, 4, 5, 7))),
                ),
            )

            it("1등 당첨 횟수는 1이다.") {
                val lottosResult = lottos.calculateResults(winningNumbers)

                lottosResult.winningResults[LottoRank.FIRST] shouldBe 1
            }
            it("3등 당첨 횟수는 1이다.") {
                val lottosResult = lottos.calculateResults(winningNumbers)

                lottosResult.winningResults[LottoRank.THIRD] shouldBe 1
            }
            it("4등 당첨 횟수는 0이다.") {
                val lottosResult = lottos.calculateResults(winningNumbers)

                lottosResult.winningResults[LottoRank.FOURTH] shouldBe 0
            }
            it("5등 당첨 횟수는 0이다.") {
                val lottosResult = lottos.calculateResults(winningNumbers)

                lottosResult.winningResults[LottoRank.FIFTH] shouldBe 0
            }
        }
    }
})
