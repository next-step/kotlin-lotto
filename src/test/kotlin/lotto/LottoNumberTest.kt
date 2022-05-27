package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

internal class LottoNumberTest {

    @Test
    fun `객체동등성비교`() {
        val actual = LottoNumber(1)
        val expected = LottoNumber(1)

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `유효성 검증`() {
        assertThatIllegalArgumentException().isThrownBy { LottoNumber(0) }
    }
}
