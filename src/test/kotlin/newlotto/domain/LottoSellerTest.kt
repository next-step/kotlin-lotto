package newlotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.equality.shouldBeEqualToComparingFields
import io.kotest.matchers.shouldBe
import newlotto.Lotto
import newlotto.LottoNumberFactory
import newlotto.LottoSeller

class LottoSellerTest : DescribeSpec({
    it("구매 금액만큼 로또를 생성해서 판매한다.") {
        val lottoSeller = LottoSeller(StubLottoNumberFactory(listOf(1,2,3,4,5,6)))

        val lottos = lottoSeller.sell(14000)

        lottos.size shouldBe 14
    }
})

class StubLottoNumberFactory(private val fakeLottoNumbers: List<Int>): LottoNumberFactory {
    override fun generate(): Lotto {
        return Lotto(fakeLottoNumbers)
    }
}
