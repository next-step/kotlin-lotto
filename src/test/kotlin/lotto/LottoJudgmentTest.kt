package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
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

    @ParameterizedTest
    @MethodSource("lottoNumbersAndRank")
    fun `로또 티켓을 전달하면, 등수를 반환한다`(ticketNumbers: List<Int>, rank: LottoWinnerRank) {
        val lottoJudgment = LottoJudgment(lastLottoTicket)
        val compareLotto = LottoTicket(ticketNumbers)
        assertThat(lottoJudgment.getRanking(compareLotto)).isEqualTo(rank)
    }

    @Test
    fun `로또 등수 계산 할 때 보너스 번호 유무에 따라서 2,3등을 구분한다`() {
        val bonusNumber = 10
        val lottoJudgment = LottoJudgment(lastLottoTicket, bonusNumber)

        val expectSecond = LottoTicket(listOf(1, 2, 3, 4, 5, 10))
        val expectThird = LottoTicket(listOf(1, 2, 3, 4, 5, 11))

        assertAll(
            { Assertions.assertEquals(lottoJudgment.getRanking(expectSecond), LottoWinnerRank.SECOND_PRICE) },
            { Assertions.assertEquals(lottoJudgment.getRanking(expectThird), LottoWinnerRank.THIRD_PRICE) },
        )
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
