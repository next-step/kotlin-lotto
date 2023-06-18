package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoSpec : DescribeSpec({
    describe("로또 정상 생성 검증") {
        context("로또를 생성하면") {
            val lotto = Lotto()

            it("로또는 6개의 번호를 갖고있다.") {
                lotto.numbers.size shouldBe 6
            }

            it("로또의 번호는 1 이상 45 이하이다.") {
                lotto.numbers.forEach { number ->
                    (number in 1..45) shouldBe true
                }
            }
        }
    }

    describe("로또 번호 개수(6개) 검증") {
        context("로또 번호가 6개 보다 작은 경우") {
            it("예외가 발생한다.") {
                val numbers = setOf(1, 2, 3, 4, 5)
                shouldThrow<IllegalArgumentException> {
                    Lotto(numbers)
                }
            }
        }

        context("로또 번호가 6개 보다 큰 경우") {
            it("예외가 발생한다.") {
                val numbers = setOf(1, 2, 3, 4, 5)
                shouldThrow<IllegalArgumentException> {
                    Lotto(numbers)
                }
            }
        }
    }

    describe("로또 번호 중복 검증") {
        context("중복된 번호를 포함하면") {
            it("예외가 발생한다.") {
                val numbers = setOf(1, 2, 3, 4, 5, 5)
                shouldThrow<IllegalArgumentException> {
                    Lotto(numbers)
                }
            }
        }
    }

    describe("로또 번호 범위(1..45) 검증") {
        context("로또의 번호가 1보다 작으면") {
            it("예외가 발생한다.") {
                val numbers = setOf(0, 2, 3, 4, 5, 6)
                shouldThrow<IllegalArgumentException> {
                    Lotto(numbers)
                }
            }
        }

        context("로또의 번호가 45보다 크면") {
            it("예외가 발생한다.") {
                val numbers = setOf(1, 2, 3, 4, 5, 46)
                shouldThrow<IllegalArgumentException> {
                    Lotto(numbers)
                }
            }
        }
    }

    describe("로또 결과 계산") {
        context("로또 번호와 당첨 번호가 6개 일치하면") {
            val numbers = setOf(1, 2, 3, 4, 5, 6)
            val lotto = Lotto(setOf(1, 2, 3, 4, 5, 6))

            it("1등이다.") {
                val lottoPrize = lotto.calculateResult(numbers)

                lottoPrize shouldBe LottoRank.FIRST
            }
        }

        context("로또 번호와 당첨 번호가 5개 일치하면") {
            val numbers = setOf(1, 2, 3, 4, 5, 6)
            val lotto = Lotto(setOf(1, 2, 3, 4, 5, 7))

            it("3등이다.") {
                val lottoPrize = lotto.calculateResult(numbers)

                lottoPrize shouldBe LottoRank.THIRD
            }
        }

        context("로또 번호와 당첨 번호가 4개 일치하면") {
            val numbers = setOf(1, 2, 3, 4, 5, 6)
            val lotto = Lotto(setOf(1, 2, 3, 4, 7, 8))

            it("4등이다.") {
                val lottoPrize = lotto.calculateResult(numbers)

                lottoPrize shouldBe LottoRank.FOURTH
            }
        }

        context("로또 번호와 당첨 번호가 3개 일치하면") {
            val numbers = setOf(1, 2, 3, 4, 5, 6)
            val lotto = Lotto(setOf(1, 2, 3, 7, 8, 9))

            it("5등이다.") {
                val lottoPrize = lotto.calculateResult(numbers)

                lottoPrize shouldBe LottoRank.FIFTH
            }
        }
    }
})
