package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class LottoShopTest : FreeSpec({

    "로또 구매 테스트" - {
        "1000원 단위가 아닐 때 (999원) 예외 발생" {
            val money = Money(999)
            val manualCount = ManualCount(money, 0)
            val manualLottoOrder = ManualLottoOrder(manualCount, emptyList())
            val exception =
                shouldThrow<IllegalArgumentException> {
                    LottoShop.sellLotto(money, manualLottoOrder)
                }
            exception.message shouldBe "1000원 단위로 입력해주세요"
        }

        "1000원 단위일 때 (1000원) 로또 1장 구매됨" {
            val money = Money(1000)
            val manualCount = ManualCount(money, 0)
            val manualLottoOrder = ManualLottoOrder(manualCount, emptyList())
            val lottoTicket = LottoShop.sellLotto(money, manualLottoOrder)
            lottoTicket.lottos.size shouldBe 1
        }

        "1000원 단위일 때 (2000원) 로또 2장 구매됨" {
            val money = Money(2000)
            val manualCount = ManualCount(money, 0)
            val manualLottoOrder = ManualLottoOrder(manualCount, emptyList())
            val lottoTicket = LottoShop.sellLotto(money, manualLottoOrder)
            lottoTicket.lottos.size shouldBe 2
        }
    }
})
