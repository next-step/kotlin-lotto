package lotto

import lotto.domain.Lotto
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `로또를 자동 생성할 수 있다`() {
        Assertions.assertThat(Lotto.auto()).isInstanceOf(Lotto::class.java)
    }
}
