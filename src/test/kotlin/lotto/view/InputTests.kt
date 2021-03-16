package lotto.view

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class InputTests {
    @ParameterizedTest
    @ValueSource(ints = [100, 200, 300, 400, 900, 999])
    fun `금액이 1000 보다 작으면 Exception이 발생해야 한다`(amount: Int) {
        assertThrows<IllegalArgumentException> { Input(amount) }
    }
    @ParameterizedTest
    @ValueSource(ints = [1000, 2000, 3000, 4000])
    fun `금액이 1000 보다 크면은 Exception은 발생을 안한다`(amount: Int) {
        assertDoesNotThrow { Input(amount) }
    }
}
