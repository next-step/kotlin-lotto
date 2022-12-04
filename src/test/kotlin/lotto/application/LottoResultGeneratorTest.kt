package lotto.application

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.LottoNumbersList
import lotto.domain.LottoRank
import lotto.domain.WinningNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoResultGeneratorTest {
    @ParameterizedTest
    @CsvSource(value = ["1,2,3,4,5,6:45:FIRST", "1,2,3,4,5,45:45:SECOND", "1,2,3,4,5,7:45:THIRD", "1,2,3,4,7,8:45:FOURTH", "1,2,3,7,8,9:45:FIFTH", "1,2,3,4,7,45:45:FOURTH", "1,2,3,7,8,45:45:FIFTH"], delimiter = ':')
    fun `로또 결과 생성 - 순위 확인 테스트`(given: String, bonusNumber: Int, expected: String) {
        // given
        val lottoNumbers = LottoNumbers(given.split(",").map { LottoNumber(it.toInt()) })
        val winningNumbers = LottoNumbers(listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(6)))
        val winningNumbersWithBonusNumber = WinningNumbers(winningNumbers, LottoNumber(bonusNumber))
        val lottoResultGenerator = LottoResultGenerator(winningNumbersWithBonusNumber, LottoNumbersList(listOf(lottoNumbers)))
        val lottoResult = lottoResultGenerator.getResult()

        // when
        val actual = lottoResult.value.filter { it.value == 1 }.keys.first()

        // then
        assertThat(actual).isEqualTo(LottoRank.valueOf(expected))
    }
}
