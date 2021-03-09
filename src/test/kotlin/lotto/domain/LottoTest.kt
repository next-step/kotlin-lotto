package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoTest {

    @Test
    fun `로또번호의 갯수는 6이다`() {
        assertThat(Lotto().lottoNumbers.size).isEqualTo(6)
    }
}
