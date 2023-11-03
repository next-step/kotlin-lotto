package lotto.util

import lotto.LottoManager.Companion.NUMBER_NUM
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringHandlerTest {
    @ParameterizedTest
    @ValueSource(strings = ["10,000", "100$", "-1000"])
    fun `구입 금액이 숫자 외의 문자를 포함할 경우 Exception을 던진다`(input: String) {
        assertThatThrownBy { StringHandler().checkNonNumExists(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("구입 금액은 숫자로만 표현되어야 합니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4, 5,6", "1, 2, 3, 4, 5, 6", "1,2,3,4,5,6,"])
    fun `당첨 번호 문자열을 6개의 숫자로 변환한다`(input: String) {
        assertThat(StringHandler().tokenizeWinningNumbers(input).size)
            .isEqualTo(NUMBER_NUM)
    }
}
