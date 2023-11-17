package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 46])
    fun `로또 숫자 범위를 벗어난 요청에 Exception을 던진다`(input: Int) {
        Assertions.assertThatThrownBy { LottoNumber.from(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또 번호는 1~45 사이의 숫자여야 합니다.")
    }
}
