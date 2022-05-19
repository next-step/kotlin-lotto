package calculator

import StringAddition
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class StringAdditionTest {
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
}
