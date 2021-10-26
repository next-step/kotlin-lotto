package domain.calculator.domain.separator

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("구분자(Separator)")
class SeparatorTest {

    @ParameterizedTest(name = "공백 구분자: `{0}`")
    @ValueSource(strings = ["", " ", "   "])
    fun `공백 문자열이 입력되었을 경우 예외를 발생한다`(blankString: String) {
        assertThatThrownBy { Separator(blankString) }
            .isExactlyInstanceOf(RuntimeException::class.java)
            .hasMessage("Separator, null 이거나 공백인 문자열은 입력할 수 없습니다.")
    }
}
