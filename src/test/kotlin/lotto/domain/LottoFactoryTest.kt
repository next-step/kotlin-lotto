package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * Created by Jaesungchi on 2022.05.25..
 */
class LottoFactoryTest {
    @Test
    internal fun `로또 번호 6개를 자동 발행한다`() {
        assertThat(LottoFactory.getRandomLottoTicket().numbers.size).isEqualTo(6)
    }
}
