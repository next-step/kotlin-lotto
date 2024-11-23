package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.lang.RuntimeException

class ExpressionsTest {
    @Test
    @DisplayName("양수의 값들로 Expressions 객체를 생성한다")
    fun `양수의 값들로 Expressions 객체를 생성한다`() {
        // Arrange:
        val expression = "1,2,3"

        // Act:
        val expressions = Expressions.created(expression, Patterns.DEFAULT.regex)

        // Assert:
        expressions.expressions shouldBe listOf(1, 2, 3)
    }

    @Test
    @DisplayName("음수 값이 포함되면 Expressions 객체를 생성할때 예외가 발생한다")
    fun `음수 값이 포함되면 Expressions 객체를 생성할때 예외가 발생한다`() {
        // Arrange:
        val expression = "1,-2,3"

        // Act & Assert:
        shouldThrow<RuntimeException> {
            Expressions.created(expression, Patterns.DEFAULT.regex)
        }.message shouldBe "음수는 입력할 수 없습니다. input = -2"
    }

    @Test
    @DisplayName("빈 문자열로 Expressions 객체를 생성한다")
    fun `빈 문자열로 Expressions 객체를 생성한다`() {
        // Arrange:
        val expression = ""

        // Act:
        val expressions = Expressions.created(expression, Patterns.DEFAULT.regex)

        // Assert:
        expressions.expressions shouldBe emptyList()
    }

    @Test
    @DisplayName("커스텀 구분자로 Expressions 객체를 생성한다")
    fun `커스텀 구분자로 Expressions 객체를 생성한다`() {
        // Arrange:
        val expression = "1;2;3"
        val customRegex = ";".toRegex()

        // Act:
        val expressions = Expressions.created(expression, customRegex)

        // Assert:
        expressions.expressions shouldBe listOf(1, 2, 3)
    }

    @Test
    @DisplayName("기본 구분자로 Expressions 객체를 생성한다")
    fun `기본 구분자로 Expressions 객체를 생성한다`() {
        // Arrange:
        val expression = "1,2,3"

        // Act:
        val expressions = Expressions.created(expression, Patterns.DEFAULT.regex)

        // Assert:
        expressions.expressions shouldBe listOf(1, 2, 3)
    }

    @Test
    @DisplayName("Expressions 자료형의 표현식의 종합을 계산한다")
    fun `Expressions 자료형의 표현식의 종합을 계산한다`() {
        // Arrange:
        val expression = "1,2,3"
        val expressions = Expressions.created(expression, Patterns.DEFAULT.regex)

        // Act:
        val sum = expressions.sum()

        // Assert:
        sum shouldBe 6
    }
}
