import calculator.Patterns
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class PatternsTest {
    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("Patterns의 hasMatch는 정규식에 매치되는지 확인한다")
    fun `Patterns의 hasMatch는 정규식에 매치되는지 확인한다`(
        expression: String?,
        patternName: String,
        expected: Boolean,
    ) {
        // Arrange:
        val pattern = Patterns.valueOf(patternName)

        // Act:
        val hasMatch = expression?.let { pattern.hasMatch(it) } ?: false

        // Assert:
        hasMatch shouldBe expected
    }

    companion object {
        @JvmStatic
        fun provider(): List<Arguments> {
            return listOf(
                Arguments.of("1,2,3", "DEFAULT", true),
                Arguments.of("1;2;3", "DEFAULT", false),
                Arguments.of("//;\n1;2;3", "CUSTOM", true),
                Arguments.of("1|2|3", "CUSTOM", false),
            )
        }
    }
}
