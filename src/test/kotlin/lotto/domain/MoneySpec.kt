package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import kotlin.reflect.typeOf

class MoneySpec : DescribeSpec({
    describe("돈 값(value) 검증") {
        context("돈의 값이 0보다 크면") {
            it("돈 객체를 정상 생성한다.") {
                val money = Money(1000)

                money.value shouldBe 1000
            }
        }
        context("돈의 값이 0보다 작으면") {
            it("예외가 발생한다.") {
                shouldThrow<IllegalArgumentException> {
                    Money(-1000)
                }
            }
        }
    }

    describe("더하기 연산 검증") {
        context("두 돈을 더하면") {
            it("두 돈의 합을 반환한다.") {
                val money = Money(1000)

                money + Money(1000) shouldBe Money(2000)
            }
        }
    }

    describe("빼기 연산 검증") {
        context("두 돈을 빼면") {
            it("두 돈의 차를 반환한다.") {
                val money = Money(1000)

                money - Money(1000) shouldBe Money(0)
            }
        }
    }

    describe("비교 연산 검증") {
        it("두 돈을 비교 연산할 수 있다.") {
            val money = Money(1000)

            (money > Money(500)) shouldBe true
        }
    }
})
