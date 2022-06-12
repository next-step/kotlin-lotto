package lotto.domain

import lotto.domain.interfaces.LottoNumberGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottosTest {
    @Test
    fun `주어진 로또 숫자의 리스트만큼 로또 티켓을 생성할 수 있다`() {
        val lottoNumbers = listOf(
            LottoNumberGenerator().createNumbers(),
            LottoNumberGenerator().createNumbers()
        )

        assertThat(Lottos.of(lottoNumbers).tickets.size).isEqualTo(2)
    }
}
