package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.beInstanceOf

class StoreTest : DescribeSpec({
    describe("로또 판매기 테스트") {
        val lottoNumbers = listOf(
            listOf(8, 21, 23, 41, 42, 43).map { LottoNumber.of(it) }.toSet(),
            listOf(3, 5, 11, 16, 32, 38).map { LottoNumber.of(it) }.toSet()
        )
        val ticket = Ticket(14000, lottoNumbers)

        it("로또를 자동으로 구매할 수 있다.") {
            val purchasedAutoLottos = Store.purchaseAutoLottos(ticket)

            purchasedAutoLottos should beInstanceOf<Lottos>()
            purchasedAutoLottos.elements.size shouldBe 12
        }

        it("로또를 수동으로 구매할 수 있다.") {
            val purchasedManualLottos = Store.purchaseManualLotto(ticket)

            purchasedManualLottos should beInstanceOf<Lottos>()
            purchasedManualLottos.elements.size shouldBe 2
        }
    }
})
