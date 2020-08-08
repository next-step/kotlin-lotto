package lotto.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {

    @ValueSource(ints = [0, 46])
    @ParameterizedTest
    fun `로또 번호 범위(1~45)가 아닌 숫자가 들어오면 Exception`(inValidNumber: Int) {
        // then
        assertThatThrownBy { LottoNumber.of(inValidNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("$inValidNumber 는 로또 번호(1~45)가 아닙니다.")
    }
}
