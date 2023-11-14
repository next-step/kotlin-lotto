package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class WinningLottoTest {
    @Test
    fun `당첨 번호가 주어졌을 때, 로또의 등 수를 알 수 있다 -  모든 번호 다 맞출 시 1등`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6))
        val lotto = Lotto(setOf(1, 2, 3, 4, 5, 6))
        winningLotto.match(lotto) shouldBe LotteryPrizeAmount.FIRST
    }

    @Test
    fun `보너스 번호가 주어졌을 때, 2등을 판별할 수 있다`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        val lotto = Lotto(setOf(1, 2, 3, 4, 5, 7))
        winningLotto.match(lotto) shouldBe LotteryPrizeAmount.SECOND
    }
}
