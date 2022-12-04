package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoRankTest {
    @ParameterizedTest
    @CsvSource(value = ["6:FIRST", "5:THIRD", "4:FOURTH", "3:FIFTH", "2:MISS", "1:MISS", "0:MISS"], delimiter = ':')
    fun `로또 순위 - 순위 확인 테스트`(given: String, expected: String) {
        // given
        val lottoRank = LottoRank.valueOf(given.toInt(), false)

        // when, then
        assertThat(lottoRank).isEqualTo(LottoRank.valueOf(expected))
    }
}
