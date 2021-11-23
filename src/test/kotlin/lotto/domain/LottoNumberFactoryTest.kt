package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoNumberFactoryTest {
    @Test
    fun `로또번호들을 1부터 45까지 생성한다`() {
        assertThat(LottoNumberFactory.numbers())
            .containsExactly(*(LottoNumberFactory.NUMBER_FROM..LottoNumberFactory.NUMBER_TO)
                .map { LottoNumber(it) }
                .toTypedArray())
    }
}
