package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalStateException

class LottoNumberTest {

    @Test
    fun `LottoNumber를 생성한다`() {
        val lottoNumber = LottoNumber.of(1)
        assertThat(lottoNumber.number).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `1이상 45이하의 값이 들어오지 않으면 예외가 발생한다`(number: Int) {
        assertThrows<IllegalArgumentException> {
            LottoNumber.of(number)
        }
    }
}
