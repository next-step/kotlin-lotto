package stringAdditionCalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringParserTest {

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5", "1:2:3:4:5", "1,2:3:4:5", "1:2,3:4:5"])
    fun `문자열을 쉼표 또는 콜론을 구분자를 기준으로 분리한다`(input: String) {
        val stringParser: StringParser = StringParser()

        val result: List<String> = stringParser.parse(input)

        assertThat(result).containsExactly("1", "2", "3", "4", "5")
    }

    @ParameterizedTest
    @EmptySource
    fun `separatorList 값에 빈 문자열을 넘길 경우, IllegalArgumentException을 던진다`(separator: String) {
        assertThrows<IllegalArgumentException> {
            StringParser(listOf(separator))
        }
    }

    @ParameterizedTest
    @CsvSource("1a2b3b4a5,a:b", "1a2b3c4d5,a:b:c:d", "1a2a3b4b5,a:b", "1[2[3[4]5,[:]")
    fun `문자열을 StringParser 인스턴스를 생성했을 때 할당한 커스텀 구분자를 기준으로 분리한다`(input: String, separatorString: String) {
        val separatorList: List<String> = separatorString.split(":")

        val stringParser: StringParser = StringParser(separatorList)

        val result: List<String> = stringParser.parse(input)

        assertThat(result).containsExactly("1", "2", "3", "4", "5")
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5", "1:2:3:4:5", "1,2:3:4:5", "1:2,3:4:5"])
    fun `할당된 구분자가 존재하지 않는 문자열이 들어올 경우, IllegalStatusException 예외를 throw 한다`(input: String) {
        val stringParser: StringParser = StringParser(listOf("a", "b"))

        assertThrows<IllegalStateException> {
            stringParser.parse(input)
        }
    }

    @Test
    fun `분리된 문자열을 숫자로 변환한다`() {
        val stringParser: StringParser = StringParser()

        val result: List<Int> = stringParser.parseToInt("1,2,3,4,5")

        assertAll(
            { assertThat(result.all { it is Int }).isTrue() },
            { assertThat(result).isEqualTo(listOf(1, 2, 3, 4, 5)) }
        )
    }
}
