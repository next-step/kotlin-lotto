package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.extension.lotto
import lotto.domain.extension.lottoNumbers
import lotto.domain.extension.lottos

class LottosSpec : DescribeSpec({
    describe("로또 개수 검증") {
        context("로또 목록이 주어지면") {
            it("로또 개수를 반환할 수 있다.") {
                val lottos = lottos(Lotto(type = LottoType.AUTO), Lotto(type = LottoType.AUTO), Lotto(type = LottoType.AUTO))

                lottos.lottoQuantity.value shouldBe 3
            }
        }
    }

    describe("로또 구매 비용 검증") {
        context("로또 목록이 주어지면") {
            it("로또 비용을 반환할 수 있다.") {
                val lottos = lottos(Lotto(type = LottoType.AUTO), Lotto(type = LottoType.AUTO), Lotto(type = LottoType.AUTO))

                lottos.totalCost.value shouldBe 3000
            }
        }
    }

    describe("(로또 결과) 각 등수의 당첨 횟수 계산 검증") {
        val winningLotto = WinningLotto(lottoNumbers(1, 2, 3, 4, 5, 6), LottoNumber(7))

        context("1등짜리 로또를 1개 갖고 있는 경우") {
            val lottos = lottos(lotto(1, 2, 3, 4, 5, 6))
            val lottosResult = lottos.calculateResults(winningLotto)

            it("1등 당첨 횟수는 1이다.") {
                lottosResult.getWinningResultsCount(LottoRank.FIRST) shouldBe 1
            }
            it("2등 당첨 횟수는 0이다.") {
                lottosResult.getWinningResultsCount(LottoRank.SECOND) shouldBe 0
            }
            it("3등 당첨 횟수는 0이다.") {
                lottosResult.getWinningResultsCount(LottoRank.THIRD) shouldBe 0
            }
            it("4등 당첨 횟수는 0이다.") {
                lottosResult.getWinningResultsCount(LottoRank.FOURTH) shouldBe 0
            }
            it("5등 당첨 횟수는 0이다.") {
                lottosResult.getWinningResultsCount(LottoRank.FIFTH) shouldBe 0
            }
        }

        context("1등짜리 로또를 2개 갖고 있는 경우") {
            val lottos = lottos(lotto(1, 2, 3, 4, 5, 6), lotto(1, 2, 3, 4, 5, 6))

            it("1등 당첨 횟수는 2이다.") {
                val lottosResult = lottos.calculateResults(winningLotto)

                lottosResult.getWinningResultsCount(LottoRank.FIRST) shouldBe 2
            }
        }

        context("1등짜리 로또를 1개, 2등짜리 로또를 1개 갖고 있는 경우") {
            val lottos = lottos(lotto(1, 2, 3, 4, 5, 6), lotto(1, 2, 3, 4, 5, 7))

            it("1등 당첨 횟수는 1이다.") {
                val lottosResult = lottos.calculateResults(winningLotto)

                lottosResult.getWinningResultsCount(LottoRank.FIRST) shouldBe 1
            }
            it("2등 당첨 횟수는 1이다.") {
                val lottosResult = lottos.calculateResults(winningLotto)

                lottosResult.getWinningResultsCount(LottoRank.SECOND) shouldBe 1
            }
            it("3등 당첨 횟수는 0이다.") {
                val lottosResult = lottos.calculateResults(winningLotto)

                lottosResult.getWinningResultsCount(LottoRank.THIRD) shouldBe 0
            }
            it("4등 당첨 횟수는 0이다.") {
                val lottosResult = lottos.calculateResults(winningLotto)

                lottosResult.getWinningResultsCount(LottoRank.FOURTH) shouldBe 0
            }
            it("5등 당첨 횟수는 0이다.") {
                val lottosResult = lottos.calculateResults(winningLotto)

                lottosResult.getWinningResultsCount(LottoRank.FIFTH) shouldBe 0
            }
        }
    }

    describe("더하기 연산 검증") {
        context("두 개의 로또 목록을 더하기 연산하면") {
            val lottos1 = lottos(Lotto(type = LottoType.AUTO), Lotto(type = LottoType.AUTO))
            val lottos2 = lottos(Lotto(type = LottoType.AUTO), Lotto(type = LottoType.AUTO))

            it("로또 목록이 합쳐진다.") {
                val lottos = lottos1 + lottos2

                lottos.lottoQuantity.value shouldBe 4
            }
        }
    }
})
