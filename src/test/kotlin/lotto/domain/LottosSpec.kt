package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottosSpec : DescribeSpec({
    describe("개수") {
        context("로또 목록이 주어지면") {
            it("로또 개수를 반환할 수 있다.") {
                val lottos = Lottos(listOf(Lotto(), Lotto(), Lotto()))

                lottos.size shouldBe 3
            }
        }
    }

    describe("비용") {
        context("로또 목록이 주어지면") {
            it("로또 비용을 반환할 수 있다.") {
                val lottos = Lottos(listOf(Lotto(), Lotto(), Lotto()))

                lottos.cost shouldBe 3000
            }
        }
    }

    describe("로또 결과 계산") {
        context("로또 목록과 당첨 번호가 주어지면") {
            val lottos = Lottos(
                listOf(
                    Lotto(listOf(1, 2, 3, 7, 8, 9)),
                    Lotto(listOf(7, 8, 9, 10, 11, 12)),
                ),
            )

            it("로또 결과를 계산할 수 있다. 당첨 번호 (1, 2, 3, 7, 8, 9))") {
                val winningNumbers = listOf(1, 2, 3, 7, 8, 9)
                val lottoResult = lottos.calculateResult(winningNumbers)

                lottoResult.numberOfFirst shouldBe 1
                lottoResult.numberOfThird shouldBe 0
                lottoResult.numberOfFourth shouldBe 0
                lottoResult.numberOfFifth shouldBe 1
            }

            it("로또 결과를 계산할 수 있다. 당첨 번호 (1, 2, 3, 7, 8, 31)") {
                val winningNumbers = listOf(1, 2, 3, 7, 8, 31)
                val lottoResult = lottos.calculateResult(winningNumbers)

                lottoResult.numberOfFirst shouldBe 0
                lottoResult.numberOfThird shouldBe 1
                lottoResult.numberOfFourth shouldBe 0
                lottoResult.numberOfFifth shouldBe 0
            }

            it("로또 결과를 계산할 수 있다. 당첨 번호 (1, 2, 3, 7, 30, 31)") {
                val winningNumbers = listOf(1, 2, 3, 7, 30, 31)
                val lottoResult = lottos.calculateResult(winningNumbers)

                lottoResult.numberOfFirst shouldBe 0
                lottoResult.numberOfThird shouldBe 0
                lottoResult.numberOfFourth shouldBe 1
                lottoResult.numberOfFifth shouldBe 0
            }

            it("로또 결과를 계산할 수 있다. 당첨 번호 (1, 2, 3, 4, 5, 6)") {
                val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
                val lottoResult = lottos.calculateResult(winningNumbers)

                lottoResult.numberOfFirst shouldBe 0
                lottoResult.numberOfThird shouldBe 0
                lottoResult.numberOfFourth shouldBe 0
                lottoResult.numberOfFifth shouldBe 1
            }
        }
    }
})
