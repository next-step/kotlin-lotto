package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldHaveSize

internal class LottoStoreTest : FreeSpec({
    val issuer = LottoIssuable { Lotto(listOf(1, 2, 3, 4, 5, 6)) }
    val store = LottoStore(issuer)

    "0원으로 구매를 시도하면 로또를 얻지 못한다" {
        val money = Money(0)

        val result = store.buy(money)

        result.shouldBeEmpty()
    }

    "구매 성공" - {
        listOf(
            1000 to 1,
            14000 to 14,
            14999 to 14,
        ).forEach { (money, count) ->
            "$money 원으로 구매하는 경우 $count 개를 받는다" {
                val result = store.buy(Money(money))

                result shouldHaveSize count
            }
        }
    }
})
