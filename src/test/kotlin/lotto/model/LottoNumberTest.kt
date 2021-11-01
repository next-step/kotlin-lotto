package lotto.model

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumberTest {

    @DisplayName("로또 번호의 숫자가 1 보다 작거나 45보다 크다면 RuntimeException 예외가 발생해야 한다.")
    @Test
    fun lottoNumberRange() {
        assertThrows<RuntimeException> {
            LottoNumber(-1)
        }
    }
}
