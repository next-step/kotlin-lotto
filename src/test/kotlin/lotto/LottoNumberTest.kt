package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 45])
    fun `로또 번호는 1~45 사이의 수를 제공된 수를 가진다`(num: Int) {
        val lottoNumber = LottoNumber(num)
        Assertions.assertThat(lottoNumber.number).isEqualTo(num)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `로똔 번호가 1~45 범위를 벗어난 경우 IllegalArgumentException 예외를 발생한다`(num: Int) {
        assertThrows<IllegalArgumentException> {
            LottoNumber(num)
        }
    }
}
