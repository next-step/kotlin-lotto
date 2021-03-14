package lotto.vo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class LottoNumberTest {
    @ParameterizedTest
    @DisplayName("로또 번호는 1~45 범위이다")
    @CsvSource("1,10,20,30,45")
    fun validLottoRange(number: Int) {
        assertThat(LottoNumber.from(number).number).isEqualTo(number)
    }

    @ParameterizedTest
    @DisplayName("로또 번호는 1~45 이외 범위를 허용하지 않는다")
    @CsvSource("-1,0,46")
    fun notAllowedLottoRange(number: Int) {
        assertThrows<IllegalArgumentException> { LottoNumber.from(number) }
    }

    @ParameterizedTest
    @CsvSource("1,10,20,30,45")
    @DisplayName("로또 번호는 모두 동일하다")
    fun isSameLottoNumber(number: Int) {
        assertThat(LottoNumber.from(number)).isSameAs(LottoNumber.from(number))
    }
}
