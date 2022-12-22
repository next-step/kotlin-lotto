package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

internal class LottoNumberTest {
    @Test
    fun `숫자가 아닌 값을 입력하면 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            LottoNumber("A")
        }
        assertThat(exception.message).isSameAs("숫자만 입력 가능합니다.")
    }

    @Test
    fun `1에서 45 사이 값이 아닌 경우 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            LottoNumber("46")
        }
        assertThat(exception.message).isSameAs("1에서 45 사이의 값을 입력하세요.")
    }
}
