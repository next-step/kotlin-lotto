package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoShopSpec : FunSpec({
    val lottoPLice = Amount(1000)
    val shop = LottoShop(price = lottoPLice)

    context("로또 구매") {
        test("로또 배수 금액으로 구매") {
            val count = 3
            val amount = lottoPLice * 3

            val tickets = shop.purchase(amount)

            tickets.count shouldBe count
        }

        test("로또의 배수 금액이 아닐 때 구매 실패") {
            val amount = lottoPLice + Amount(1)

            shouldThrow<IllegalArgumentException> {
                shop.purchase(amount)
            }
        }
    }
})
