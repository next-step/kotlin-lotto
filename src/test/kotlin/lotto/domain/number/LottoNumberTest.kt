package lotto.domain.number

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @Test
    fun `로또 번호는 1부터 45까지의 숫자로 생성된다`() {
        (1..45).forEach {
            val lottoNumber = LottoNumber.from(it)
            assertThat(lottoNumber.value).isEqualTo(it)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `1부터 45까지의 숫자가 아닌 경우 로또 번호로 생성할 수 없다`(value: Int) {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { LottoNumber.from(value) }
    }
}
