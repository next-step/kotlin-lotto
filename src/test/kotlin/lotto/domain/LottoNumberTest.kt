package lotto.domain

import lotto.domain.LottoNumber.Companion.INVALID_MESSAGE
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class LottoNumberTest {

    @Test
    fun `0 이하의 숫자는 LottoNumber로 사용할 수 없다`() {
        val number = 0
        assertThatThrownBy { LottoNumber.of(number) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("$number$INVALID_MESSAGE")
    }

    @Test
    fun `46 이상의 숫자는 LottoNumber로 사용할 수 없다`() {
        val number = 46
        assertThatThrownBy { LottoNumber.of(number) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("$number$INVALID_MESSAGE")
    }

    @Test
    fun `1 ~ 45사이의 숫자는 LottoNumber로 사용할 수 있다`() {
        for (i in 1..45) {
            assertThat(LottoNumber.of(i)).isEqualTo(LottoNumber.of("$i"))
        }
    }

    @Test
    fun testToString() {
        val actual = LottoNumber(1)
        assertThat(actual.toString()).isEqualTo("1")
    }
}
