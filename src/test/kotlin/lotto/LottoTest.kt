package lotto

import lotto.domain.Lotto
import lotto.domain.Lotto.Companion.NUMBER_OF_LOTTO_NUMBERS
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

    @Test
    fun `하나의 로또는 6개의 로또 번호로 구성된다`() {
        val autoCreate = Lotto.autoCreate()
        assertThat(autoCreate.numbers.size).isEqualTo(NUMBER_OF_LOTTO_NUMBERS)
    }
}
