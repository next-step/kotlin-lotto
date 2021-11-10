package lotto

import lotto.domain.LottoNumber
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `0과 46은 로또 범위에 들어가있지 않기 때문에 에러를 발생시킨다`(input: Int) {
        // given
        val actual =
            runCatching { LottoNumber.from(input) }.exceptionOrNull()

        // then
        Assertions.assertThat(actual).hasMessageContaining("범위에 벗어난 숫자입니다.")
    }
}
