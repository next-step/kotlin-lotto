package domain

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoNumbersTest {
    @Test
    fun `로또숫자열은 여섯 개의 로또숫자로 생성된다`() {
        assertDoesNotThrow {
            LottoNumbers((1..6).map { LottoNumber(it) })
            LottoNumbers(1, 2, 3, 4, 5, 6)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 3, 5, 7])
    fun `로또숫자열은 숫자 6개 이외로는 생성할 수 없다`(lottoNumberCount: Int) {
        assertThatIllegalArgumentException()
            .isThrownBy { LottoNumbers((1..lottoNumberCount).map { LottoNumber(it) }) }
    }
}
