package lotto.domain

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 3, 10, 40, 45])
    internal fun `로또 숫자는 1~45 내에서만 생성될 수 있다(성공 케이스)`(number: Int) {
        assertDoesNotThrow { LottoNumber(number) }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 46, 50, 79])
    internal fun `로또 숫자는 1~45 내에서만 생성될 수 있다(실패 케이스)`(number: Int) {
        assertThrows<IllegalArgumentException> { LottoNumber(number) }
    }
}
