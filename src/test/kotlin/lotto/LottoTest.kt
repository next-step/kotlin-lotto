package lotto

import lotto.domain.Lotto
import lotto.domain.Lotto.Companion.NUMBER_OF_LOTTO_NUMBERS
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `로또를 자동 생성할 수 있다`() {
        assertThat(Lotto.autoCreate()).isInstanceOf(Lotto::class.java)
    }

    @Test
    fun `하나의 로또는 6개의 로또 번호로 구성된다`() {
        assertThat(Lotto.autoCreate().numbers.size).isEqualTo(NUMBER_OF_LOTTO_NUMBERS)
    }
}
