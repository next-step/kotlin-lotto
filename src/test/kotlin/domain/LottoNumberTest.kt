package domain

import org.assertj.core.api.Assertions.assertThat
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

    @Test
    fun `로또숫자의 범위는 1부터 45까지의 정수이다`() {
        assertDoesNotThrow { (1..45).forEach { LottoNumber(it) } }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1, 46, 47])
    fun `로또숫자의 범위 이외의 수로 생성할 수 없다`(number: Int) {
        assertThatIllegalArgumentException().isThrownBy { LottoNumber(number) }
    }

    @Test
    fun `로또숫자는 서로 다른 객체라도, 값이 같으면 동일하다`() {
        assertThat(LottoNumber(1)).isEqualTo(LottoNumber(1))
    }

    @Test
    fun `로또숫자는 서로 대소 비교를 할 수 있다`() {
        assertThat(LottoNumber(1)).isLessThan(LottoNumber(2))
        assertThat(LottoNumber(3)).isGreaterThan(LottoNumber(2))
    }
}
