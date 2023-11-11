package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoNumberTest {
    @Test
    fun `로또 번호가 1~45 범위를 넘어서면 에러를 발생한다`() {
        // given :

        // when :
        val actual = runCatching { LottoNumber.validateRange(70) }.exceptionOrNull()

        // then :
        assertThat(actual).isInstanceOf(IllegalArgumentException()::class.java)
    }
}
