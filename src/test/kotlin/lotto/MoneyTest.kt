package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class MoneyTest {
    @Test
    fun `돈은 음수가 될 수 없다`() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Money(-1000) }
    }
}
