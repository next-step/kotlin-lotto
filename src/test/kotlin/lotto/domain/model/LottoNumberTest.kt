package lotto.domain.model

import lotto.domain.model.LottoNumber.Companion.FIRST_LOTTO_NUMBER
import lotto.domain.model.LottoNumber.Companion.LAST_LOTTO_NUMBER
import org.assertj.core.api.AssertionsForClassTypes
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoNumberTest {

    @DisplayName("로또는 ${FIRST_LOTTO_NUMBER}부터 $LAST_LOTTO_NUMBER 사이의 숫자로 구성되어야 합니다")
    @Test
    fun lottoNumberRange() {
        AssertionsForClassTypes
            .assertThatExceptionOfType(IllegalStateException::class.java)
            .isThrownBy {
                LottoNumber(49)
            }
            .withMessageMatching("로또 숫자는 ${FIRST_LOTTO_NUMBER}부터 $LAST_LOTTO_NUMBER 사이의 숫자로 구성되어야 합니다")
    }
}
