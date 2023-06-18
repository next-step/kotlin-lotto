package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

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
})
