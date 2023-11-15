package lotto

import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumbers
import lotto.domain.LottoNumber
import lotto.domain.LottoValidator
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource

class LottoNumbersValidatorTest {

    @ParameterizedTest
    @CsvSource(value = [
        "1,2,3,4,5,6 = 6",
        "2,3,4,5,6,7 = 5",
    ], delimiter = '=')
    fun `전달받은 로또와 당첨 번호를 비교해 일치한 갯수를 반환한다`(userLottoNumber: String, expected: Int) {
        val winningNumber = listOf(
            LottoNumber(6),
            LottoNumber(5),
            LottoNumber(4),
            LottoNumber(3),
            LottoNumber(2),
            LottoNumber(1),
        )
        val userLottoNumbers = LottoNumbers(userLottoNumber.split(",").map { LottoNumber(it.toInt()) })
        val matchingCount: Int = LottoValidator.validateWinningNumberAndUserLotto(winningNumber, userLottoNumbers)

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
