package lotto.util

import lotto.util.LottoNumbersParser.ERR_INVALID_INPUT_VALUE
import lotto.util.LottoNumbersParser.splitToNumbers
import lotto.util.LottoNumbersParser.replaceEmptySpace
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

@DisplayName("숫자열로 주어진 `LottoNumbers`를 `List<Int>`로 파싱하는 `LottoNumbersParser` 테스트")
internal class LottoNumbersParserTest {

    @DisplayName("숫자열로 주어진 `LottoNumbers`를 `Separator`를 기준으로 파싱하면 `List<Int>`로 반환")
    @ParameterizedTest
    @MethodSource("numericStringLottoNumbersAndExpectedLottoNumberList")
    fun `return int list if given as a numeric String with reference to Separator`(
        lottoNumbers: String,
        expectedLottoNumbers: List<Int>
    ) {
        // Arrange
        // Act
        val actualLottoNumbers = splitToNumbers(lottoNumbers)

        // Assert
        assertThat(actualLottoNumbers).hasSameElementsAs(expectedLottoNumbers)
    }

    @DisplayName("자를 수 없거나 문자만으로 구성된 문자열이 주어지면 `IllegalArgumentException` 발생")
    @ParameterizedTest
    @ValueSource(strings = ["", "A,B,C", "DEF:ABC", "8923jds!28dl!", " ", "       "])
    fun `IllegalArgumentException occurs if given a could not split`(invalidString: String) {
        // Arrange
        // Act
        // Assert
        assertThatThrownBy { splitToNumbers(invalidString) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ERR_INVALID_INPUT_VALUE)
    }

    @DisplayName("문자열이 주어지면 공백을 제거한 문자열로 반환")
    @ParameterizedTest
    @MethodSource("expressionThatEmptySpaceExist")
    fun `return as a String to remove a space if given the input String`(strThatEmptySpaceExist: String, expectedString: String) {
        // Arrange
        // Act
        val result = replaceEmptySpace(strThatEmptySpaceExist)

        // Assert
        assertThat(result).isEqualTo(expectedString)
    }

    companion object {
        @JvmStatic
        fun numericStringLottoNumbersAndExpectedLottoNumberList(): Stream<Arguments> =
            Stream.of(
                Arguments.of("1, 2, 3, 4, 5, 6", listOf(1, 2, 3, 4, 5, 6)),
                Arguments.of("8, 10, 11, 24, 45, 27", listOf(8, 10, 11, 24, 45, 27)),
                Arguments.of("1, 12, 17, 19, 35, 42", listOf(1, 12, 17, 19, 35, 42)),
                Arguments.of("2, 19, 22, 34, 35, 44", listOf(2, 19, 22, 34, 35, 44)),
                Arguments.of("10, 28, 29, 30, 40, 41", listOf(10, 28, 29, 30, 40, 41)),
            )

        @JvmStatic
        fun expressionThatEmptySpaceExist(): Stream<Arguments> =
            Stream.of(
                Arguments.of("1 , 2 , 3 , 4 , 5 , 6", "1,2,3,4,5,6"),
                Arguments.of(" A B C D ", "ABCD"),
                Arguments.of(" 공 백 테 스 트 ", "공백테스트"),
                Arguments.of("공백없는문자열", "공백없는문자열"),
            )
    }
}
