package lotto

import lotto.domain.LottoDrawResult
import lotto.domain.LottoLuckyDraw
import lotto.domain.dto.LottoNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LottoLuckyDrawTest {

    @ParameterizedTest
    @CsvSource(value = ["1, 2, 3, 4, 5, 6:7"], delimiter = ':')
    fun `당첨번호 숫자로 만들기`(input: String, bonusNumber: String) {
        val luckyDrawNumber = LottoLuckyDraw(input, bonusNumber)
        assertThat(luckyDrawNumber.luckyNumber).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
        assertThat(luckyDrawNumber.bonusNumber).isEqualTo(7)
    }

    @ParameterizedTest
    @CsvSource(value = ["1, 2, 3, 4, 5, 6:7"], delimiter = ':')
    internal fun `당첨 테스트`(input: String, bonusNumber: String) {
        val lottoList = listOf(LottoNumber(listOf(1, 2, 3, 4, 5, 6)))
        val lottoLuckyDraw = LottoLuckyDraw(input, bonusNumber)
        val draw = LottoDrawResult(lottoLuckyDraw.luckyNumber, lottoLuckyDraw.bonusNumber)
        draw.draw(lottoList)

        assertThat(draw.six).isEqualTo(1)
    }

    @ParameterizedTest
    @CsvSource(value = ["1, 2, 3, 4, 5, 6:7"], delimiter = ':')
    internal fun `2등 당첨 테스트`(input: String, bonusNumber: String) {
        val lottoList = listOf(LottoNumber(listOf(1, 2, 3, 4, 5, 7)))
        val lottoLuckyDraw = LottoLuckyDraw(input, bonusNumber)
        val draw = LottoDrawResult(lottoLuckyDraw.luckyNumber, lottoLuckyDraw.bonusNumber)
        draw.draw(lottoList)

        assertThat(draw.fiveWithBonus).isEqualTo(1)
    }


    @ParameterizedTest
    @CsvSource(
        value = ["1, 2, 3, 4, 5, -6:11", "2, 3, 4, 5, 66:11", "5, -1, 6, 7, 8, 9:11", "1,2,3,4,5,6:66", "1,2,3,4,5,6:5"],
        delimiter = ':'
    )
    fun `당첨번호 에러 처리 테스트`(input: String, bonusNumber: String) {
        assertThrows<IllegalArgumentException> { LottoLuckyDraw(input, bonusNumber) }
    }
}
