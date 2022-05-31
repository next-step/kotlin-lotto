package lotto.model

import lotto.model.WinningRank.FIRST_PRIZE
import lotto.model.WinningRank.FOURTH_PRIZE
import lotto.model.WinningRank.NONE
import lotto.model.WinningRank.SECOND_PRIZE
import lotto.model.WinningRank.THIRD_PRIZE
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("당첨 순위 테스트")
class WinningRankTest {

    private val winningNumbers = Lotto.from(listOf(1, 2, 3, 4, 5, 6))

    @Test
    fun `당첨 번호 6개가 일치하면 1등`() {
        // given
        val lotto = Lotto.from(listOf(1, 2, 3, 4, 5, 6))
        val lottos = Lottos(listOf(lotto))

        // when, then
        assertEquals(WinningRank.findRanks(lottos, winningNumbers)[0], FIRST_PRIZE)
    }

    @Test
    fun `당첨 번호 5개가 일치하면 2등`() {
        // given
        val lotto = Lotto.from(listOf(2, 3, 4, 5, 6, 7))
        val lottos = Lottos(listOf(lotto))

        // when, then
        assertEquals(WinningRank.findRanks(lottos, winningNumbers)[0], SECOND_PRIZE)
    }

    @Test
    fun `당첨 번호 4개가 일치하면 3등`() {
        // given
        val lotto = Lotto.from(listOf(3, 4, 5, 6, 7, 8))
        val lottos = Lottos(listOf(lotto))

        // when, then
        assertEquals(WinningRank.findRanks(lottos, winningNumbers)[0], THIRD_PRIZE)
    }

    @Test
    fun `당첨 번호 3개가 일치하면 4등`() {
        // given
        val lotto = Lotto.from(listOf(4, 5, 6, 7, 8, 9))
        val lottos = Lottos(listOf(lotto))

        // when, then
        assertEquals(WinningRank.findRanks(lottos, winningNumbers)[0], FOURTH_PRIZE)
    }

    @Test
    fun `일치하는 당첨 번호가 2개 이하면 꽝`() {
        // given
        val lotto = Lotto.from(listOf(5, 6, 7, 8, 9, 10))
        val lottos = Lottos(listOf(lotto))

        // when, then
        assertEquals(WinningRank.findRanks(lottos, winningNumbers)[0], NONE)
    }
}
