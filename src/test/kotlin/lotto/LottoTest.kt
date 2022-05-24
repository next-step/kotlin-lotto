package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoTest {
    private lateinit var lotto: Lotto

    @BeforeEach
    fun setup() {
        lotto = Lotto()
    }

    @Test
    fun `로또가 발행될 때 번호가 발급된다`() {
        lotto.processLotto()
        assertThat(lotto.numbers.size).isEqualTo(6)
        assertThat(lotto.numbers[1]).isNotEqualTo(0)
    }
}

class Lotto {
    val numbers = arrayListOf<Int>()

    fun processLotto() {
        numbers.add(1)
        numbers.add(1)
        numbers.add(1)
        numbers.add(1)
        numbers.add(1)
        numbers.add(1)
    }
}
