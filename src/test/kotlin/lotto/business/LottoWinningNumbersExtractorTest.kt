package lotto.business

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class LottoWinningNumbersExtractorTest{
    @Test
    fun `입력한 당첨 결과를 파싱한다`(){
        // given
        val input = "1,2,3,4,5,6"
        val lottoWinningNumbersExtractor = LottoWinningNumbersExtractor()
        val expectedLottoNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }

        // when
        val lottoWinningNumbers = lottoWinningNumbersExtractor.extract(input)

        // then
        assertThat(lottoWinningNumbers).isEqualTo(LottoWinningNumbers(expectedLottoNumbers))
    }

    @Test
    fun `입력한 당첨 결과가 숫자가 아니면 예외를 던진다`(){
        // given
        val input = "1,2,3,4,5,6a"
        val lottoWinningNumbersExtractor = LottoWinningNumbersExtractor()

        // when, then
        assertThatThrownBy { lottoWinningNumbersExtractor.extract(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .message().isEqualTo("당첨 번호는 숫자여야 합니다.")
    }
}
