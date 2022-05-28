package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

internal class StoreTest : FreeSpec({
    val autoLotto = Lotto.autoOf(1, 2, 3, 4, 5, 6)
    val manualLottos = listOf(
        Lotto.manualOf(1, 2, 3, 4, 5, 6),
        Lotto.manualOf(1, 2, 3, 4, 5, 6),
    )
    val store = Store { autoLotto }

    "0원으로 구매를 시도하면 로또를 얻지 못한다" {
        val money = Money(0)
        val request = PurchaseRequest(money)

        val result = store.buy(request)

        result.shouldBeEmpty()
    }

    "구매 성공" - {
        listOf(
            1000 to 1,
            14000 to 14,
            14999 to 14,
        ).forEach { (money, count) ->
            "$money 원으로 구매하는 경우 $count 개를 받는다" {
                val result = store.buy(PurchaseRequest(Money(money)))

                result shouldHaveSize count
            }
        }
    }

    "주어진 금액으로 수동 로또를 구매하지 못하는 경우 에러가 발생한다" {
        val request = PurchaseRequest(Money(1), manualLottos)

        shouldThrow<IllegalArgumentException> {
            store.buy(request)
        }
    }

    "수동 로또가 아닌 나머지 로또는 제공한 발급자를 통해서 생성한다" {
        val lottoCount = 10
        val money = Money(Store.LOTTO_PRICE * lottoCount)

        val result = store.buy(PurchaseRequest(money, manualLottos))

        result.count { it.isManual } shouldBe manualLottos.size
        result.count { it.isAuto } shouldBe lottoCount - manualLottos.size
    }
})
