package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import stringcalculator.model.StringConverter

class StringConverterTest {

    @DisplayName(value = "정상적인 숫자 분리하기")
    @ParameterizedTest
    @ValueSource(strings = ["3,4,5", "3:4:5", "3,4:5", "3:4,5"])
    fun happyCase(text: String) {
        assertThat(StringConverter.splitInput(text))
            .isEqualTo(listOf("3", "4", "5"))
    }

    @DisplayName(value = "구분자가 없는 문자일 경우, 그대로 리턴한다")
    @ParameterizedTest
    @ValueSource(strings = ["3", "TestCode"])
    fun inputOnlyOneString(text: String) {
        assertThat(StringConverter.splitInput(text))
            .isEqualTo(listOf(text))
    }

    @DisplayName(value = "커스텀 구분자(\\n,//)에도 정상적으로 분리")
    @ParameterizedTest
    @ValueSource(strings = ["//;\n3;4;5", "//*\n3*4*5", "//#\n3#4#5", "//_\n3_4_5"])
    fun inputCustomSeparator(text: String) {
        assertThat(StringConverter.splitInput(text))
            .isEqualTo(listOf("3", "4", "5"))
    }
}
