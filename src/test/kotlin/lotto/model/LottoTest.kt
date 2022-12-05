package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    internal fun `로또 숫자들은 6개로 구성된다`() {
        val lotto = Lotto.of(1, 2, 3, 4, 5, 6)
        assertThat(lotto.size).isEqualTo(6)
    }

    @Test
    internal fun `로또 숫자들은 중복이 될 수 없다`() {
        assertThrows<IllegalArgumentException> { Lotto.of(1, 1, 3, 4, 5, 6) }
    }
}
