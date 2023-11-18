package specific.lotto.domain

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NumberTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `로또 번호(당첨 번호)는 1~45 중 하나이다`(value: Int) {
        // given, when, then
        assertThrows<IllegalArgumentException> { Number(value) }
    }
}
