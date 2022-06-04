package lotto

import lotto.model.LottoNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {

    @Test
    fun `동일성 보장`() {
        assertThat(LottoNumber.from(1)).isSameAs(LottoNumber.from(1))
        assertThat(LottoNumber.from(45)).isSameAs(LottoNumber.from(45))
    }

    @ParameterizedTest(name = "로또 숫자가 1~45 사이가 아닌 숫자 {0} 라면 IllegalArgument 예외가 발생한다")
    @ValueSource(strings = ["0", "-10", "50"])
    fun `로또 숫자가 1~45 사이가 아닌 숫자라면 IllegalArgument 예외가 발생한다`(number: Int) {
        assertThrows<IllegalArgumentException> { LottoNumber.from(number) }
    }
}
