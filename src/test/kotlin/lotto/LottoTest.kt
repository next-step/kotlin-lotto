package lotto

import lotto.model.Lotto
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoTest {

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5,6,7", "1,2,3,4,5"])
    fun `로또 번호 6자리 유효성 체크`(input: String) {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            Lotto.of(input)
        }
    }
}
