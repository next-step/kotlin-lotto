package lotto.domain.model

import lotto.domain.model.LottoNumber.Companion.LOTTO_NUMBER_RANGE
import org.assertj.core.api.AssertionsForClassTypes
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoNumberTest {

    @DisplayName("로또는 특정 범위 내 숫자로 구성되어야 합니다")
    @Test
    fun lottoNumberRange() {
        AssertionsForClassTypes
            .assertThatExceptionOfType(IllegalStateException::class.java)
            .isThrownBy {
                LottoNumber(49)
            }
            .withMessageMatching("로또 숫자는 ${LOTTO_NUMBER_RANGE.first}부터 ${LOTTO_NUMBER_RANGE.last} 사이의 숫자로 구성되어야 합니다")
    }
}
