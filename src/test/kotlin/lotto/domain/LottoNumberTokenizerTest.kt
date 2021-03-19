package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class LottoNumberTokenizerTest {
    @ParameterizedTest
    @CsvSource(
        "'1,2,3,4,5,6'",
        "'1, 2, 3, 4, 5, 6'"
    )
    fun `띄어쓰기를 포함한 쉼표로 구분되는 숫자6개 문자열을 토큰화한다`(stringLottoNumbers: String) {
        val lottoNumberTokens: List<Int> = LottoNumberTokenizer.tokenize(stringLottoNumbers)

        assertThat(lottoNumberTokens.size).isEqualTo(6)
        assertThat(lottoNumberTokens[0]).isEqualTo(1)
        assertThat(lottoNumberTokens[1]).isEqualTo(2)
        assertThat(lottoNumberTokens[2]).isEqualTo(3)
        assertThat(lottoNumberTokens[3]).isEqualTo(4)
        assertThat(lottoNumberTokens[4]).isEqualTo(5)
        assertThat(lottoNumberTokens[5]).isEqualTo(6)
    }
}
