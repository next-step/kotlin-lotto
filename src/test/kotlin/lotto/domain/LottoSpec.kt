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

    describe("매치되는 번호 개수 계산") {
        context("로또와 번호 목록이 주어지면") {
            val numbers = setOf(1, 2, 3, 4, 5, 6)
            val lotto = Lotto(setOf(1, 2, 3, 4, 5, 6))

            it("매치되는 번호 개수를 계산한다.") {
                val numberOfMatchedNumbers = lotto.calculateNumberOfMatchedNumbers(numbers)

                numberOfMatchedNumbers shouldBe 6
            }
        }
    }
})
