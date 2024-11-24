import calculator.DefaultExpressionCreator
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class DefaultExpressionCreatorTest {
    @Test
    @DisplayName("기본 구분자로 생성한다")
    fun `기본 구분자로 생성한다`() {
        // Arrange:
        val expression = "1,2,3"

        // Act:
        val expressions = DefaultExpressionCreator.create(expression)

        // Assert:
        expressions.expressions shouldBe listOf(1, 2, 3)
    }
}
