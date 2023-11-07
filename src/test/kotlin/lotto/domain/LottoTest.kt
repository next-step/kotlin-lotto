package lotto.domain

import lotto.tokenizeWinningNumbers
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoTest {
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5", "1,2,3,4,5,6,7"])
    fun `당첨 번호가 6개가 아닌 경우 Exception을 던진다`(input: String) {
        val numbers = tokenizeWinningNumbers(input)
        Assertions.assertThatThrownBy { Lotto(numbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또 번호는 6개여야 합니다.")
    }
}
