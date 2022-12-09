package simulator.lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


internal class LottoTest {
    @Test
    fun `로또를 생성할 수 있다`() {
        val lotto = Lotto(Numbers(sortedSetOf(1, 2, 3, 4, 5, 6)))

        assertThat(lotto.numbers).isEqualTo(Numbers(sortedSetOf(1, 2, 3, 4, 5, 6)))
    }

    @Test
    fun `로또번호를 String타입으로 변환할 수 있다`() {
        val lotto = Lotto(Numbers(sortedSetOf(1, 2, 3, 4, 5, 6)))

        assertThat(lotto.toString()).isEqualTo("1,2,3,4,5,6")
    }
}
