package lotto.util

import lotto.LottoManager.Companion.NUMBER_NUM
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringHandlerTest {
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4, 5,6", "1, 2, 3, 4, 5, 6", "1,2,3,4,5,6,"])
    fun `당첨 번호 문자열을 6개의 숫자로 변환한다`(input: String) {
        assertThat(StringHandler().tokenizeWinningNumbers(input).size)
            .isEqualTo(NUMBER_NUM)
    }
}
