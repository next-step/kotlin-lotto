package domain

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

internal class LottoNumberTest {
    @Test
    fun `로또숫자는 정수를 입력받아 생성한다`() {
        assertDoesNotThrow { LottoNumber(1) }
    }

    @Test
    fun `로또숫자의 범위는 1부터 45까지의 정수이다`() {
        assertThatIllegalArgumentException().isThrownBy { LottoNumber(0) }
        assertThatIllegalArgumentException().isThrownBy { LottoNumber(-1) }
        assertThatIllegalArgumentException().isThrownBy { LottoNumber(46) }
        assertThatIllegalArgumentException().isThrownBy { LottoNumber(47) }
        assertDoesNotThrow { (1..45).forEach { LottoNumber(it) } }
    }
}
