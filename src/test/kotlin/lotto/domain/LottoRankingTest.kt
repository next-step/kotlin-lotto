package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

@Suppress("NonAsciiCharacters")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LottoRankingTest {

    @ParameterizedTest
    @MethodSource
    fun `번호가 일치하는 갯수가 주어지면 랭킹을 구한다`(count: Int, expected: LottoRanking?) {
        // when
        val result = LottoRanking.from(count)

        // then
        assertThat(result).isEqualTo(expected)
    }

    @Suppress("unused")
    private fun `번호가 일치하는 갯수가 주어지면 랭킹을 구한다`() = listOf(
        Arguments.of(6, LottoRanking.RANK_1),
        Arguments.of(5, LottoRanking.RANK_2),
        Arguments.of(4, LottoRanking.RANK_3),
        Arguments.of(3, LottoRanking.RANK_4),
        Arguments.of(2, LottoRanking.NO_RANK),
        Arguments.of(1, LottoRanking.NO_RANK),
        Arguments.of(0, LottoRanking.NO_RANK),
    )
}
