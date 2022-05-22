package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

internal class LottoStoreTest : FreeSpec({
    val store = LottoStore { Lotto(listOf(1, 2, 3, 4, 5, 6)) }

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

    "제공한 발급자를 통해서 로또를 생성한다" {
        val lotto = Lotto(listOf(5, 6, 7, 8, 9, 10))
        val lottoStore = LottoStore { lotto }

        val result = lottoStore.buy(Money(LottoStore.LOTTO_PRICE))

        result.first() shouldBe lotto
    }
})
