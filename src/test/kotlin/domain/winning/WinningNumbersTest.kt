package domain.winning

import domain.lotto.LottoNumber
import domain.lotto.lottoNumberOf
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
}
