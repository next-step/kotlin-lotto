package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CustomExpressionCreatorTest {

    @Test
    @DisplayName("커스텀 구분자가 없으면 기본 구분자로 생성한다")
    fun `커스텀 구분자가 있으면 커스텀 구분자로 생성한다`() {
        // Arrange:
        val expression = "//;\n1;2;3"

        // Act:
        val expressions = CustomExpressionCreator.create(expression)

        // Assert:
        expressions.expressions shouldBe listOf(1, 2, 3)
    }

    @Test
    @DisplayName("커스텀 구분자가 없는 상태로 호출되면 예외가 발생한다.")
    fun `커스텀 구분자가 없는 상태로 호출되면 예외가 발생한다`() {
        // Arrange:
        val expression = "1,2,3"

        // Act & Assert:
        shouldThrow<IllegalArgumentException> {
            CustomExpressionCreator.create(expression)
        }.message shouldBe "커스텀 구분자가 존재하지 않습니다. input = $expression"
    }
}