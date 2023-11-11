package lotto.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class InputViewTest {
    @Test
    fun `숫자 포맷이 아닌 구매 금액을 입력받았다면, 입력 금액 검증을 했을 때, 에러를 던진다`() {
        // given :
        val cash = "10000a"

        // when :
        val actual = runCatching { InputView.validateCash(cash) }.exceptionOrNull()

        // then :
        assertThat(actual).isInstanceOf(IllegalArgumentException()::class.java)
    }
}
