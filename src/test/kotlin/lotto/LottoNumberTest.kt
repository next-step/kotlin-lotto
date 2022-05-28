package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

internal class LottoNumberTest {

    @Test
    fun `객체의 상태 값인 number 의 값이 같으면 같은 객체로 판단한다`() {
        val actual = LottoNumber(1)
        val expected = LottoNumber(1)

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `유효성 검증`() {
        assertThatIllegalArgumentException().isThrownBy { LottoNumber(0) }
    }
}
