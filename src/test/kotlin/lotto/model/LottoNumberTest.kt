package lotto.model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

internal class LottoNumberTest {
    @Test
    fun `숫자가 아닌 값을 입력하면 예외가 발생한다`() {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            LottoNumber("A")
        }
        Assertions.assertEquals("숫자만 입력 가능합니다.", exception.message)
    }

    @Test
    fun `1에서 45 사이 값이 아닌 경우 예외가 발생한다`() {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            LottoNumber("46")
        }
        Assertions.assertEquals("1에서 45 사이의 값을 입력하세요.", exception.message)
    }
}
