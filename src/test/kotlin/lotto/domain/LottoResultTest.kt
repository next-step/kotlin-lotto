package lotto.domain

import lotto.domain.LottoResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoResultTest {

    @CsvSource("6,FIRST", "5,SECOND", "4,THIRD", "3,FOURTH", "2,LOSE", "1,LOSE", "0,LOSE")
    @ParameterizedTest
    fun `맞춘 로또 번호 갯수에 따른 결과 리턴`(matchCount: Int, lottoResult: LottoResult) {
        // then
        assertThat(LottoResult.findByMatch(matchCount)).isEqualTo(lottoResult)
    }
}
