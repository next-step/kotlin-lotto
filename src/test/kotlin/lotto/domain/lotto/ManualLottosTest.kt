package lotto.domain.lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ManualLottosTest {
    @Test
    fun `ManualLottos 생성자는 전달 받은 수동 번호가 없으면 빈 로또 티켓을 생성한다`() {
        // given

        // when
        val manualLottos = ManualLottos(emptyList())

        // then
        assertThat(manualLottos.lottos.lottoTickets.size).isEqualTo(0)
    }

    @Test
    fun `ManualLottos 생성자는 전달 받은 수동 번호를 로또 번호로 변환시킨다`() {
        // given
        val manualNumbers = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 7)
        )

        // when
        val manualLottos = ManualLottos(manualNumbers)

        // then
        assertThat(manualLottos.lottos.lottoTickets.size).isEqualTo(2)
        assertThat(manualLottos.lottos.toInts()).isEqualTo(manualNumbers)
    }

    @Test
    fun `ManualLottos(수동 로또)의 전체 티켓 수를 알려준다`() {
        // given
        val manualNumbers = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 7)
        )

        // when
        val manualLottoCount = ManualLottos(manualNumbers).count()

        // then
        assertThat(manualLottoCount).isEqualTo(2)
    }
}
