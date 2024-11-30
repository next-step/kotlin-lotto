package lotto.domain

import io.kotest.matchers.equals.shouldBeEqual
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(PER_CLASS)
class LottoNumberCheckerTest {
    @MethodSource("구매한 로또의 번호 및 당첨 번호 제공")
    @ParameterizedTest
    fun `구매한 로또 번호가 당첨 번호와 몇개가 일치하는지 결과 확인 (3개부터)`(
        purchasedCount: Int,
        lottoNumbers: Set<Int>,
        inputWinnerNumbersCommand: String,
        threeNumberMatchCount: Int,
        fourNumberMatchCount: Int,
        fiveNumberMatchCount: Int,
        sixNumberMatchCount: Int,
    ) {
        val purchasedLottoTickets =
            PurchasedLottoTickets(purchasedCount = purchasedCount, lottoNumberGenerator = { lottoNumbers })
        val lottoWinnerNumbers = LottoWinnerNumbers(inputWinnerNumbersCommand = inputWinnerNumbersCommand)
        val purchasedLottoResults =
            LottoNumberChecker.purchasedLottoTicketsNumberCheck(
                purchasedLottoTickets = purchasedLottoTickets,
                winnerNumbers = lottoWinnerNumbers,
            )
        purchasedLottoResults.threeNumberMatchCount shouldBeEqual threeNumberMatchCount
        purchasedLottoResults.fourNumberMatchCount shouldBeEqual fourNumberMatchCount
        purchasedLottoResults.fiveNumberMatchCount shouldBeEqual fiveNumberMatchCount
        purchasedLottoResults.sixNumberMatchCount shouldBeEqual sixNumberMatchCount
    }

    fun `구매한 로또의 번호 및 당첨 번호 제공`(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(5, setOf(1, 2, 3, 4, 5, 6), "4,5,6,7,8,9", 5, 0, 0, 0),
            Arguments.of(8, setOf(11, 12, 13, 14, 15, 16), "13,14,15,16,17,18", 0, 8, 0, 0),
            Arguments.of(3, setOf(21, 22, 23, 24, 25, 26), "21,22,23,24,25,1", 0, 0, 3, 0),
            Arguments.of(11, setOf(31, 32, 33, 34, 35, 41), "31,32,33,34,35,41", 0, 0, 0, 11),
        )
    }
}
