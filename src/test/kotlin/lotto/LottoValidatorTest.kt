package lotto

import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoValidator
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class LottoValidatorTest {

    @ParameterizedTest
    @MethodSource("getLottoData")
    fun `전달받은 로또와 당첨 번호를 비교해 일치한 갯수를 반환한다`(userLottoNumber: List<LottoNumber>, expected: Int) {
        val winningNumber = listOf(
            LottoNumber(6),
            LottoNumber(5),
            LottoNumber(4),
            LottoNumber(3),
            LottoNumber(2),
            LottoNumber(1),
        )
        val userLotto = Lotto(userLottoNumber)
        val matchingCount: Int = LottoValidator.validateWinningNumberAndUserLotto(winningNumber, userLotto)

        matchingCount shouldBe expected
    }

    companion object {
        @JvmStatic
        fun getLottoData(): List<Arguments> {
            return listOf(
                Arguments.of(
                    listOf(
                        LottoNumber(6),
                        LottoNumber(5),
                        LottoNumber(4),
                        LottoNumber(3),
                        LottoNumber(2),
                        LottoNumber(1),
                    ),
                    6
                ),
                Arguments.of(
                    listOf(
                        LottoNumber(7),
                        LottoNumber(5),
                        LottoNumber(4),
                        LottoNumber(3),
                        LottoNumber(2),
                        LottoNumber(1),
                    ),
                    5
                ),
                Arguments.of(
                    listOf(
                        LottoNumber(7),
                        LottoNumber(8),
                        LottoNumber(4),
                        LottoNumber(3),
                        LottoNumber(2),
                        LottoNumber(1),
                    ),
                    4
                ),
                Arguments.of(
                    listOf(
                        LottoNumber(7),
                        LottoNumber(8),
                        LottoNumber(9),
                        LottoNumber(3),
                        LottoNumber(2),
                        LottoNumber(1),
                    ),
                    3
                ),
                Arguments.of(
                    listOf(
                        LottoNumber(7),
                        LottoNumber(8),
                        LottoNumber(9),
                        LottoNumber(10),
                        LottoNumber(2),
                        LottoNumber(1),
                    ),
                    2
                )
            )
        }
    }
}
