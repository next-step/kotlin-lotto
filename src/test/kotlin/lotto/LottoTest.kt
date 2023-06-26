package lotto

import lotto.domain.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `로또를 자동 생성할 수 있다`() {
        assertThat(Lotto.autoCreate()).isInstanceOf(Lotto::class.java)
    }

    @Test
    fun `로또를 수동 생성할 수 있다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        assertThat(Lotto.manualCreate(numbers)).isInstanceOf(Lotto::class.java)
    }
}
