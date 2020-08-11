package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class LottoNumberTest {
    @Test
    @DisplayName("로또 범위가 넘는 숫자가 입력되면 exception 을 반환한다")
    fun `InvalidLottoNumberThrowException`() {
        assertThrows<IllegalArgumentException> {
            LottoNumber.from(46)
        }
    }

    @Test
    @DisplayName("로또 규칙에 맞는 숫자가 입력되면 LottoNumber 가 생성된다")
    fun `validLottoNumberIntType`() {
        assertThat(LottoNumber.from(10)).isNotNull
    }

    @Test
    @DisplayName("로또 규칙에 맞는 문자가 입력되면 LottoNumber 가 생성된다")
    fun `validLottoNumberStringType`() {
        assertThat(LottoNumber.from("10")).isNotNull
    }
}
