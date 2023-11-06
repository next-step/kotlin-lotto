package lotto.business

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoWinningNumbersTest {
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5,5", "1,2,3,3,5,7", "1,2,3,4,5"])
    fun `당첨 번호가 중복이면 예외 발생한다`(numbers: String) {
        // given
        val lottoNumbers = numbers.split(",").map { LottoNumber(it.toInt()) }.toSet()

        // when, then
        Assertions.assertThatThrownBy { LottoWinningNumbers(lottoNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("서로 다른 6개 로또 번호 이여야 합니다.")
    }
}
