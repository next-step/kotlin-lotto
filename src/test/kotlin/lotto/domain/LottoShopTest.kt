package lotto.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldHaveSize

class LottoShopTest : FreeSpec({

    val lottoGenerator = LottoGenerator(object : NumberGenerator {
        override fun generate(): List<Int> = listOf(1, 2, 3, 4, 5, 6)
    })

    "buy" - {

        "3000원으로 3개 로또를 구매한다." {
            val lottoshop = LottoShop(lottoGenerator)

            val lottoList = lottoshop.buy(3000)
            lottoList shouldHaveSize 3
        }
    }
})
