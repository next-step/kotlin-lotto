package lotto.model.lotto

import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WinnerNumbersTest {

    @DisplayName(value = "당첨 번호 생성시, 보너스번호는 당첨번호와 중복되거나, 로또 숫자 범위를 넘어가서는 안된다, Exception")
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 0, 55])
    fun checkDuplicationBonusBall(input: Int) {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy {
                WinnerNumbers("1,2,3,4,5,6".toNumbers(), LottoNumber(input))
            }
    }
}
