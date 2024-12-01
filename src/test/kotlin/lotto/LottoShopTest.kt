package lotto

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoShopTest : StringSpec({
    "로또 금액을 입력받으면 해당 요청에 대한 주문을 생성해야한다." {
        val lottoShop = LottoShop(LottoCreator(FixedLottoNumberGenerator()))
        val order = lottoShop.makeOrder(10000)

        assertSoftly {
            order.amount shouldBe 10000
            order.autoLottos.size shouldBe 10
        }
    }

    "수동으로 구매할 로또의 개수와 로또 번호를 입력받으면 해당 요청에 대한 주문을 생성해야한다." {
        val lottoShop = LottoShop(LottoCreator(FixedLottoNumberGenerator()))
        val manualLottoNumbers = listOf(createLotto(1, 2, 3, 4, 5, 6), createLotto(5, 6, 7, 8, 9, 1))
        val order = lottoShop.makeOrder(4000, 2, manualLottoNumbers)

        assertSoftly {
            order.amount shouldBe 4000
            order.autoLottos.size shouldBe 2
            order.manualLottos.size shouldBe 2
        }
    }

    "주문 생성 시 전달된 금액이 1000원 단위가 아닐 경우 예외를 반환한다." {
        val lottoShop = LottoShop(LottoCreator(FixedLottoNumberGenerator()))
        shouldThrow<IllegalArgumentException> { lottoShop.makeOrder(10001) }
    }
})
