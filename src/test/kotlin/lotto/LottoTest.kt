package lotto

import io.kotest.matchers.shouldBe
import lotto.number.Numbers
import lotto.rank.LottoRank
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `번호가 6개 일치하면 1등이다`() {
        val lotto = Lotto(numbers = Numbers(listOf(1, 2, 3, 4, 5, 6)))

        lotto.getRank(WINNING_NUMBERS) shouldBe LottoRank.FIRST
    }

    @Test
    fun `번호가 2개 이하로 일치하면 아무것도 해당하지 않는다`() {
        val lotto = Lotto(numbers = Numbers(listOf(1, 2, 0, 0, 0, 0)))

        lotto.getRank(WINNING_NUMBERS) shouldBe LottoRank.NONE
    }

    companion object {
        private val WINNING_NUMBERS = listOf(1, 2, 3, 4, 5, 6)
    }
}
