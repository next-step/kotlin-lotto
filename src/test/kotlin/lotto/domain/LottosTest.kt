package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.util.NumberGenerator

class LottosTest : StringSpec({

    "로또 구입 금액을 입력받으면 구입할 수 있는 개수만큼 로또를 생성한다" {
        // given
        val buyingPrice = LottoBuyingPrice(2000)

        // when
        val lottos = Lottos(
            buyingPrice = buyingPrice,
            lottoNumberGenerator = createFakeNumberGenerator()
        )

        // then
        lottos.lottos.size shouldBe 2
    }
})

private fun createFakeNumberGenerator() = object : NumberGenerator {
    override fun generate(count: Int): List<Int> {
        return listOf(1, 2, 3, 4, 5, 6)
    }
}
