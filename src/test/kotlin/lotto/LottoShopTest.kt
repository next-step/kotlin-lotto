package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class LottoShopTest : FreeSpec({

    "로또 구매 테스트" - {
        val lottoShop = LottoShop()

        "1000원 단위일 때 (1000원) 로또 1장 구매됨" {
            val lotto = lottoShop.buyLotto(LottoMoney("1000"), listOf())
            lotto.size shouldBe 1
        }

        "1000원 단위일 때 (2000원) 로또 2장 구매됨" {
            val lotto = lottoShop.buyLotto(LottoMoney("2000"), listOf())
            lotto.size shouldBe 2
        }
    }
})
