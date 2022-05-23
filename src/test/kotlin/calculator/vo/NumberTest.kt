package calculator.vo

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class NumberTest : DescribeSpec({

    describe("Number 클래스 테스트") {
        it("정수를 가진 객체 생성") {
            // given
            val number = 10

            // when
            val result = Number(number)

            // then
            result shouldBe Number(10)
        }

        it("음의 정수로 생성할 경우 IllegalArgumentException 예외를 발생한다.") {
            // given
            val invalidNumber = -1

            // when
            val throwableAction = {
                Number(invalidNumber)
            }

            // then
            shouldThrow<IllegalArgumentException>(throwableAction)
        }

        it("두 객체를 더한 결과는 두 값의 합이다.") {
            // given
            val leftNumber = Number(10)
            val rightNumber = Number(20)

            // when
            val result = leftNumber + rightNumber

            // then
            result shouldBe Number(30)
        }

        it("숫자 문자열로 부터 객체를 생성할 수 있다.") {
            // given
            val stringNumber = "10"

            // when
            val result = Number.fromString(stringNumber)

            // then
            result shouldBe Number(10)
        }

        it("숫자가 아닌 문자가 포함된 경우 IllegalArgumentException 예외를 발생한다.") {
            // given
            val invalidStringNumber = "1O"

            // when
            val throwableAction = {
                Number.fromString(invalidStringNumber)
            }

            // then
            shouldThrow<IllegalArgumentException>(throwableAction)
        }

        it("빈 문자열일 경우 IllegalArgumentException 예외를 발생한다.") {
            // given
            val invalidStringNumber = ""

            // when
            val throwableAction = {
                Number.fromString(invalidStringNumber)
            }

            // then
            shouldThrow<IllegalArgumentException>(throwableAction)
        }
    }
})
