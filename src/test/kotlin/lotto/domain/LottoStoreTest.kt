package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoStoreTest : StringSpec({
    val lottoNumberGenerator = RandomNumberGenerator()
    val lottoFactory = LottoFactory(lottoNumberGenerator)
    val sut = LottoStore(lottoFactory)

    "입력받은 주문만큼 로또를 생성한다" {
        val money = Money(14000)
        val lottoOrder = LottoOrder(money)

        val actual = sut.sell(lottoOrder)

        actual.quantity shouldBe 14
    }

    "입력받은 주문과 수동으로 입력한 숫자로 로또를 생성한다" {
        val money = Money(14000)
        val manualLottoNumbers = listOf(listOf(1, 2, 3, 4, 5, 6), listOf(7, 8, 9, 10, 11, 12))
        val manualCount = 2
        val lottoOrder =
            LottoOrder(
                money = money,
                manualCount = manualCount,
                manualLottoNumbers = manualLottoNumbers,
            )

        val actual = sut.sell(lottoOrder)

        actual.quantity shouldBe 14
    }
})
