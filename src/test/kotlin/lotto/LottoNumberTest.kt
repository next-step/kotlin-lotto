package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {

    @ParameterizedTest
    @MethodSource("lottoNumberProvider")
    fun `로또 번호는 1부터 45까지의 숫자만 가능하다`(number: Int) {
        assertDoesNotThrow { LottoNumber(number) }
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 46, 999])
    fun `로또 번호는 1부터 45까지의 숫자가 아닐 경우 에러가 발생하다`(number: Int) {
        Assertions.assertThatThrownBy { LottoNumber(number) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또 번호는 1부터 45까지의 숫자만 가능합니다.")
    }

    companion object {
        @JvmStatic
        fun lottoNumberProvider() = (Lotto.LOTTO_NUMBER_MIN..Lotto.LOTTO_NUMBER_MAX).toList()
    }
}
