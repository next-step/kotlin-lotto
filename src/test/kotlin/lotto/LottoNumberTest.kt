package lotto

import lotto.model.LottoNumber
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @ParameterizedTest(name = "로또 숫자가 1~45 사이가 아닌 숫자 {0} 라면 IllegalArgument 예외가 발생한다")
    @ValueSource(strings = ["0", "-10", "50"])
    fun `로또 숫자가 1~45 사이가 아닌 숫자라면 IllegalArgument 예외가 발생한다`(number: Int) {
        assertThrows<IllegalArgumentException> { LottoNumber.from(number) }
    }
}
