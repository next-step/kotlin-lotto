package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class LotteryShopTest {
    @Test
    internal fun `14000원을 입력하면 14장이 구매된다`() {
        LotteryShop.buy(14000) shouldBe 14
    }

    @Test
    internal fun `2장을 발급하면 로또 두장이 발급된다`() {
        LotteryShop.getTickets(2, listOf()).tickets.size shouldBe 2
    }

    @Test
    internal fun `구매한 로또 개수보다 수동의 개수가 크면 에러가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LotteryShop.validateManualNum(3, 2)
        }
    }

    @ParameterizedTest
    @CsvSource(value = ["1,2,3,11,8,9;7;0.5", "1,2,3,4,8,9;7;5"], delimiter = ';')
    internal fun `동일한 개수에 등수가 결정되고 그에 따른 수익률이 계산된다`(winningNums: String, bonus: Int, result: Float) {
        val winningTicket = WinningTicket(Lotto(winningNums.split(",").map { it.toInt() }), bonus)
        val testLotto = Tickets(1, listOf(), TestNumGenerator())
        val score = winningTicket.score(testLotto)

        LotteryShop.calculateRateOfReturn(10000, score) shouldBe result
    }
}
