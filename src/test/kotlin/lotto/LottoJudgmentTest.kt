package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoJudgmentTest {

    private val lastLottoTicket = LottoTicket(listOf(1, 2, 3, 4, 5, 6))

    @Test
    fun `지난주 당첨 로또로 로또 판단기를 생성한다`() {
        LottoJudgment(lastLottoTicket)
    }

    @ParameterizedTest
    @MethodSource("lottoNumbersAndMatchCount")
    fun `지난주 당첨 번호와 일치하는 갯수를 확인한다`(numbers: List<Int>, matchCount: Int) {
        val myLottoTicket = LottoTicket(numbers)

        val lottoJudgment = LottoJudgment(lastLottoTicket)

        val matchNumberCount = lottoJudgment.matchNumberCount(myLottoTicket)
        assertThat(matchNumberCount).isEqualTo(matchCount)
    }

    @Test
    fun `당첨 번호와 일치하는 번호 갯수에 따라 로또 등수와 금액을 반환한다`() {
        val lottoJudgment = LottoJudgment(lastLottoTicket)

        assertThat(lottoJudgment.getRanking(6)).isEqualTo(LottoWinnerRank.FIRST_PRICE)
        assertThat(lottoJudgment.getRanking(5)).isEqualTo(LottoWinnerRank.SECOND_PRICE)
        assertThat(lottoJudgment.getRanking(4)).isEqualTo(LottoWinnerRank.THIRD_PRICE)
        assertThat(lottoJudgment.getRanking(3)).isEqualTo(LottoWinnerRank.FOURTH_PRICE)
        assertThat(lottoJudgment.getRanking(2)).isEqualTo(LottoWinnerRank.NONE)
        assertThat(lottoJudgment.getRanking(1)).isEqualTo(LottoWinnerRank.NONE)
        assertThat(lottoJudgment.getRanking(0)).isEqualTo(LottoWinnerRank.NONE)
    }

    @ParameterizedTest
    @MethodSource("lottoNumbersAndRank")
    fun `로또 티켓을 전달하면, 등수를 반환한다`(ticketNumbers: List<Int>, rank: LottoWinnerRank) {
        val lottoJudgment = LottoJudgment(lastLottoTicket)

        val compareLotto = LottoTicket(ticketNumbers)

        assertThat(lottoJudgment.getRanking(compareLotto)).isEqualTo(rank)
    }

    companion object {
        @JvmStatic
        fun lottoNumbersAndRank(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(1, 2, 3, 4, 5, 6), LottoWinnerRank.FIRST_PRICE),
                Arguments.of(listOf(1, 2, 3, 4, 5, 40), LottoWinnerRank.SECOND_PRICE),
                Arguments.of(listOf(30, 2, 3, 4, 5, 40), LottoWinnerRank.THIRD_PRICE),
                Arguments.of(listOf(30, 2, 3, 4, 15, 40), LottoWinnerRank.FOURTH_PRICE),
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
