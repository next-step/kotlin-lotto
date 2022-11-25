package lotto.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @DisplayName("로또 번호는 1부터 45까지의 숫자만 가능하다.")
    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `로또 번호는 1부터 45까지의 숫자만 가능하다`(number: Int) {
        // when, then
        assertThatThrownBy { LottoNumber(number) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("로또 번호는 1~45 사이의 숫자만 가능합니다.")
    }
}
