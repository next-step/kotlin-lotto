package lotto.domain

import lotto.domain.LottoNumber
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.assertj.core.api.Assertions.assertThatNoException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoNumberTest {

    @ValueSource(ints = [1, 5, 10, 11, 30, 45])
    @ParameterizedTest
    internal fun `LottoNumber이 정상 생성된다`(value: Int) {
        // given
        // when, then
        assertThatNoException().isThrownBy { LottoNumber.of(value) }
    }

    @ValueSource(ints = [-1, 0, 46, 100])
    @ParameterizedTest
    internal fun `LottoNumber 값이 1보다 작거나 45보다 크면 IllegalArgumentException 이 발생한다`(value: Int) {
        // given
        // when, then
        assertThatIllegalArgumentException().isThrownBy { LottoNumber.of(value) }
    }


}
