package lotto.rank

import io.kotest.matchers.shouldBe
import lotto.Lotto
import lotto.number.Numbers
import org.junit.jupiter.api.Test

class LottoRankTest {
    @Test
    fun `로또 번호 6개가 일치하면 1등이다`() {
        LottoRank.getRank(
            lotto = Lotto(Numbers(WINNING_NUMBERS)),
            winningNumbers = WINNING_NUMBERS,
        ) shouldBe LottoRank.FIRST
    }

    @Test
    fun `번호가 2개 이하로 일치하면 아무것도 해당하지 않는다`() {
        LottoRank.getRank(
            lotto = Lotto(Numbers(listOf(1, 2, 0, 0, 0, 0))),
            winningNumbers = WINNING_NUMBERS,
        ) shouldBe LottoRank.NONE
    }

    companion object {
        private val WINNING_NUMBERS = listOf(1, 2, 3, 4, 5, 6)
    }
}
