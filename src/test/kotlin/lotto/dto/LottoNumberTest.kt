package lotto.dto

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `로또 번호가 1 ~ 45 범위가 아니면 예외가 발생한다`(number: Int) {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            LottoNumber(number)
        }
    }
}
