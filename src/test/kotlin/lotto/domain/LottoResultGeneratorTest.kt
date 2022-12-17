package lotto.domain

import lotto.dto.LottoRankDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoResultGeneratorTest {
    @ParameterizedTest
    @CsvSource(value = ["1,2,3,4,5,6:6,2000000000", "1,2,3,4,5,45:5,30000000", "1,2,3,4,5,7:5,1500000", "1,2,3,4,7,8:4,50000", "1,2,3,7,8,9:3,5000", "1,2,3,7,8,45:3,5000"], delimiter = ':')
    fun `로또 결과 생성 - 순위 확인 테스트`(given: String, result: String) {
        // given
        val lotto = Lotto(given.split(",").map { LottoNumber.from(it.toInt()) })
        val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) })
        val winningNumbersWithBonusNumber = WinningNumbers(winningNumbers, LottoNumber.from(45))
        val lottoResultGenerator = LottoResultGenerator(winningNumbersWithBonusNumber, Lottos(listOf(lotto)))
        val lottoResult = lottoResultGenerator.getResult()
        val expected = LottoRankDto(result.split(",").map { it.toInt() }.first(), result.split(",").map { it.toInt() }.last())

        // when
        val actual = lottoResult.getResultAsDto().filter { it.value == 1 }.keys.first()

        // then
        assertThat(actual).isEqualTo(expected)
    }
}
