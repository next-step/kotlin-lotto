package lotto

import lotto.domain.LottoNumber
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `로또 번호가 범위 안에 포함되어 있지 않으면 에러`(input: Int) {
        // given
        val actual =
            runCatching { LottoNumber(input) }.exceptionOrNull()

        // then
        Assertions.assertThat(actual).hasMessageContaining("범위에 벗어난 숫자입니다.")
    }
}
