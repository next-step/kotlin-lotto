package lotto

import lotto.domain.Lotto
import lotto.domain.LottoMaker
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMakerTest {
    @Test
    fun `로또를 자동 생성할 수 있다`() {
        assertThat(LottoMaker().auto()).isInstanceOf(Lotto::class.java)
    }
}
