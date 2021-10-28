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
}
