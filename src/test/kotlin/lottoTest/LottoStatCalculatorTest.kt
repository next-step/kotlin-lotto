package lottoTest

import lotto.domain.Lotto
import lotto.domain.LottoMachine
import lotto.domain.LottoStatCalculator
import lotto.domain.LottoStatResult
import lotto.domain.WinningLotto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class LottoStatCalculatorTest {

    @ParameterizedTest
    @MethodSource("generateLottoStatArguments")
    fun `당첨 통계 계산`(winningLotto: WinningLotto, input: List<Lotto>, expected: LottoStatResult) {
        val lottoStatCalculator = LottoStatCalculator(winningLotto)

        assertEquals(expected, lottoStatCalculator.getStat(input))
    }

    companion object {
        @JvmStatic
        fun generateLottoStatArguments(): List<Arguments> {
            return listOf(
                Arguments.of(
                    WinningLotto(
                        lotto = Lotto(listOf(1, 2, 3, 4, 5, 6)),
                        bonusNumber = 45
                    ),
                    listOf(
                        Lotto(numbers = listOf(4, 5, 6, 10, 11, 12)),
                    ),
                    LottoStatResult(
                        firstCount = 0,
                        secondCount = 0,
                        thirdCount = 0,
                        fourthCount = 0,
                        fifthCount = 1,
                        purchaseAmount = 1 * LottoMachine.LOTTO_PRICE,
                    )
                ),
                Arguments.of(
                    WinningLotto(
                        lotto = Lotto(listOf(1, 2, 3, 4, 5, 6)),
                        bonusNumber = 45
                    ),
                    listOf(
                        Lotto(numbers = listOf(1, 2, 3, 4, 5, 45)),
                    ),
                    LottoStatResult(
                        firstCount = 0,
                        secondCount = 1,
                        thirdCount = 0,
                        fourthCount = 0,
                        fifthCount = 0,
                        purchaseAmount = 1 * LottoMachine.LOTTO_PRICE,
                    )
                ),
                Arguments.of(
                    WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), bonusNumber = 45),
                    listOf(
                        Lotto(numbers = listOf(1, 2, 3, 4, 5, 6)),
                        Lotto(numbers = listOf(1, 2, 3, 4, 5, 7)),
                        Lotto(numbers = listOf(1, 2, 3, 4, 7, 8)),
                    ),
                    LottoStatResult(
                        firstCount = 1,
                        secondCount = 0,
                        thirdCount = 1,
                        fourthCount = 1,
                        fifthCount = 0,
                        purchaseAmount = 3 * LottoMachine.LOTTO_PRICE,
                    )
                ),
            )
        }
    }
}
