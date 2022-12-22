package lotto.model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

internal class BonusNumberTest {
    @Test
    fun `보너스 번호가 숫자가 아니면 예외가 발생한다`() {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            LottoNumber("A")
        }
        Assertions.assertEquals("숫자만 입력 가능합니다.", exception.message)
    }
}
