package domain

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

internal class LottoNumbersTest {
    @Test
    fun `로또숫자열은 여섯 개의 로또숫자로 생성된다`() {
        assertDoesNotThrow {
            LottoNumbers(listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(6)))
            LottoNumbers(1, 2, 3, 4, 5, 6)
        }
        assertThatIllegalArgumentException().isThrownBy { LottoNumbers(listOf(LottoNumber(1))) }
        assertThatIllegalArgumentException().isThrownBy { LottoNumbers(listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(6), LottoNumber(7))) }
    }
}
