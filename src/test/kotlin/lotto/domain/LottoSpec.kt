package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoSpec : DescribeSpec({
    describe("로또 생성 검증") {
        context("로또를 생성하면") {
            val lotto = Lotto()

            it("로또는 6개의 번호를 갖고있다.") {
                lotto.numbers.values.size shouldBe 6
            }
        }
    }

    describe("로또 가격 검증") {
        it("로또의 가격은 1000원이다.") {
            Lotto.PRICE shouldBe 1000
        }
    }

    describe("로또 결과 계산") {
        val numbers = LottoNumbers.of(setOf(1, 2, 3, 4, 5, 6))

        context("로또 번호와 당첨 번호가 6개 일치하면") {
            val lotto = Lotto(LottoNumbers.of(setOf(1, 2, 3, 4, 5, 6)))

            it("1등이다.") {
                val lottoPrize = lotto.calculateResult(numbers)

                lottoPrize shouldBe LottoRank.FIRST
            }
        }

        context("로또 번호와 당첨 번호가 5개 일치하면") {
            val lotto = Lotto(LottoNumbers.of(setOf(1, 2, 3, 4, 5, 7)))

            it("3등이다.") {
                val lottoPrize = lotto.calculateResult(numbers)

                lottoPrize shouldBe LottoRank.THIRD
            }
        }

        context("로또 번호와 당첨 번호가 4개 일치하면") {
            val lotto = Lotto(LottoNumbers.of(setOf(1, 2, 3, 4, 7, 8)))

            it("4등이다.") {
                val lottoPrize = lotto.calculateResult(numbers)

                lottoPrize shouldBe LottoRank.FOURTH
            }
        }

        context("로또 번호와 당첨 번호가 3개 일치하면") {
            val lotto = Lotto(LottoNumbers.of(setOf(1, 2, 3, 7, 8, 9)))

            it("5등이다.") {
                val lottoPrize = lotto.calculateResult(numbers)

                lottoPrize shouldBe LottoRank.FIFTH
            }
        }
    }
})
