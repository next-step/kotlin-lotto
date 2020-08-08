package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoResultTest {

    @CsvSource(
        "6,FIRST,false",
        "5,SECOND_BONUS,true",
        "5,SECOND,false",
        "4,THIRD,false",
        "3,FOURTH,false",
        "2,LOSE,false",
        "1,LOSE,false",
        "0,LOSE,false"
    )
    @ParameterizedTest
    fun `맞춘 로또 번호 갯수에 따른 결과 리턴`(matchCount: Int, lottoResult: LottoResult, isBonusMatched: Boolean) {
        // then
        assertThat(LottoResult.findByMatch(matchCount, isBonusMatched)).isEqualTo(lottoResult)
    }
}
