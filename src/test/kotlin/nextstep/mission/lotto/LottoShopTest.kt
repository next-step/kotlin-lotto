package nextstep.mission.lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe
import nextstep.mission.lotto.fixture.lottoNumberListOf
import nextstep.mission.lotto.vo.LottoNumbers

class LottoShopTest : StringSpec({

    "로또 가게에선 입력한 금액만큼의 로또를 구매할 수 있다. (입력한 수동 로또 갯수외에는 자동 로또를 구매한다.)" {
        val manualLottoNumbers: List<List<Int>> = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(11, 12, 13, 14, 15, 16),
            listOf(11, 22, 33, 44, 21, 32)
        )
        val purchasePrice = 10_000

        val result: Lotto = LottoShop.purchase(purchasePrice, manualLottoNumbers)

        result.lottoNumbers.size shouldBe 10
        result.lottoNumbers shouldContainAll listOf(
            LottoNumbers(lottoNumberListOf(1, 2, 3, 4, 5, 6)),
            LottoNumbers(lottoNumberListOf(11, 12, 13, 14, 15, 16)),
            LottoNumbers(lottoNumberListOf(11, 22, 33, 44, 21, 32))
        )
    }

    "로또 가게에서 입력한 금액만큼의 로또를 구매할 수 있다." {
        listOf(
            10_000 to 10,
            14_900 to 14,
            900 to 0,
        ).forEach { (purchasePrice: Int, expected: Int) ->
            val result: Lotto = LottoShop.purchaseAutoLotto(purchasePrice)

            result.lottoNumbers.size shouldBe expected
        }
    }

    "로또 가게에서 수동으로 구매할 번호로 로또를 구매할 수 있다." {
        val manualLottoNumbers: List<List<Int>> = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(11, 12, 13, 14, 15, 16),
            listOf(11, 22, 33, 44, 21, 32)
        )

        val result: Lotto = LottoShop.purchaseManualLotto(manualLottoNumbers)

        result.lottoNumbers.size shouldBe 3
    }
})
