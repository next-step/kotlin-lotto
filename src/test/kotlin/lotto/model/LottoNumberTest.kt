package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 10, 13, 30, 42])
    fun `로또 번호는 1~45 사이의 숫자 생성된다`(number: Int) {
        assertThat(LottoNumber(number)).isNotNull
    }


    @ParameterizedTest
    @ValueSource(ints = [0, 48, 50, 60, 100])
    fun `로또 번호는 1~45 사이의 숫자만 가능하다`() {
        assertThatThrownBy { LottoNumber(0) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또 번호는 1~45 사이의 숫자만 가능합니다.")
    }
}
