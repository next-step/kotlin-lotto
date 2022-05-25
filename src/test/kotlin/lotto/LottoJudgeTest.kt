package lotto

import lotto.agency.LottoJudge
import lotto.agency.LottoTicket
import lotto.agency.LottoWinning
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoJudgeTest {

    @Test
    fun `로또 1등에 당첨된 경우`() {

        val lottoTickets = listOf(LottoTicket(listOf(1, 2, 3, 4, 5, 6)))
        val wonLottoTicket = LottoTicket(listOf(2, 4, 3, 1, 5, 6))

        val lottoJudge = LottoJudge()
        val determinedLottoTicket = lottoJudge.determineLottoWinnings(lottoTickets, wonLottoTicket)

        assertThat(determinedLottoTicket[LottoWinning.FIRST_PLACE]).isEqualTo(1)
    }

    @Test
    fun `로또 2등에 당첨된 경우`() {

        val lottoTickets = listOf(LottoTicket(listOf(1, 2, 3, 4, 5, 6)))
        val wonLottoTicket = LottoTicket(listOf(6, 1, 3, 4, 2, 7))

        val lottoJudge = LottoJudge()
        val determinedLottoTicket = lottoJudge.determineLottoWinnings(lottoTickets, wonLottoTicket)

        assertThat(determinedLottoTicket[LottoWinning.SECOND_PLACE]).isEqualTo(1)
    }

    @Test
    fun `로또 3등에 당첨된 경우`() {

        val lottoTickets = listOf(LottoTicket(listOf(1, 2, 3, 4, 5, 6)))
        val wonLottoTicket = LottoTicket(listOf(10, 1, 3, 4, 2, 7))

        val lottoJudge = LottoJudge()
        val determinedLottoTicket = lottoJudge.determineLottoWinnings(lottoTickets, wonLottoTicket)

        assertThat(determinedLottoTicket[LottoWinning.THIRD_PLACE]).isEqualTo(1)
    }

    @Test
    fun `로또 4등에 당첨된 경우`() {

        val lottoTickets = listOf(LottoTicket(listOf(1, 2, 3, 4, 5, 6)))
        val wonLottoTicket = LottoTicket(listOf(10, 1, 27, 4, 2, 7))

        val lottoJudge = LottoJudge()
        val determinedLottoTicket = lottoJudge.determineLottoWinnings(lottoTickets, wonLottoTicket)

        assertThat(determinedLottoTicket[LottoWinning.FOURTH_PLACE]).isEqualTo(1)
    }

    @Test
    fun `로또가 당첨되지 않은 경우`() {

        val lottoTickets = listOf(LottoTicket(listOf(1, 2, 3, 4, 5, 6)))
        val wonLottoTicket = LottoTicket(listOf(10, 1, 27, 44, 2, 7))

        val lottoJudge = LottoJudge()
        val determinedLottoTicket = lottoJudge.determineLottoWinnings(lottoTickets, wonLottoTicket)

        assertThat(determinedLottoTicket[LottoWinning.LOSE]).isEqualTo(1)
    }
}
