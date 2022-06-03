package com.nextstep.jngcii.lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class RanksTest {
    @Test
    fun `당첨번호를 입력받아 이번 Lotto들에 대한 결과를 반환한다`() {
        val lastWeekLotto = Lotto(LAST_WEEK_NUMBERS)
        val bonusNumber = BonusNumber(BONUS_NUMBER, lastWeekLotto)
        val ranks = Ranks(lottos, lastWeekLotto, bonusNumber)

        assertThat(ranks.countOf(Rank.FIRST)).isEqualTo(1)
        assertThat(ranks.countOf(Rank.SECOND)).isEqualTo(1)
        assertThat(ranks.countOf(Rank.THIRD)).isEqualTo(1)
        assertThat(ranks.countOf(Rank.FOURTH)).isEqualTo(1)
        assertThat(ranks.countOf(Rank.FIFTH)).isEqualTo(1)
    }

    @ParameterizedTest
    @MethodSource("sumOfPrice")
    fun `단순상금 총액 계산 테스트`(rankList: List<Rank>, sum: Double) {
        assertThat(Ranks(rankList).sumOfPrice).isEqualTo(sum)
    }

    @ParameterizedTest
    @MethodSource("countOf")
    fun `포함 갯수 확인 테스트`(rankList: List<Rank>, target: Rank, count: Int) {
        assertThat(Ranks(rankList).countOf(target)).isEqualTo(count)
    }

    companion object {
        private const val BONUS_NUMBER = 7
        private val LAST_WEEK_NUMBERS = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }

        private val FIRST_RANK_NUMBERS = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }
        private val SECOND_RANK_NUMBERS = listOf(2, 3, 4, 5, 6, 7).map { LottoNumber(it) }
        private val THIRD_RANK_NUMBERS = listOf(2, 3, 4, 5, 6, 8).map { LottoNumber(it) }
        private val FOURTH_RANK_NUMBERS = listOf(3, 4, 5, 6, 7, 8).map { LottoNumber(it) }
        private val FIFTH_RANK_NUMBERS = listOf(4, 5, 6, 7, 8, 9).map { LottoNumber(it) }
        private val NONE_RANK_NUMBERS = listOf(5, 6, 7, 8, 9, 10).map { LottoNumber(it) }

        private val lottos: List<Lotto> = listOf(
            Lotto(FIRST_RANK_NUMBERS),
            Lotto(SECOND_RANK_NUMBERS),
            Lotto(THIRD_RANK_NUMBERS),
            Lotto(FOURTH_RANK_NUMBERS),
            Lotto(FIFTH_RANK_NUMBERS),
            Lotto(NONE_RANK_NUMBERS),
        )

        @JvmStatic
        fun sumOfPrice() = listOf(
            Arguments.of(
                listOf(Rank.FOURTH, Rank.FOURTH),
                100_000
            ),
            Arguments.of(
                listOf(Rank.FIRST, Rank.FOURTH),
                2_000_050_000
            ),
            Arguments.of(
                listOf(Rank.FOURTH, Rank.THIRD, Rank.THIRD, Rank.FIFTH),
                3_055_000
            )
        )

        @JvmStatic
        fun countOf() = listOf(
            Arguments.of(
                listOf(Rank.FOURTH, Rank.FOURTH),
                Rank.FOURTH,
                2
            ),
            Arguments.of(
                listOf(Rank.FIRST, Rank.FOURTH),
                Rank.FOURTH,
                1
            ),
            Arguments.of(
                listOf(Rank.FOURTH, Rank.THIRD, Rank.THIRD, Rank.FIFTH),
                Rank.FIRST,
                0
            )
        )
    }
}
