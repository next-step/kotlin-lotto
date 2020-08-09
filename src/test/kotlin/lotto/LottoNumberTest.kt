package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import stringAddCalculator.LottoNumber

internal class LottoNumberTest {

    @Test
    fun `0 이하의 숫자는 LottoNumber로 사용할 수 없다`() {
        assertThatThrownBy { LottoNumber(0) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또는 1~45사이의 숫자만 생성가능합니다.")
    }

    @Test
    fun `46 이상의 숫자는 LottoNumber로 사용할 수 없다`() {
        assertThatThrownBy { LottoNumber(46) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또는 1~45사이의 숫자만 생성가능합니다.")
    }

    @Test
    fun `1 ~ 45사이의 숫자는 LottoNumber로 사용할 수 있다`() {
        for (i in 1..45) {
            assertThat(LottoNumber(i)).isEqualTo(LottoNumber(i))
        }
    }

    @Test
    fun testToString() {
        val actual = LottoNumber(1)
        assertThat(actual.toString()).isEqualTo("1")
    }
}
