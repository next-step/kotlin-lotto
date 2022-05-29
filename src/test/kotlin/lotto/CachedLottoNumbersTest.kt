package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

internal class CachedLottoNumbersTest {

    @Test
    fun `객체의 값이 같으면 객체의 참조값도 같다`() {
        val load1 = CachedLottoNumbers.getLottoNumber(1)
        val load2 = CachedLottoNumbers.getLottoNumber(1)

        assertThat(load1 == load2).isTrue
    }

    @Test
    fun `1에서 45 사이의 숫자가 아니면 예외처리르 한다`() {
        assertThatIllegalArgumentException()
            .isThrownBy { CachedLottoNumbers.getLottoNumber(0) }
    }
}
