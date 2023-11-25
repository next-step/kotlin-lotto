import lotto.domain.LottoNumber
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @ValueSource(ints = [1, 14, 35, 45])
    @ParameterizedTest
    fun `로또 숫자는 1~45 사이의 숫자를 가지고 있다`(num: Int) {
        val lottoNumber = LottoNumber.valueOf(num)
        assertThat(lottoNumber.number).isBetween(1, 46)
    }

    @ValueSource(ints = [99, 1000, 101, 47, 60])
    @ParameterizedTest
    fun `로또에 포함되는 숫자가 1~45 범위외이면 예외를 던진다`(num: Int) {

        assertThatThrownBy { LottoNumber.valueOf(num) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
