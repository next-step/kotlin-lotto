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
        val lottoStorage = createLottoStorage(buyingPrice)

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
            val lottoStorage = createLottoStorage(buyingPrice)

            // then
            lottoStorage.getChange() shouldBe expectedChange
        }
    }

    "로또 당첨 번호를 받아 로또 결과를 반환한다." {
        // given
        val lottoStorage = createLottoStorage(LottoBuyingPrice(2000))
        val winningLotto = Lotto(listOf(2, 3, 6, 7, 8, 9))

        // when
        val lottoResult = lottoStorage.getResult(winningLotto)

        // then
        lottoResult.result shouldBe mutableMapOf(
            LottoResult.Rank.THREE to 2,
            LottoResult.Rank.FOUR to 0,
            LottoResult.Rank.FIVE to 0,
            LottoResult.Rank.SIX to 0,
        )
        lottoResult.earningRate shouldBe 5.0
    }
})

private fun createLottoStorage(buyingPrice: LottoBuyingPrice): LottoStorage {
    return LottoStorage(
        buyingPrice = buyingPrice,
        lottoNumberGenerator = createFakeNumberGenerator()
    )
}

private fun createFakeNumberGenerator() = object : NumberGenerator {
    override fun generate(count: Int): List<Int> {
        return listOf(1, 2, 3, 4, 5, 6)
    }
}
