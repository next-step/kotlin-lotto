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

    "금액에 따라 올바른 로또 목록을 받는다" - {
        listOf(
            1000,
            5000,
            14000,
        ).forEach { money ->
            "$money 원으로 구매하는 경우" {
                val result = store.buy(Money(money))

                result shouldHaveSize money / 1000
            }
        }
    }
})
