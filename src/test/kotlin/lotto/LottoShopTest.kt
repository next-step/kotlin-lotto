package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class LottoShopTest : FreeSpec({

    "로또 구매 테스트" - {
        val lottoShop = LottoShop()

        "1000원 단위가 아닐 때 (999원) 예외 발생" {
            val exception =
                shouldThrow<IllegalArgumentException> {
                    lottoShop.buyLotto(Money("999"))
                }
            exception.message shouldBe "1000원 단위로 입력안됨"
        }

        "1000원 단위일 때 (1000원) 로또 1장 구매됨" {
            val lotto = lottoShop.buyLotto(Money("1000"))
            lotto.size shouldBe 1
        }

        "1000원 단위일 때 (2000원) 로또 2장 구매됨" {
            val lotto = lottoShop.buyLotto(Money("2000"))
            lotto.size shouldBe 2
        }
    }
})
