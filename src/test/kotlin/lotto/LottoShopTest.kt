package lotto

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoShopTest : StringSpec({
    "로또 금액을 입력받으면 해당 요청에 대한 주문을 생성해야한다." {
        val lottoShop = LottoShop(LottoCreator(FixedNumberGenerator()))
        val order = lottoShop.makeOrder(10000)

        assertSoftly {
            order.amount shouldBe 10000
            order.lottos.size shouldBe 10
        }
    }

    "주문 생성 시 전달된 금액이 1000원 단위가 아닐 경우 예외를 반환한다." {
        val lottoShop = LottoShop(LottoCreator(FixedNumberGenerator()))
        shouldThrow<IllegalArgumentException> { lottoShop.makeOrder(10001) }
    }
})
