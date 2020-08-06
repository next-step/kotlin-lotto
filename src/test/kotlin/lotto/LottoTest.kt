package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    internal fun create() {
        val lotto = Lotto.of(1, 2, 3, 4, 5, 6)
        assertThat(lotto)
    }
}
