package lotto

import lotto.domain.LottoDraw
import lotto.domain.LottoValidator
import lotto.domain.dto.LottoNumber
import lotto.domain.dto.Rank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoValidatorTest {

    @ParameterizedTest
    @CsvSource(value = ["1, 2, 3, 4, 5, 6:7"], delimiter = ':')
    fun `당첨번호 숫자로 만들기`(input: String, bonusNumber: String) {
        val luckyDrawNumber = LottoValidator(input, bonusNumber)
        assertThat(luckyDrawNumber.getLuckyNumbers).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
        assertThat(luckyDrawNumber.getBonusNumber).isEqualTo(7)
    }

    @ParameterizedTest
    @CsvSource(value = ["1, 2, 3, 4, 5, 6:7"], delimiter = ':')
    internal fun `당첨 테스트`(input: String, bonusNumber: String) {
        val lottoList = listOf(LottoNumber(listOf(1, 2, 3, 4, 5, 6)))
        val lottoValidator = LottoValidator(input, bonusNumber)
        val draw = LottoDraw(lottoValidator.getLuckyNumbers, lottoValidator.getBonusNumber)
        draw.draw(lottoList)

        assertThat(draw.winningRanks.count { it == Rank.FIRST }).isEqualTo(1)
    }

    @ParameterizedTest
    @CsvSource(value = ["1, 2, 3, 4, 5, 6:7"], delimiter = ':')
    internal fun `2등 당첨 테스트`(input: String, bonusNumber: String) {
        val lottoList = listOf(LottoNumber(listOf(1, 2, 3, 4, 5, 7)))
        val lottoValidator = LottoValidator(input, bonusNumber)
        val draw = LottoDraw(lottoValidator.getLuckyNumbers, lottoValidator.getBonusNumber)
        draw.draw(lottoList)

        assertThat(draw.winningRanks.count { it == Rank.SECOND }).isEqualTo(1)
    }

    @ParameterizedTest
    @CsvSource(
        value = ["1, 2, 3, 4, 5, -6:11", "2, 3, 4, 5, 66:11", "5, -1, 6, 7, 8, 9:11", "1,2,3,4,5,6:66", "1,2,3,4,5,6:5"],
        delimiter = ':'
    )
    fun `당첨번호 에러 처리 테스트`(input: String, bonusNumber: String) {
        assertThrows<IllegalArgumentException> { LottoValidator(input, bonusNumber) }
    }
}
