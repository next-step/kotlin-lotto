package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class WinningLottoTest {
    @Test
    fun `당첨 번호가 주어졌을 때, 로또의 등 수를 알 수 있다`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6))
        winningLotto.match() shouldBe LotteryPrizeAmount.FIRST
    }
}
