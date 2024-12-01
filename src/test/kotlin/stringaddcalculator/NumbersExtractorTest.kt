package stringaddcalculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NumbersExtractorTest {
    @Test
    fun `음수가 포함된 경우 예외를 발생시킨다`() {
        val text = "-1:2,3"

        assertThatThrownBy { NumbersExtractor.extract(text) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `커스텀 구분자가 없으면 콤마 또는 콜론으로 숫자를 추출한다`() {
        val text = "1,2:3,4:5"

        val numbers = NumbersExtractor.extract(text)

        assertThat(numbers).containsExactly(1, 2, 3, 4, 5)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,:2:3", "1,,2,3", ",1,2,3", "1,2,3,"])
    fun `기본 구분자일 때 패턴 검사 - {숫자}{구분자}{숫자} 형태인지 검사하고 아닐 경우 예외를 발생시킨다`(text: String) {
        assertThatThrownBy { NumbersExtractor.extract(text) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `커스텀 구분자가 있으면 커스텀 구분자를 기준으로 숫자를 추출한다`() {
        val text = "//;\n1;2;3;4;5"

        val numbers = NumbersExtractor.extract(text)

        assertThat(numbers).containsExactly(1, 2, 3, 4, 5)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", ";;"])
    fun `커스텀 구분자가 빈 값이거나 2개 이상의 문자로 구성된 경우 예외를 발생시킨다`(delimiter: String) {
        val text = "//${delimiter}\n1${delimiter}2${delimiter}3${delimiter}4${delimiter}5"

        assertThatThrownBy { NumbersExtractor.extract(text) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("구분자는 빈 값이거나 2글자 이상일 수 없습니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;;2;3", "//;\n;1;2;3", "//;\n1;2;3;"])
    fun `커스텀 구분자일 때 패턴 검사 - {숫자}{구분자}{숫자} 형태인지 검사하고 아닐 경우 예외를 발생시킨다`(text: String) {
        assertThatThrownBy { NumbersExtractor.extract(text) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
