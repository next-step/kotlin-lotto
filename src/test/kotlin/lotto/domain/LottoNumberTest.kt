package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 10, 30, 40, 45])
    fun `로또 번호를 나타내는 클래스로 값이 1~45 사이를 보장한다`(int: Int) {
        Assertions.assertThat(LottoNumber(int).number).isEqualTo(int)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1, 46])
    fun `로또 번호를 나타내는 클래스로 값이 1~45 범위가 아닌 값이 들어오면 예외가 발생한다`(int: Int) {
        Assertions.assertThatThrownBy { LottoNumber(int) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
