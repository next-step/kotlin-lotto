package lotto.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class MatchedCountTest {

    @ParameterizedTest
    @ValueSource(ints = [-1, 7, 100])
    fun `0~6 사이의 일치 개수를 입력하지 않으면 IllegalArgumentException을 발생시킨다`(input: Int) {
        Assertions.assertThatThrownBy {
            MatchedCount.from(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2])
    fun `일치 개수가 0~2개 인 경우 MISSED LottoResultRank 를 반환한다`(input: Int) {
        val matchedCount = MatchedCount.from(input)

        assertThat(matchedCount).isNotNull
        assertThat(matchedCount.getRank()).isEqualTo(LottoResultRank.MISSED)
    }

    @Test
    fun `일치 개수가 3개 인 경우 FIFTH LottoResultRank 를 반환한다`() {
        val matchedCount = MatchedCount.from(3)

        assertThat(matchedCount).isNotNull
        assertThat(matchedCount.getRank()).isEqualTo(LottoResultRank.FIFTH)
    }

    @Test
    fun `일치 개수가 4개 인 경우 FOURTH LottoResultRank 를 반환한다`() {
        val matchedCount = MatchedCount.from(4)

        assertThat(matchedCount).isNotNull
        assertThat(matchedCount.getRank()).isEqualTo(LottoResultRank.FOURTH)
    }

    @Test
    fun `일치 개수가 5개 인 경우 THIRD LottoResultRank 를 반환한다`() {
        val matchedCount = MatchedCount.from(5)

        assertThat(matchedCount).isNotNull
        assertThat(matchedCount.getRank()).isEqualTo(LottoResultRank.THIRD)
    }

    @Test
    fun `일치 개수가 6개 인 경우 FIRST LottoResultRank 를 반환한다`() {
        val matchedCount = MatchedCount.from(6)

        assertThat(matchedCount).isNotNull
        assertThat(matchedCount.getRank()).isEqualTo(LottoResultRank.FIRST)
    }
}
