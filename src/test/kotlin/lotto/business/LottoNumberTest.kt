package lotto.business

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 44, 45])
    fun `1보다 크고 45보다 작은 숫자로 로또 번호를 생성할 수 있다`(number: Int) {
        // when
        val lottoNumber = LottoNumber(number)

        // then
        assertThat(lottoNumber.number).isEqualTo(number)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `1보다 작거나 45보다 큰 숫자로 로또 번호를 생성하면 예외를 던진다`(number: Int) {
        // when
        assertThatThrownBy { LottoNumber(number) }
        // then
            .isInstanceOf(IllegalArgumentException::class.java)
            .message().isEqualTo("로또 번호는 1~45 사이의 숫자여야 합니다.")
    }
}
