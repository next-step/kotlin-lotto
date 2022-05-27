package com.nextstep.jngcii.lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RecordTest {
    private val lottos: List<Lotto> = listOf(
        Lotto(FIRST_RANK_NUMBERS),
        Lotto(SECOND_RANK_NUMBERS),
        Lotto(THIRD_RANK_NUMBERS),
        Lotto(FOURTH_RANK_NUMBERS),
        Lotto(NONE_RANK_NUMBERS),
    )
    private val record: Record = Record(lottos)

    @Test
    fun `당첨번호를 입력받아 이번 Lotto들에 대한 결과를 반환한다`() {
        val lastWeekLotto = Lotto(LAST_WEEK_NUMBERS)
        val result: List<Rank> = record.getResult(lastWeekLotto)

        assertThat(result.size).isEqualTo(4)
        assertThat(result.count { it == Rank.FIRST }).isEqualTo(1)
        assertThat(result.count { it == Rank.SECOND }).isEqualTo(1)
        assertThat(result.count { it == Rank.THIRD }).isEqualTo(1)
        assertThat(result.count { it == Rank.FOURTH }).isEqualTo(1)
    }

    companion object {
        private val LAST_WEEK_NUMBERS = listOf(1, 2, 3, 4, 5, 6)

        private val FIRST_RANK_NUMBERS = listOf(1, 2, 3, 4, 5, 6)
        private val SECOND_RANK_NUMBERS = listOf(2, 3, 4, 5, 6, 7)
        private val THIRD_RANK_NUMBERS = listOf(3, 4, 5, 6, 7, 8)
        private val FOURTH_RANK_NUMBERS = listOf(4, 5, 6, 7, 8, 9)
        private val NONE_RANK_NUMBERS = listOf(5, 6, 7, 8, 9, 10)
    }
}
