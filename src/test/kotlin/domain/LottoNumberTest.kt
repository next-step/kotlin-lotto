package domain

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoNumberTest {
    @Test
    fun `로또숫자는 정수를 입력받아 생성한다`() {
        assertDoesNotThrow { LottoNumber(1) }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1, 46, 47])
    fun `로또숫자의 범위는 1부터 45까지의 정수이다`(number: Int) {
        assertThatIllegalArgumentException().isThrownBy { LottoNumber(number) }
        assertDoesNotThrow { (1..45).forEach { LottoNumber(it) } }
    }
}
