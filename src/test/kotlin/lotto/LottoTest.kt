package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {

    @Test
    fun `로또는 중복되지 않는 6개의 랜덤 숫자를 가진다`() {
        val lotto = Lotto(listOf(1, 3, 5, 6, 2, 8))

        assertThat(lotto.numbers.size).isEqualTo(5);
    }
}
