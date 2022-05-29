package lotto.agency

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoJudgeTest {

    @Test
    fun `로또 1등에 당첨된 경우`() {

        val lottoTickets = listOf(
            LottoTicket(
                numbers = setOf(1, 2, 3, 4, 5, 6)
            )
        )
        val wonLottoTicket =
            LottoTicket(
                numbers = setOf(2, 4, 3, 1, 5, 6),
                bonus = 7
            )

        val lottoJudge = LottoJudge()
        val determinedLottoTicket = lottoJudge.determineLottoWinnings(lottoTickets, wonLottoTicket)

        assertThat(determinedLottoTicket[LottoWinning.FIRST_PLACE]).isEqualTo(1)
    }

    @Test
    fun `로또 2등에 당첨된 경우`() {

        val lottoTickets = listOf(
            LottoTicket(
                numbers = setOf(1, 2, 3, 4, 5, 7)
            )
        )
        val wonLottoTicket = LottoTicket(
            numbers = setOf(1, 2, 3, 4, 5, 42),
            bonus = 7
        )

        val lottoJudge = LottoJudge()
        val determinedLottoTicket = lottoJudge.determineLottoWinnings(lottoTickets, wonLottoTicket)

        assertThat(determinedLottoTicket[LottoWinning.SECOND_PLACE]).isEqualTo(1)
    }

    @Test
    fun `로또 3등에 당첨된 경우`() {

        val lottoTickets = listOf(
            LottoTicket(
                numbers = setOf(1, 2, 3, 4, 5, 6)
            )
        )
        val wonLottoTicket = LottoTicket(
            numbers = setOf(1, 2, 3, 4, 5, 10),
            bonus = 7
        )

        val lottoJudge = LottoJudge()
        val determinedLottoTicket = lottoJudge.determineLottoWinnings(lottoTickets, wonLottoTicket)

        assertThat(determinedLottoTicket[LottoWinning.THIRD_PLACE]).isEqualTo(1)
    }

    @Test
    fun `로또 4등에 당첨된 경우`() {

        val lottoTickets = listOf(
            LottoTicket(
                numbers = setOf(1, 2, 3, 4, 5, 6)
            )
        )
        val wonLottoTicket = LottoTicket(
            numbers = setOf(1, 2, 3, 4, 10, 22),
            bonus = 7
        )

        val lottoJudge = LottoJudge()
        val determinedLottoTicket = lottoJudge.determineLottoWinnings(lottoTickets, wonLottoTicket)

        assertThat(determinedLottoTicket[LottoWinning.FOURTH_PLACE]).isEqualTo(1)
    }

    @Test
    fun `로또가 당첨되지 않은 경우(보너스볼 비포함)`() {

        val lottoTickets = listOf(
            LottoTicket(
                numbers = setOf(1, 2, 3, 4, 5, 6)
            )
        )
        val wonLottoTicket = LottoTicket(
            numbers = setOf(1, 2, 23, 43, 22, 12),
            bonus = 7
        )

        val lottoJudge = LottoJudge()
        val determinedLottoTicket = lottoJudge.determineLottoWinnings(lottoTickets, wonLottoTicket)

        assertThat(determinedLottoTicket[LottoWinning.LOSE]).isEqualTo(1)
    }

    @Test
    fun `로또 4등에 당첨된 경우(보너스볼 포함)`() {

        val lottoTickets = listOf(
            LottoTicket(
                numbers = setOf(1, 2, 3, 4, 5, 7)
            )
        )
        val wonLottoTicket = LottoTicket(
            numbers = setOf(1, 2, 3, 4, 10, 22),
            bonus = 7
        )

        val lottoJudge = LottoJudge()
        val determinedLottoTicket = lottoJudge.determineLottoWinnings(lottoTickets, wonLottoTicket)

        assertThat(determinedLottoTicket[LottoWinning.FOURTH_PLACE]).isEqualTo(1)
    }

    @Test
    fun `로또가 당첨되지 않은 경우`() {

        val lottoTickets = listOf(
            LottoTicket(
                numbers = setOf(1, 2, 3, 4, 5, 6)
            )
        )
        val wonLottoTicket = LottoTicket(
            numbers = setOf(10, 1, 27, 44, 2, 7),
            bonus = 7
        )

        val lottoJudge = LottoJudge()
        val determinedLottoTicket = lottoJudge.determineLottoWinnings(lottoTickets, wonLottoTicket)

        assertThat(determinedLottoTicket[LottoWinning.LOSE]).isEqualTo(1)
    }
}
