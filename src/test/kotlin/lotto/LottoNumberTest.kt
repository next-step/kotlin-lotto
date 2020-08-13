package lotto

import lotto.domain.LottoNumber
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @DisplayName("로또 숫자 유효성 검사")
    @ParameterizedTest
    @ValueSource(ints = [-3, 0, 99])
    fun validateLottoNumber(number: Int) {
        Assertions.assertThatThrownBy { LottoNumber(number) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @DisplayName("로또 숫자가 같다")
    @Test
    fun checkEqualLottoNumber() {
        val lottoNumber = LottoNumber(1)
        val anotherLottoNumber = LottoNumber(1)
        assertThat(lottoNumber)
            .isEqualTo(anotherLottoNumber)
    }
}
