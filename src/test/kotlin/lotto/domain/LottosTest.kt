package lotto.domain

import lotto.domain.`interface`.LottoRandomNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottosTest {
    @Test
    fun `주어진 로또 숫자의 리스트만큼 로또 티켓을 생성할 수 있다`() {
        val lottoNumbers = listOf(
            LottoRandomNumbers().createNumbers(),
            LottoRandomNumbers().createNumbers()
        )

        assertThat(Lottos.of(lottoNumbers).tickets.size).isEqualTo(2)
    }
}
