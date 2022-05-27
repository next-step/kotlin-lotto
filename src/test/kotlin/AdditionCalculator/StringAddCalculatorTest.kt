package AdditionCalculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class StringAddCalculatorTest : DescribeSpec({

  describe("add") {
    it("입력된 숫자의 합을 반환한다.") {
      // given
      val expression = listOf("1", "2", "3")

      // when
      val result = StringAddCalculator().add(expression)

      // then
      result shouldBe 6
    }

    it("입력된 숫자 중 음수가 있으면 RuntimeException 을 던진다.") {
      // given
      val expression = listOf("1", "-2", "3")

      // when
      val exception = shouldThrow<RuntimeException> {
        StringAddCalculator().add(expression)
      }

      // then
      exception.message shouldBe "음수는 계산할 수 없습니다."
    }

    it("입력된 값이 숫자가 아닐 경우 RuntimeException 을 던진다.") {
      // given
      val exceptionElement = "a"
      val expression = listOf("1", exceptionElement, "3")

      // when
      val exception = shouldThrow<RuntimeException> {
        StringAddCalculator().add(expression)
      }

      // then
      exception.message shouldBe "For input string: \"$exceptionElement\""
    }
  }
})
