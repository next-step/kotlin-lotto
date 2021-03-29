package domain.winning

import domain.lotto.Lotto
import domain.lotto.LottoNumber
import domain.lotto.lottoNumberOf
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class WinningNumbersTest {
    @Test
    fun `당첨번호는 로또숫자열 하나와 보너스를 위한 로또숫자 하나로 생성된다`() {
        assertDoesNotThrow {
            WinningNumbers(
                numbers = lottoNumberOf(1, 2, 3, 4, 5, 6),
                bonus = LottoNumber.parse(7)
            )
        }
    }

    @ParameterizedTest
    @CsvSource(
        "1,2,3,4,5,6, 1",
        "1,2,3,4,5,6, 2",
        "7,8,9,10,11,12, 12"
    )
    fun `로또숫자열 내의 로또숫자들과 보너스를 위한 숫자는 서로 겹칠 수 없다`(
        n1: Int,
        n2: Int,
        n3: Int,
        n4: Int,
        n5: Int,
        n6: Int,
        bonusNumber: Int
    ) {
        // given
        val numbers = lottoNumberOf(n1, n2, n3, n4, n5, n6)
        val bonus = LottoNumber.parse(bonusNumber)

        // when
        val createWinningNumbers: () -> Unit = { WinningNumbers(numbers, bonus) }

        // then
        assertThatIllegalArgumentException().isThrownBy(createWinningNumbers)
    }

    @ParameterizedTest
    @CsvSource(
        "1,2,3,4,5,6, SIX_CORRECT",
        "1,2,3,4,5,7, FIVE_CORRECT",
        "1,2,3,4,7,8, FOUR_CORRECT",
        "1,2,3,7,8,9, THREE_CORRECT",
        "1,2,3,4,5,45, FIVE_WITH_BONUS_CORRECT"
    )
    internal fun `당첨번호는 로또를 보고 당첨항목을 판별한다`(
        n1: Int,
        n2: Int,
        n3: Int,
        n4: Int,
        n5: Int,
        n6: Int,
        expectedCategory: WinningCategory
    ) {
        // given
        val winningNumbers = WinningNumbers(
            numbers = lottoNumberOf(1, 2, 3, 4, 5, 6),
            bonus = LottoNumber.parse(45)
        )
        val lotto = Lotto(lottoNumberOf(n1, n2, n3, n4, n5, n6))

        // when
        val actual = winningNumbers.determineWinning(lotto)

        // then
        assertThat(actual).isEqualTo(expectedCategory)
    }
}
