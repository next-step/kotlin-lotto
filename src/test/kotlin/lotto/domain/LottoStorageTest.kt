package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto.util.NumberGenerator

class LottoStorageTest : StringSpec({

    "로또 구입 금액을 입력받으면 구입할 수 있는 개수만큼 로또를 생성한다" {
        // given
        val buyingPrice = LottoBuyingPrice(2000)

        // when
        val lottoStorage = LottoStorage(
            buyingPrice = buyingPrice,
            lottoNumberGenerator = createFakeNumberGenerator()
        )

        // then
        lottoStorage.getLottoCount() shouldBe 2
    }

    "로또 구입 금액을 바탕으로 거스름돈을 반환한다." {
        forAll(
            row(2000, 0),
            row(2500, 500)
        ) { price, expectedChange ->
            // given
            val buyingPrice = LottoBuyingPrice(price)

            // when
            val lottoStorage = LottoStorage(
                buyingPrice = buyingPrice,
                lottoNumberGenerator = createFakeNumberGenerator()
            )

            // then
            lottoStorage.getChange() shouldBe expectedChange
        }
    }
})

private fun createFakeNumberGenerator() = object : NumberGenerator {
    override fun generate(count: Int): List<Int> {
        return listOf(1, 2, 3, 4, 5, 6)
    }
}
