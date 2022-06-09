package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoNumberTest {

    @Test
    fun `LottoNumber는 1 ~ 45 의 값을 가진다`() {
        (1..45).forEach {
            val lottoNumber = LottoNumber.of(it)
            assertThat(lottoNumber).isEqualTo(LottoNumber.of(it))
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 46])
    fun `Invalid Lotto Number throws exception`(value: Int) {
        assertThrows<IllegalArgumentException> { LottoNumber.of(value) }
    }
}
