package lotto.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoNumberTest {
    @Test
    @DisplayName("로또 숫자 범위에 들어가지 않는 숫자면 에러가 발생한다")
    fun notLottoNumber() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { LottoNumber(46) }
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { LottoNumber(0) }
    }

    @Test
    @DisplayName("기본으로 해당하는 범위 전체의 lottoNumber list가 생성되어있어있다")
    fun baseLottoNumber() {
        val baseLottoNumbers = LottoNumber.baseLottoNumbers
        assertThat(baseLottoNumbers.size).isEqualTo(45)
    }
}
