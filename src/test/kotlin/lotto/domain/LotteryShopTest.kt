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
}
