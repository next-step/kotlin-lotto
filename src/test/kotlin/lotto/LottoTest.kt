package lotto

import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import io.kotest.matchers.shouldBe
import lotto.number.Numbers
import lotto.rank.LottoRank
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class LottoTest {
    @Test
    fun `번호가 모두 일치하면 1등 로또이다`() {
        val lotto = Lotto(numbers = Numbers(WINNING_NUMBERS))

        lotto.numbers.numbers shouldBe WINNING_NUMBERS
        lotto.getRank(WINNING_NUMBERS) shouldBe LottoRank.FIRST
    }

    @ParameterizedTest
    @MethodSource("noneLottos")
    fun `번호가 2개 이하로 일치하면 당첨되지 않은 로또이다`(lotto: Lotto) {
        lotto.numbers.numbers
            .filter { it in WINNING_NUMBERS }
            .size shouldBeLessThanOrEqual 2
        lotto.getRank(WINNING_NUMBERS) shouldBe LottoRank.NONE
    }

    companion object {
        @JvmStatic
        private fun noneLottos() =
            listOf(
                Lotto(numbers = Numbers(listOf(1, 2, 0, 0, 0, 0))),
                Lotto(numbers = Numbers(listOf(3, 4, 0, 0, 0, 0))),
                Lotto(numbers = Numbers(listOf(5, 6, 0, 0, 0, 0))),
            )

        private val WINNING_NUMBERS = listOf(1, 2, 3, 4, 5, 6)
    }
}
