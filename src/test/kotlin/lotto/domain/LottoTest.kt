package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LottoTest {

    @Test
    internal fun `로또 1장은 1~45까지의 숫자 6개로 이뤄져있다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.numbers).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
        assertThrows<IllegalArgumentException> { Lotto(listOf(1, 2, 3, 4, 5, 46)) }
        assertThrows<IllegalArgumentException> { Lotto(listOf(1, 2, 3, 4, 5, 6, 7)) }
        assertThrows<IllegalArgumentException> { Lotto(listOf(1)) }
    }
}
