package lotto

import lotto.domain.Lotto
import lotto.domain.LottoRank
import lotto.domain.LottoRank.Companion.getLottoRank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoRankTest {

    @ParameterizedTest
    @MethodSource("provideLottoNumberList")
    fun `로또 결과를 얻을 수 있다`(lotto: Lotto, winningLotto: Lotto, expected: LottoRank, bonusNumber: Int) {
        val lottoResult: LottoRank = lotto.getLottoRank(winningLotto, bonusNumber)

        assertThat(lottoResult).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun provideLottoNumberList(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Lotto(listOf(1, 2, 3, 4, 5, 6)), Lotto(listOf(1, 2, 3, 4, 5, 6)), LottoRank.FIRST, 7),
                Arguments.of(Lotto(listOf(1, 2, 3, 4, 5, 7)), Lotto(listOf(1, 2, 3, 4, 5, 6)), LottoRank.SECOND_WITH_BONUS, 7),
                Arguments.of(Lotto(listOf(1, 2, 3, 4, 5, 7)), Lotto(listOf(1, 2, 3, 4, 5, 6)), LottoRank.SECOND, 45),
                Arguments.of(Lotto(listOf(1, 2, 3, 4, 7, 8)), Lotto(listOf(1, 2, 3, 4, 5, 6)), LottoRank.THIRD, 45),
                Arguments.of(Lotto(listOf(1, 2, 3, 7, 8, 9)), Lotto(listOf(1, 2, 3, 4, 5, 6)), LottoRank.FOURTH, 45),
                Arguments.of(Lotto(listOf(1, 2, 7, 8, 9, 10)), Lotto(listOf(1, 2, 3, 4, 5, 6)), LottoRank.MISS, 45),
                Arguments.of(Lotto(listOf(7, 8, 9, 10, 11, 12)), Lotto(listOf(1, 2, 3, 4, 5, 6)), LottoRank.MISS, 45),
            )
        }
    }
}
