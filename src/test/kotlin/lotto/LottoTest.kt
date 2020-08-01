package lotto

import lotto.model.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `로또 형식 체크`() {
        val lotto = Lotto()
        assertThat(lotto.numbers.size).isEqualTo(6)
    }
}
