package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 45, 12, 31, 42])
    fun `LottoNumber는 로또 번호를 표현하는 숫자를 보관한다`(input: Int) {
        val lottoNumber = LottoNumber(input)

        assertThat(lottoNumber.value).isEqualTo(input)
    }

    @ParameterizedTest
    @ValueSource(ints = [55, 32, 156, 266, 334, 23, 1, 4, 0])
    fun `1에서 45까지의 숫자 외의 값이 들어온다면 IllegalArgumentException이 발생한다`(input: Int) {
        if (input in LottoNumber.lottoNumberRange) {
            assertDoesNotThrow { LottoNumber(input) }
        } else {
            assertThrows<IllegalArgumentException> { LottoNumber(input) }
        }
    }
}
