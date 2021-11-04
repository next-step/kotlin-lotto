package lotto.domain

import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [-1, 48, 0, 50, 55, 100])
    fun `1에서 45사이의 값이 아닌 번호는 선택할 수 없다`(value: Int) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { LottoNumber.of(value) }
    }
}
