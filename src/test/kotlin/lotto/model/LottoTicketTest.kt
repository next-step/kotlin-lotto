package lotto.model

import lotto.service.LottoGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTicketTest {
    @Test
    fun `수동로또 티켓을 로또로 변환한다`() {
        // given
        val numbers = listOf(
            "1,2,3,4,5,6",
            "7,8,9,10,11,12",
            "13,14,15,16,17,18"
        )
        val manualTicket = LottoTicket.of(numbers)
        val expectedLottos = Lottos(numbers.map(LottoGenerator::fromString))

        // when
        val lottos = manualTicket.toLottos()

        assertThat(lottos.size).isEqualTo(expectedLottos.size)
        lottos.forEachIndexed { index, lotto ->
            val expectedLotto = expectedLottos[index]
            assertThat(lotto).containsExactlyInAnyOrderElementsOf(expectedLotto)
        }
    }

    @Test
    fun `빈 티켓을 랜덤로또로 변환한다`() {
        // given
        val lottoCount = 10
        val blankTicket = LottoTicket.getBlankTicket(lottoCount)

        // when
        val lottos = blankTicket.toRandomLottos()

        // then
        assertThat(lottos.size).isEqualTo(10)
    }

    @Test
    fun `빈 티켓을 수동로또로 변환할 수 없다`() {
        // given
        val lottoCount = 2

        // when
        val blankTicket = LottoTicket.getBlankTicket(lottoCount)

        // then
        assertThrows<IllegalArgumentException> { blankTicket.toLottos() }
    }
}
