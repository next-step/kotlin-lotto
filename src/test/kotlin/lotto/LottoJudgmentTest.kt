package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoJudgmentTest {

    private val lastLottoTicket = LottoTicket.of(
        listOf(
            LottoNumber.of(1),
            LottoNumber.of(2),
            LottoNumber.of(3),
            LottoNumber.of(4),
            LottoNumber.of(5),
            LottoNumber.of(6)
        )
    )
    private val bonusNumber = LottoNumber.of(10)

    @Test
    fun `지난주 당첨 로또로 로또 판단기를 생성한다`() {
        LottoJudgment(lastLottoTicket, bonusNumber)
    }

    @ParameterizedTest
    @MethodSource("lottoNumbersAndRank")
    fun `로또 티켓을 전달하면, 등수를 반환한다`(ticketNumbers: Set<LottoNumber>, rank: LottoWinnerRank) {
        val lottoJudgment = LottoJudgment(lastLottoTicket, bonusNumber)
        val compareLotto = LottoTicket.of(ticketNumbers)
        assertThat(lottoJudgment.getRanking(compareLotto)).isEqualTo(rank)
    }

    @Test
    fun `로또 등수 계산 할 때 보너스 번호 유무에 따라서 2,3등을 구분한다`() {
        val lottoJudgment = LottoJudgment(lastLottoTicket, bonusNumber)

        val expectSecond = LottoTicket.of(
            listOf(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
            )
        )
        val expectThird = LottoTicket.of(
            listOf(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
            )
        )

        assertAll(
            { Assertions.assertEquals(lottoJudgment.getRanking(expectSecond), LottoWinnerRank.SECOND_PRICE) },
            { Assertions.assertEquals(lottoJudgment.getRanking(expectThird), LottoWinnerRank.THIRD_PRICE) },
        )
    }

    @Test
    fun ` 2등 보너스 번호에 지난당첨 번호가 있으면 익셉션을 발생시킨다`() {
        assertThrows<IllegalArgumentException> { LottoJudgment(lastLottoTicket, lastLottoTicket.numbers.first()) }
    }

    companion object {
        @JvmStatic
        fun lottoNumbersAndRank(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(1, 2, 3, 4, 5, 6), LottoWinnerRank.FIRST_PRICE),
                Arguments.of(listOf(1, 2, 3, 4, 5, 40), LottoWinnerRank.THIRD_PRICE),
                Arguments.of(listOf(30, 2, 3, 4, 5, 40), LottoWinnerRank.FOURTH_PRICE),
                Arguments.of(listOf(30, 2, 3, 4, 15, 40), LottoWinnerRank.FIFTH_PRICE),
                Arguments.of(listOf(30, 7, 3, 4, 15, 40), LottoWinnerRank.NONE),
                Arguments.of(listOf(30, 7, 10, 4, 15, 40), LottoWinnerRank.NONE),
                Arguments.of(listOf(30, 7, 10, 11, 15, 40), LottoWinnerRank.NONE),
            )
        }

        @JvmStatic
        fun lottoNumbersAndMatchCount(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(listOf(1, 2, 3, 4, 5, 40), 5),
                Arguments.of(listOf(30, 2, 3, 4, 5, 40), 4),
                Arguments.of(listOf(30, 2, 3, 4, 15, 40), 3),
                Arguments.of(listOf(30, 7, 3, 4, 15, 40), 2),
                Arguments.of(listOf(30, 7, 10, 4, 15, 40), 1),
                Arguments.of(listOf(30, 7, 10, 11, 15, 40), 0),
            )
        }
    }
}
