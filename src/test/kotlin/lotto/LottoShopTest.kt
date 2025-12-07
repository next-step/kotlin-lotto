package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class LottoShopTest : FreeSpec({

    "로또 구매 테스트" - {
        val lottoShop = LottoShop()

        "1000 입력 시 로또 1장 구매됨" {
            val lotto = lottoShop.buyLotto(LottoMoney("1000"), listOf())
            lotto.size shouldBe 1
        }

        "2000원 입력 시 로또 2장 구매됨" {
            val lotto = lottoShop.buyLotto(LottoMoney("2000"), listOf())
            lotto.size shouldBe 2
        }

        "3000원, 수동 1장 구매 시 로또 3장 구매됨" {
            val lotto = lottoShop.buyLotto(LottoMoney("3000"), listOf("1, 2, 3, 4, 5, 6"))
            lotto.size shouldBe 3
        }
    }
})
