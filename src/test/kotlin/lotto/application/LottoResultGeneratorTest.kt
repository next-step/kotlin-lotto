package lotto.application

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.LottoNumbersList
import lotto.domain.WinningNumbers
import lotto.dto.LottoRankDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoResultGeneratorTest {
    @ParameterizedTest
    @CsvSource(value = ["1,2,3,4,5,6:6,2000000000", "1,2,3,4,5,45:5,30000000", "1,2,3,4,5,7:5,1500000", "1,2,3,4,7,8:4,50000", "1,2,3,7,8,9:3,5000", "1,2,3,7,8,45:3,5000"], delimiter = ':')
    fun `로또 결과 생성 - 순위 확인 테스트`(given: String, result: String) {
        // given
        val lottoNumbers = LottoNumbers(given.split(",").map { LottoNumber.from(it.toInt()) })
        val winningNumbers = LottoNumbers(listOf(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3), LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6)))
        val winningNumbersWithBonusNumber = WinningNumbers(winningNumbers, LottoNumber.from(45))
        val lottoResultGenerator = LottoResultGenerator(winningNumbersWithBonusNumber, LottoNumbersList(listOf(lottoNumbers)))
        val lottoResult = lottoResultGenerator.getResult()
        val expected = LottoRankDto(result.split(",").map { it.toInt() }.first(), result.split(",").map { it.toInt() }.last())

        // when
        val actual = lottoResult.getResultAsDto().filter { it.value == 1 }.keys.first()

        // then
        assertThat(actual).isEqualTo(expected)
    }
}
