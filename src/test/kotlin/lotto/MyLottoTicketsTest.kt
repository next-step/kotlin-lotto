package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.provider.Arguments
import java.util.stream.Stream

class MyLottoTicketsTest {

    @Test
    fun `구매한 로또의 당첨 결과를 확인한다`() {
        val myLotto = LottoTicket.of(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.of(it) })
        val lastWinLotto = LottoTicket.of(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.of(it) })
        val bonusNumber = LottoNumber.of(45)

        val myLottoTickets = MyLottoTickets(
            listOf(
                myLotto
            )
        )
        val lottoJudgment = LastWinningLotto(lastWinLotto, bonusNumber)
        val myLottoResult: MyLottoResult = myLottoTickets.getMyLottoResult(lottoJudgment)

        val expectedLottoResult = MyLottoResult(mapOf(LottoWinnerRank.FIRST_PRICE to 1))
        assertThat(myLottoResult).isEqualTo(expectedLottoResult)
    }
//
//    @ParameterizedTest
//    @MethodSource("lottoNumbersAndRank")
//    fun `로또 티켓을 전달하면, 등수를 반환한다`(ticketNumbers: List<LottoNumber>, rank: LottoWinnerRank) {
//        val lottoJudgment = LastWinningLotto(lastLottoTicket, bonusNumber)
//        val compareLotto = LottoTicket.of(ticketNumbers)
//        assertThat(lottoJudgment.getRanking(compareLotto)).isEqualTo(rank)
//    }

//    @Test
//    fun `로또 등수 계산 할 때 보너스 번호 유무에 따라서 2,3등을 구분한다`() {
//        val lottoJudgment = LastWinningLotto(lastLottoTicket, bonusNumber)
//
//        val expectSecond = listOf(1, 2, 3, 4, 5, 10)
//            .map(LottoNumber::of)
//            .let(LottoTicket::of)
//
//        val expectThird = listOf(1, 2, 3, 4, 5, 11)
//            .map(LottoNumber::of)
//            .let(LottoTicket::of)
//
//        assertAll(
//            { Assertions.assertEquals(lottoJudgment.getRanking(expectSecond), LottoWinnerRank.SECOND_PRICE) },
//            { Assertions.assertEquals(lottoJudgment.getRanking(expectThird), LottoWinnerRank.THIRD_PRICE) },
//        )
//    }

    companion object {
        @JvmStatic
        fun lottoNumbersAndRank(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(1, 2, 3, 4, 5, 6).map(LottoNumber::of), LottoWinnerRank.FIRST_PRICE),
                Arguments.of(listOf(1, 2, 3, 4, 5, 40).map(LottoNumber::of), LottoWinnerRank.THIRD_PRICE),
                Arguments.of(listOf(30, 2, 3, 4, 5, 40).map(LottoNumber::of), LottoWinnerRank.FOURTH_PRICE),
                Arguments.of(listOf(30, 2, 3, 4, 15, 40).map(LottoNumber::of), LottoWinnerRank.FIFTH_PRICE),
                Arguments.of(listOf(30, 7, 3, 4, 15, 40).map(LottoNumber::of), LottoWinnerRank.NONE),
                Arguments.of(listOf(30, 7, 10, 4, 15, 40).map(LottoNumber::of), LottoWinnerRank.NONE),
                Arguments.of(listOf(30, 7, 10, 11, 15, 40).map(LottoNumber::of), LottoWinnerRank.NONE),
            )
        }

        @JvmStatic
        fun lottoNumbersAndMatchCount(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(1, 2, 3, 4, 5, 6).map(LottoNumber::of), 6),
                Arguments.of(listOf(1, 2, 3, 4, 5, 40).map(LottoNumber::of), 5),
                Arguments.of(listOf(30, 2, 3, 4, 5, 40).map(LottoNumber::of), 4),
                Arguments.of(listOf(30, 2, 3, 4, 15, 40).map(LottoNumber::of), 3),
                Arguments.of(listOf(30, 7, 3, 4, 15, 40).map(LottoNumber::of), 2),
                Arguments.of(listOf(30, 7, 10, 4, 15, 40).map(LottoNumber::of), 1),
                Arguments.of(listOf(30, 7, 10, 11, 15, 40).map(LottoNumber::of), 0),
            )
        }
    }
}
