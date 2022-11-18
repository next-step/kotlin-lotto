package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoTicketTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 4, 6, 10])
    fun `로또 수만큼 로또 번호 생성`(count: Int) {
        val lottoTicket = LottoTicket(count)
        assertThat(lottoTicket.lottoList.size).isEqualTo(count)
    }
}
