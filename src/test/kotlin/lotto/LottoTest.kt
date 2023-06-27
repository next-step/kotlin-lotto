package lotto

import lotto.domain.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

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

    @Test
    fun `로또를 구성하는 번호는 중복되면 IllegalArgumentException`() {
        val numbers = listOf(1, 1, 3, 4, 5, 6)
        assertThrows<IllegalArgumentException> {
            Lotto.manualCreate(numbers)
        }
    }
}
