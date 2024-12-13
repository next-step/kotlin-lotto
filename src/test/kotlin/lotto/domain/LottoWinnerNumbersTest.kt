package lotto.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.matchers.equals.shouldBeEqual
import lotto.domain.LottoNumber.Companion.INVALID_LOTTO_NUMBER_MESSAGE
import lotto.domain.LottoNumbers.Companion.INVALID_LOTTO_NUMBER_COUNT_MESSAGE
import lotto.domain.LottoTicket.ManualLottoTicket
import lotto.domain.LottoWinnerNumbers.Companion.INVALID_WINNER_NUMBERS_MESSAGE
import lotto.util.createLottoNumbers
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LottoWinnerNumbersTest {
    @Test
    fun `로또 당첨 번호가 1부터 45사이의 숫자가 아닐 경우 에러가 발생한다`() {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_LOTTO_NUMBER_MESSAGE) {
            LottoWinnerNumbers(createLottoNumbers(1, 2, 3, 4, 5, 46), LottoNumber.of(7))
        }
    }

    @Test
    fun `로또 당첨 번호가 6개가 아닐 경우 에러가 발생한다`() {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_LOTTO_NUMBER_COUNT_MESSAGE) {
            LottoWinnerNumbers(createLottoNumbers(1, 2, 3, 4, 5, 6, 7), LottoNumber.of(8))
        }
    }

    @Test
    fun `당첨 번호와 보너스 번호가 중복되면 에러가 발생한다`() {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_WINNER_NUMBERS_MESSAGE) {
            LottoWinnerNumbers(createLottoNumbers(1, 2, 3, 4, 5, 6), LottoNumber.of(1))
        }
    }

    @MethodSource("당첨 로또 번호, 보너스 번호, 구매한 로또 티켓, 매칭 결과 및 수익률 제공")
    @ParameterizedTest
    fun `구매한 로또 번호가 당첨 번호와 몇개가 일치하는지와 수익률 등 결과 확인`(
        winnerNumbers: LottoNumbers,
        bonusNumber: Int,
        purchasedLottoTickets: LottoTickets,
        firstRankCount: Int,
        secondRankCount: Int,
        thirdRankCount: Int,
        fourthRankCount: Int,
        fifthRankCount: Int,
        profitMargin: Double,
    ) {
        val lottoWinnerNumbers = LottoWinnerNumbers(winnerNumbers, LottoNumber.of(bonusNumber))
        val purchasedLottoResults = lottoWinnerNumbers.resultLottoPayout(purchasedLottoTickets)

        purchasedLottoResults.firstRankCount shouldBeEqual firstRankCount
        purchasedLottoResults.secondRankCount shouldBeEqual secondRankCount
        purchasedLottoResults.thirdRankCount shouldBeEqual thirdRankCount
        purchasedLottoResults.fourthRankCount shouldBeEqual fourthRankCount
        purchasedLottoResults.fifthRankCount shouldBeEqual fifthRankCount
        purchasedLottoResults.getProfitMargin() shouldBeEqual profitMargin
    }

    fun `당첨 로또 번호, 보너스 번호, 구매한 로또 티켓, 매칭 결과 및 수익률 제공`(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(
                createLottoNumbers(1, 2, 3, 4, 5, 6),
                7,
                LottoTickets(listOf(ManualLottoTicket(createLottoNumbers(1, 2, 3, 4, 5, 6)))),
                1,
                0,
                0,
                0,
                0,
                2000000.0,
            ),
            Arguments.of(
                createLottoNumbers(1, 2, 3, 4, 5, 6),
                7,
                LottoTickets(listOf(ManualLottoTicket(createLottoNumbers(1, 2, 3, 4, 5, 7)))),
                0,
                1,
                0,
                0,
                0,
                30000.0,
            ),
            Arguments.of(
                createLottoNumbers(1, 2, 3, 4, 5, 6),
                7,
                LottoTickets(listOf(ManualLottoTicket(createLottoNumbers(1, 2, 3, 4, 5, 8)))),
                0,
                0,
                1,
                0,
                0,
                1500.0,
            ),
            Arguments.of(
                createLottoNumbers(1, 2, 3, 4, 5, 6),
                7,
                LottoTickets(listOf(ManualLottoTicket(createLottoNumbers(1, 2, 3, 4, 8, 9)))),
                0,
                0,
                0,
                1,
                0,
                50.0,
            ),
            Arguments.of(
                createLottoNumbers(1, 2, 3, 4, 5, 6),
                7,
                LottoTickets(listOf(ManualLottoTicket(createLottoNumbers(1, 2, 3, 8, 9, 10)))),
                0,
                0,
                0,
                0,
                1,
                5.0,
            ),
            Arguments.of(
                createLottoNumbers(1, 2, 3, 4, 5, 6),
                7,
                LottoTickets(listOf(ManualLottoTicket(createLottoNumbers(1, 2, 8, 9, 10, 11)))),
                0,
                0,
                0,
                0,
                0,
                0.0,
            ),
            Arguments.of(
                createLottoNumbers(1, 2, 3, 4, 5, 6),
                7,
                LottoTickets(listOf(ManualLottoTicket(createLottoNumbers(1, 8, 9, 10, 11, 12)))),
                0,
                0,
                0,
                0,
                0,
                0.0,
            ),
            Arguments.of(
                createLottoNumbers(1, 2, 3, 4, 5, 6),
                7,
                LottoTickets(listOf(ManualLottoTicket(createLottoNumbers(8, 9, 10, 11, 12, 13)))),
                0,
                0,
                0,
                0,
                0,
                0.0,
            ),
        )
    }
}
