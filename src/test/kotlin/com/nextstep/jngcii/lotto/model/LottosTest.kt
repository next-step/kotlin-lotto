package com.nextstep.jngcii.lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottosTest {
    private val lottos: List<Lotto> = listOf(
        Lotto(FIRST_RANK_NUMBERS),
        Lotto(SECOND_RANK_NUMBERS),
        Lotto(THIRD_RANK_NUMBERS),
        Lotto(FOURTH_RANK_NUMBERS),
        Lotto(FIFTH_RANK_NUMBERS),
        Lotto(NONE_RANK_NUMBERS),
    )
    private val record: Lottos = Lottos(lottos)

    @Test
    fun `당첨번호를 입력받아 이번 Lotto들에 대한 결과를 반환한다`() {
        val lastWeekLotto = Lotto(LAST_WEEK_NUMBERS)
        val bonusNumber = BonusNumber(BONUS_NUMBER, lastWeekLotto)
        val result: Ranks = record.getResult(lastWeekLotto, bonusNumber)

        assertThat(result.countOf(Rank.FIRST)).isEqualTo(1)
        assertThat(result.countOf(Rank.SECOND)).isEqualTo(1)
        assertThat(result.countOf(Rank.THIRD)).isEqualTo(1)
        assertThat(result.countOf(Rank.FOURTH)).isEqualTo(1)
        assertThat(result.countOf(Rank.FIFTH)).isEqualTo(1)
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
    }
}
