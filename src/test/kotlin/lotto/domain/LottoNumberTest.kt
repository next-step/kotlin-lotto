package lotto.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoNumberTest {

    @DisplayName("범위를 벗어나는 로또 번호가 들어왔을 때 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = [-1, 46])
    fun lottoNumberNotInRange(number: Int) {
        assertThatThrownBy { LottoNumber(number) }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
