package lotto.domain

import lotto.ui.InputView.Companion.LOTTO_NUMBER_DIVIDE_TEXT
import lotto.util.toLottoNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CheckerTest {
    @CsvSource(
        value = [
            "'1,2,3,4,5,6', '1,2,3,4,5,6', 6",
            "'1,2,3,4,5,7', '1,2,3,4,5,6', 5",
            "'1,2,3,4,8,7', '1,2,3,4,5,6', 4",
            "'1,2,3,9,8,7', '1,2,3,4,5,6', 3",
            "'1,2,10,9,8,7', '1,2,3,4,5,6', 2",
            "'1,11,10,9,8,7', '1,2,3,4,5,6', 1",
            "'12,11,10,9,8,7', '1,2,3,4,5,6', 0",
        ]
    )
    @ParameterizedTest
    fun `지난당첨번호와 일치하는 개수를 확인한다`(
        lottoNumberText: String,
        lastNumberText: String,
        matchCount: Int
    ) {
        val lastNumber = lastNumberText.toLottoNumbers(LOTTO_NUMBER_DIVIDE_TEXT)
        val checker = Checker(lastNumber, LottoNumber(45))
        val numbers = lottoNumberText.toLottoNumbers(LOTTO_NUMBER_DIVIDE_TEXT)
        val (matchCount, _) = checker.match(numbers)
        assertThat(matchCount).isEqualTo(matchCount)
    }

    @CsvSource(
        value = [
            "'1,2,3,4,8,7', '1,2,3,4,5,6', '8', true",
        ]
    )
    @ParameterizedTest
    fun `보너스넘버로 당첨이되는지 확인한다`(
        lottoNumberText: String,
        lastNumberText: String,
        bonusNumber: String,
        isExpectBonus: Boolean
    ) {
        val lastNumber = lastNumberText.toLottoNumbers(LOTTO_NUMBER_DIVIDE_TEXT)
        val bonusNumber = LottoNumber(bonusNumber.toInt())
        val checker = Checker(lastNumber, bonusNumber)
        val numbers = lottoNumberText.toLottoNumbers(LOTTO_NUMBER_DIVIDE_TEXT)
        val (_, isBonusNumber) = checker.match(numbers)
        assertThat(isBonusNumber).isEqualTo(isExpectBonus)
    }

    @Test
    fun `보너스번호는 당첨번호와 달라야 한다`() {
        val listLottoTicket = LottoTicket(
            listOf(
                LottoNumber(1), LottoNumber(2), LottoNumber(3),
                LottoNumber(4), LottoNumber(5), LottoNumber(6)
            )
        )
        val bonusNumber = LottoNumber(1)
        assertThrows<IllegalArgumentException> {
            Checker(listLottoTicket, bonusNumber)
        }
    }
}
