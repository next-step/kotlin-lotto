package lotto.domain.value

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class LottoNumberTest {
    @Test
    fun zeroTest() {
        assertThatThrownBy { (LottoNumber(0)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또는 1~45사이의 숫자만 생성가능합니다.")
    }

    @Test
    fun `46Test`() {
        assertThatThrownBy { (LottoNumber(46)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또는 1~45사이의 숫자만 생성가능합니다.")
    }

    @Test
    fun normalTest() {
        for (i in 1..45) {
            assertThat(LottoNumber(i)).isEqualTo(LottoNumber(i))
        }
    }
}
