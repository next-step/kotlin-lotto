package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 44, 45, 46])
    internal fun `로또 숫자가 생성된다`(value: Int) {
        val lottoNumber = LottoNumber(value)
        assertThat(lottoNumber.value).isEqualTo(value)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 47])
    internal fun `로또 숫자는 1-46 범위를 넘을 수 없다`(value: Int) {
        assertThrows<IllegalArgumentException> { LottoNumber(value) }
    }
}
