package lotto.model.lotto

import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoNumberTest {

    @DisplayName(value = "로또 번호는 1~45까지의 숫자여야한다., Exception")
    @Test
    fun checkDuplicationBonusBall() {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy {
                LottoNumber.from(46)
            }
    }
}
