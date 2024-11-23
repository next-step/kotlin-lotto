package lotto

import lotto.domain.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `로또 생성 테스트`() {
        val lotto = Lotto({ listOf(1, 2, 3, 4, 7) })
        assertThat(lotto.numbers).containsExactly(1, 2, 3, 4, 7)
    }
}
