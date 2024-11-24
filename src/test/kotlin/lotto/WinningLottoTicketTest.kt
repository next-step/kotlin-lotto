package lotto

import lotto.domain.LottoPurchaseInfo
import lotto.domain.LottoTickets
import lotto.domain.WinningLottoTicket
import lotto.domain.rank.Rank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningLottoTicketTest {
    @Test
    fun `당첨 번호와 보너스 번호를 입력받아 당첨 티켓을 생성한다`() {
        val winningNumbers = setOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val winningLottoTicketTest = WinningLottoTicket(winningNumbers, bonusNumber)

        assertThat(winningLottoTicketTest.winningNumbers.size).isEqualTo(6)
        assertThat(winningLottoTicketTest.bonusNumber).isEqualTo(7)
    }

    @Test
    fun `당첨 번호가 6개가 아니라면 예외를 발생시킨다`() {
        val winningNumbers = setOf(1, 2, 3, 4, 5)
        val bonusNumber = 7

        assertThrows<IllegalArgumentException>(message = "로또 번호는 6개여야 합니다.") {
            WinningLottoTicket(winningNumbers, bonusNumber)
        }
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복되면 예외를 발생시킨다`() {
        val winningNumbers = setOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 6

        assertThrows<IllegalArgumentException>(message = "보너스 번호는 당첨 번호와 중복되면 안됩니다.") {
            WinningLottoTicket(winningNumbers, bonusNumber)
        }
    }

    @Test
    fun `로또 티켓들의 정보를 받아 당첨정보를 계산한다`() {
        // given
        val winningLottoTicket =
            WinningLottoTicket(
                winningNumbers = setOf(1, 2, 3, 4, 5, 6),
                bonusNumber = 7,
            )

        val lottoTickets =
            LottoTickets(
                LottoPurchaseInfo(
                    money = 6_000,
                    manualLottoCount = 6,
                ),
                manualNumbers =
                listOf(
                    setOf(1, 2, 3, 4, 5, 6),
                    setOf(1, 2, 3, 4, 5, 7),
                    setOf(1, 2, 3, 4, 5, 8),
                    setOf(1, 2, 3, 4, 8, 9),
                    setOf(1, 2, 3, 10, 11, 12),
                    setOf(25, 26, 27, 28, 29, 30),
                ),
            )

        // when
        val lottoResult = winningLottoTicket.matchTickets(lottoTickets)

        // then
        lottoResult[Rank.FIRST]!!.let { assertThat(it).isEqualTo(1) }
        lottoResult[Rank.SECOND]!!.let { assertThat(it).isEqualTo(1) }
        lottoResult[Rank.THIRD]!!.let { assertThat(it).isEqualTo(1) }
        lottoResult[Rank.FOURTH]!!.let { assertThat(it).isEqualTo(1) }
        lottoResult[Rank.FIFTH]!!.let { assertThat(it).isEqualTo(1) }
        lottoResult[Rank.NONE]!!.let { assertThat(it).isEqualTo(1) }
    }
}
