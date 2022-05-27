package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

internal class CachedLottoNumbersTest {

    @Test
    fun `동일성비교`() {
        val load1 = CachedLottoNumbers.getLottoNumber(1)
        val load2 = CachedLottoNumbers.getLottoNumber(1)

        assertThat(load1 == load2).isTrue
    }

    @Test
    fun `유효성검사`() {
        assertThatIllegalArgumentException()
            .isThrownBy { CachedLottoNumbers.getLottoNumber(0) }
    }
}
