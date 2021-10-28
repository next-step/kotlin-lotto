package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `로또는 개당 1000원이다`() {
        // given
        val lotto = Lotto()

        // then
        assertThat(lotto.price).isEqualTo(1000)
    }

    @Test
    fun `로또는 6개 숫자로 이루어져 있다`() {
        // given
        val lotto = Lotto(lottoNumbers = listOf(1, 2, 3, 4, 5, 6))

        // then
        assertThat(lotto.lottoNumbers.size).isEqualTo(6)
    }

    @Test
    fun `로또가 6개의 숫자로 이루어 지지 않았다면 에러`() {
        // given
        val actual = runCatching { Lotto(lottoNumbers = listOf(1, 2, 3, 4, 5, 6, 7)) }.exceptionOrNull()

        // then
        assertThat(actual).hasMessageContaining("숫자가 6개가 들어와야 합니다.")
    }
}
