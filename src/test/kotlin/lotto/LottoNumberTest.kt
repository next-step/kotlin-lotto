package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `로또 번호는 범위를 벗어나면 예외 발생`(value: Int) {
        assertThatIllegalArgumentException().isThrownBy {
            LottoNumber(value)
        }
    }

    @Test
    fun `로또 번호는 비교 가능하다`() {
        val lottoNumber1 = LottoNumber(1)
        val lottoNumber2 = LottoNumber(2)

        assertThat(lottoNumber1).isLessThan(lottoNumber2)
    }
}