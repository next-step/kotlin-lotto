package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource

class LottoRankTest {
    @ParameterizedTest
    @CsvFileSource(resources = ["/lotto_rank.csv"], numLinesToSkip = 1, delimiter = ':')
    fun `로또 순위 - 순위 확인 테스트`(countOfMatch: Int, matchBonus: Boolean, expected: String) {
        // given
        val lottoRank = LottoRank.valueOf(countOfMatch, matchBonus)

        // when, then
        assertThat(lottoRank).isEqualTo(LottoRank.valueOf(expected))
    }
}
