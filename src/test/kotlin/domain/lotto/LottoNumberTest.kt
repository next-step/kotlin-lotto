package domain.lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoNumberTest {
    @Test
    fun `로또숫자는 정수를 통해 생성할 수 있다`() {
        assertDoesNotThrow { LottoNumber.parse(1) }
    }

    @Test
    fun `로또숫자의 범위는 1부터 45까지의 정수이다`() {
        assertThat(LottoNumber.values().map { it.value }).containsExactlyElementsOf((1..45))
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1, 46, 47])
    fun `로또숫자의 범위 이외의 수로 생성할 수 없다`(number: Int) {
        assertThatIllegalArgumentException().isThrownBy { LottoNumber.parse(number) }
    }

    @Test
    fun `로또숫자는 서로 대소 비교를 할 수 있다`() {
        assertThat(LottoNumber.N01).isLessThan(LottoNumber.N02)
        assertThat(LottoNumber.N03).isGreaterThan(LottoNumber.N02)
    }
}
