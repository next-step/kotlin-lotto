package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import stringadd.StringAddition

class StringAdditionTest {
    @CsvSource(
        value = [
            "'1,2:3', ',|:'",
            "'1^2^3', '\\^'",
            "'1*2*3', '\\*'",
            "'1$2$3', '\\$'",
            "'1%2%3', '\\%'"
        ]
    )
    @ParameterizedTest
    fun `정규식 학습 테스트를 하자`(exp: String, reg: String) {
        assertThat(exp.split(Regex(reg))).isEqualTo(listOf("1", "2", "3"))
    }

    @CsvSource(
        value = [
            "'6,2,1', 9",
            "'5,1:1', 7",
            "'6:2:1', 9",
            "'5,1:1', 7",
            "'', 0",
        ]
    )
    @ParameterizedTest
    fun `쉼표, 콜론을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 한다`(exp: String, expectValue: Int) {
        val stringAddition = StringAddition(exp)
        assertThat(stringAddition.execute()).isEqualTo(expectValue)
    }

    @CsvSource(
        value = [
            "1, 1",
            "9, 9",
        ]
    )
    @ParameterizedTest
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(exp: String, expectValue: Int) {
        val stringAddition = StringAddition(exp)
        assertThat(stringAddition.execute()).isEqualTo(expectValue)
    }

    @CsvSource(
        value = [
            "'//#\n1#1#2', 4",
            "'//$\n1$2$2', 5",
            "'//*\n1*2*2', 5",
            "'//^\n1^6^2', 9"
        ]
    )
    @ParameterizedTest
    fun `앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다`(exp: String, expectValue: Int) {
        val stringAddition = StringAddition(exp)
        assertThat(stringAddition.execute()).isEqualTo(expectValue)
    }

    @CsvSource(
        value = [
            "'//#\n1&1#2'",
            "'//$\n1-2$2'",
            "'//*\n1*-2*2",
        ]
    )
    @ParameterizedTest
    fun `문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다`(exp: String) {
        val stringAddition = StringAddition(exp)
        assertThrows<RuntimeException> { stringAddition.execute() }
    }
}
