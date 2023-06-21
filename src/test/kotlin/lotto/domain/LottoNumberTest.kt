package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoNumberTest {
    @DisplayName(value = "로또 숫자가 1 ~ 45 범위를 벗어나면 IllegalArgumentException 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = [0, 46, 47, 100])
    fun lottoNumberOutOfRange(num: Int) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy{ LottoNumber(num) }
    }
}