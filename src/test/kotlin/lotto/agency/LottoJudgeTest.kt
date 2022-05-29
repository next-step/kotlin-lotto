package lotto.agency

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoJudgeTest {

    @Test
    fun `로또 1등에 당첨된 경우`() {

        val lottoTickets = listOf(
            LottoTicket(
                numbers = setOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6)
                )
            )
        )
        val wonLottoTicket =
            LottoTicket(
                numbers = setOf(
                    LottoNumber(2),
                    LottoNumber(4),
                    LottoNumber(3),
                    LottoNumber(1),
                    LottoNumber(5),
                    LottoNumber(6)
                ),
                bonus = LottoNumber(7)
            )

        val lottoJudge = LottoJudge()
        val determinedLottoTicket = lottoJudge.determineLottoWinnings(lottoTickets, wonLottoTicket)

        assertThat(determinedLottoTicket[LottoWinning.FIRST_PLACE]).isEqualTo(1)
    }

    @Test
    fun `로또 2등에 당첨된 경우`() {

        val lottoTickets = listOf(
            LottoTicket(
                numbers = setOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(7)
                )
            )
        )
        val wonLottoTicket = LottoTicket(
            numbers = setOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(10)
            ),
            bonus = LottoNumber(7)
        )

        val lottoJudge = LottoJudge()
        val determinedLottoTicket = lottoJudge.determineLottoWinnings(lottoTickets, wonLottoTicket)

        assertThat(determinedLottoTicket[LottoWinning.SECOND_PLACE]).isEqualTo(1)
    }

    @Test
    fun `로또 3등에 당첨된 경우`() {

        val lottoTickets = listOf(
            LottoTicket(
                numbers = setOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6)
                )
            )
        )
        val wonLottoTicket = LottoTicket(
            numbers = setOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(10)
            ),
            bonus = LottoNumber(7)
        )

        val lottoJudge = LottoJudge()
        val determinedLottoTicket = lottoJudge.determineLottoWinnings(lottoTickets, wonLottoTicket)

        assertThat(determinedLottoTicket[LottoWinning.THIRD_PLACE]).isEqualTo(1)
    }

    @Test
    fun `로또 4등에 당첨된 경우`() {

        val lottoTickets = listOf(
            LottoTicket(
                numbers = setOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6)
                )
            )
        )
        val wonLottoTicket = LottoTicket(
            numbers = setOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(10),
                LottoNumber(22)
            ),
            bonus = LottoNumber(7)
        )

        val lottoJudge = LottoJudge()
        val determinedLottoTicket = lottoJudge.determineLottoWinnings(lottoTickets, wonLottoTicket)

        assertThat(determinedLottoTicket[LottoWinning.FOURTH_PLACE]).isEqualTo(1)
    }

    @Test
    fun `로또가 당첨되지 않은 경우(보너스볼 비포함)`() {

        val lottoTickets = listOf(
            LottoTicket(
                numbers = setOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6)
                )
            )
        )
        val wonLottoTicket = LottoTicket(
            numbers = setOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(23),
                LottoNumber(43),
                LottoNumber(22),
                LottoNumber(12)
            ),
            bonus = LottoNumber(7)
        )

        val lottoJudge = LottoJudge()
        val determinedLottoTicket = lottoJudge.determineLottoWinnings(lottoTickets, wonLottoTicket)

        assertThat(determinedLottoTicket[LottoWinning.LOSE]).isEqualTo(1)
    }

    @Test
    fun `로또 4등에 당첨된 경우(보너스볼 포함)`() {

        val lottoTickets = listOf(
            LottoTicket(
                numbers = setOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(7)
                )
            )
        )
        val wonLottoTicket = LottoTicket(
            numbers = setOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(10),
                LottoNumber(22)
            ),
            bonus = LottoNumber(7)
        )

        val lottoJudge = LottoJudge()
        val determinedLottoTicket = lottoJudge.determineLottoWinnings(lottoTickets, wonLottoTicket)

        assertThat(determinedLottoTicket[LottoWinning.FOURTH_PLACE]).isEqualTo(1)
    }

    @Test
    fun `로또가 당첨되지 않은 경우`() {

        val lottoTickets = listOf(
            LottoTicket(
                numbers = setOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6)
                )
            )
        )
        val wonLottoTicket = LottoTicket(
            numbers = setOf(
                LottoNumber(10),
                LottoNumber(1),
                LottoNumber(27),
                LottoNumber(44),
                LottoNumber(2),
                LottoNumber(7)
            ),
            bonus = LottoNumber(7)
        )

        val lottoJudge = LottoJudge()
        val determinedLottoTicket = lottoJudge.determineLottoWinnings(lottoTickets, wonLottoTicket)

        assertThat(determinedLottoTicket[LottoWinning.LOSE]).isEqualTo(1)
    }
}
