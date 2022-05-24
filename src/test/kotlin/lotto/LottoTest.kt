package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoTest {

    @Test
    fun `로또는 6개의 숫자를 갖는다`() {
        assertThat(Lotto().numbers.size).isEqualTo(6)
    }

    @Test
    fun `로또는 6개의 중복되지 않는 숫자를 갖는다`() {
        assertThat(Lotto().numbers.distinct()).isEqualTo(6)
    }
}
