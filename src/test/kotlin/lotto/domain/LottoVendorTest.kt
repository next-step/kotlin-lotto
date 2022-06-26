package lotto.domain

import lotto.fixture.manualLotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoVendorTest {
    @Test
    fun `수동 로또가 없으면 자동 로또 티켓만 생성한다`() {
        // given

        // when
        val lottoTickets = LottoVendor.generate(3, manualLotto())

        // then
        assertThat(lottoTickets.lottoTickets.size).isEqualTo(3)
    }

    @Test
    fun `수동 로또만 있으면 수동 로또 티켓만 발급한다`() {
        // given
        val manualLottos = manualLotto(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 7)
        )

        // when
        val lottoTickets = LottoVendor.generate(0, manualLottos)

        // then
        assertThat(lottoTickets.lottoTickets.size).isEqualTo(2)
        assertThat(lottoTickets.toInts()).isEqualTo(manualLottos.lottos.toInts())
    }

    @Test
    fun `수동 로또가 있으면 자동 로또과 수동 로또가 합쳐진 로또티켓을 발급한다`() {
        // given
        val manualLottos = manualLotto(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 7)
        )

        // when
        val lottoTickets = LottoVendor.generate(1, manualLottos)

        // then
        assertThat(lottoTickets.lottoTickets.size).isEqualTo(3)
        assertThat(lottoTickets.toInts()).containsAll(manualLottos.lottos.toInts())
    }
}
