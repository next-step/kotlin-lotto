package lotto

import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `로또 숫자가 1과 45 사이에 존재하지 않는다면 예외를 발생한다`(value: Int) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { LottoNumber(value) }
    }
}
