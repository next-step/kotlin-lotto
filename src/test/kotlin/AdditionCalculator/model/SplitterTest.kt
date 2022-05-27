package AdditionCalculator.model

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class SplitterTest : DescribeSpec({
  describe("constructor") {
    it("커스텀 delimiter 를 입력하면 delimiter 와 tokens 를 분리한다.") {
      // given
      val expression = "//;\n1;2;3"

      // when
      val splitter = Splitter(expression)

      // then
      splitter.tokens shouldBe listOf("1", "2", "3")
    }

    it("delimiter 를 ,(콤마)로 입력하면 delimiter 와 tokens 를 분리한다.") {
      // given
      val expression = "1,2,3"

      // when
      val splitter = Splitter(expression)

      // then
      splitter.tokens shouldBe listOf("1", "2", "3")
    }

    it("delimiter 를 :(콜론)으로 입력하면 delimiter 와 tokens 를 분리한다.") {
      // given
      val expression = "1:2:3"

      // when
      val splitter = Splitter(expression)

      // then
      splitter.tokens shouldBe listOf("1", "2", "3")
    }
  }
})
