package specific.lotto.domain

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class MoneyTest {
    @ParameterizedTest
    @ValueSource(strings = ["0.1", "tes", "-10"])
    fun `돈은 0 또는 양의 정수이다, else throw IllegalArgumentException`(principal: String) {
        // given, when, then
        assertThrows<IllegalArgumentException> { Money(principal) }
    }
}
