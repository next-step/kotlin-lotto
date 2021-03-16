package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTests {
    @Test
    fun `로또 생성시 6개의 숫자를 가지고 있어야 한다`() {
        val lotto: Lotto = Lotto()

        assertThat(lotto.numbers.size)
            .isEqualTo(6)
    }
}
