package stringcalculator.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import stringcalculator.util.StringExpressionParser.splitByCustomDelimiter
import stringcalculator.util.StringExpressionParser.splitByDefaultDelimiter
import java.util.stream.Stream

@DisplayName("문자열 계산시 변환을 담당하는 객체인 `StringExpressionParserTest` 테스트")
internal class StringExpressionParserTest {

    @DisplayName("`,`, `:`와 같이 기본 구분자로 구성된 숫자 문자열이 주어지면 포함된 숫자들을 쪼개어 리스트로 반환 성공")
    @ParameterizedTest
    @MethodSource("expressionThatContainsDefaultDelimiter")
    fun splitToListIsSuccess_IfGivenExpressionThatContainsDefaultDelimiter(expression: String, expectedList: List<String>) {
        // Arrange
        // Act
        val extractNumbers = expression.splitByDefaultDelimiter()

        // Assert
        assertThat(extractNumbers).isEqualTo(expectedList)
    }

    @DisplayName("기본 구분자가 아닌 다른 구분자로 이루어진 숫자 문자열이 주어지면 제대로 쪼개지 못하고 처음 값을 리스트로 반환")
    @ParameterizedTest
    @ValueSource(strings = ["5!6", "8#9", "1c2", "0&0", "3*3", "4)9"])
    fun returnOneSizeListThatContainsGivenExpression_IfGivenExpressionThatDoNotContainsDefaultDelimiter(expression: String) {
        // Arrange
        // Act
        val extractNumbers = expression.splitByDefaultDelimiter()

        // Assert
        assertThat(extractNumbers[0]).isEqualTo(expression)
    }

    @DisplayName("사용자 정의 구분자로 구성된 숫자 문자열이 주어지면 포함된 숫자들을 쪼개어 리스트로 반환 성공")
    @ParameterizedTest
    @MethodSource("expressionThatContainsCustomDelimiter")
    fun splitToListIsSuccess_IfGivenExpressionThatContainsCustomDelimiter(expression: String, expectedList: List<String>) {
        // Arrange
        // Act
        val extractNumbers = expression.splitByCustomDelimiter()

        // Assert
        assertThat(extractNumbers).isEqualTo(expectedList)
    }

    @DisplayName("사용자 정의 구분자가 포함되지 않은 숫자 문자열이 주어지면  제대로 쪼개지 못하고 처음 값을 리스트로 반환")
    @ParameterizedTest
    @ValueSource(strings = ["//@\n1;2;3", "//#\n777", "//&\n2#4#4", "//_\n8@1!3A2"])
    fun returnOneSizeListThatContainsGivenExpression_IfGivenExpressionThatDoNotContainsCustomDelimiter(expression: String) {
        // Arrange
        // Act
        val extractNumbers = expression.splitByDefaultDelimiter()

        // Assert
        assertThat(extractNumbers[0]).isEqualTo(expression)
    }

    @DisplayName("사용자 정의 구분자가 없는 숫자 문자열이 주어지면 빈 리스트로 반환")
    @ParameterizedTest
    @ValueSource(strings = ["//\n1;2;3", "//\n777", "//\n2#4#4", "//\n8@1!3A2"])
    fun returnEmptyList_IfGivenExpressionThatIsNotExistCustomDelimiter(expression: String) {
        // Arrange
        // Act
        val extractNumbers = expression.splitByCustomDelimiter()

        // Assert
        assertThat(extractNumbers).isEmpty()
    }

    companion object {
        @JvmStatic
        fun expressionThatContainsDefaultDelimiter(): Stream<Arguments> =
            Stream.of(
                Arguments.of(
                    "1,2,3",
                    listOf("1", "2", "3")
                ),
                Arguments.of(
                    "4:5:6",
                    listOf("4", "5", "6")
                ),
                Arguments.of(
                    "11:22,33",
                    listOf("11", "22", "33")
                ),
                Arguments.of(
                    "55,66:77",
                    listOf("55", "66", "77")
                ),
                Arguments.of(
                    "381_256:281_783:152_534_449",
                    listOf("381_256", "281_783", "152_534_449")
                )
            )

        @JvmStatic
        fun expressionThatContainsCustomDelimiter(): Stream<Arguments> =
            Stream.of(
                Arguments.of(
                    "//;\n1;2;3",
                    listOf("1", "2", "3")
                ),
                Arguments.of(
                    "//@\n7@7@7",
                    listOf("7", "7", "7")
                ),
                Arguments.of(
                    "//!\n9!8!7!6!5!4!3!2!1",
                    listOf("9", "8", "7", "6", "5", "4", "3", "2", "1")
                ),
                Arguments.of(
                    "//#\n2#4#4",
                    listOf("2", "4", "4")
                ),
                Arguments.of(
                    "//A\n1A2A3A4A5",
                    listOf("1", "2", "3", "4", "5")
                ),
                Arguments.of(
                    "//&\n777&333&666",
                    listOf("777", "333", "666")
                )
            )
    }
}
