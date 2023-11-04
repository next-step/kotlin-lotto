package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.mockk.every
import io.mockk.mockk

class LottoShopTest : FunSpec({
    val generator = mockk<LottoGenerator>()
    context("로또 구매") {
        every { generator.generate() } returns Lotto(setOf(1, 2, 3, 4, 5, 6))
        val lottoShop = LottoShop(generator)

        test("로또를 구매한다.") {
            lottoShop.buy(10_500) shouldHaveSize 10
        }
    }
})