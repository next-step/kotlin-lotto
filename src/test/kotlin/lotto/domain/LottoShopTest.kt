package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto.common.Number
import lotto.util.RandomNumberGenerator

class LottoShopTest : StringSpec({

    val lottoShop = LottoShop(LottoGenerator(RandomNumberGenerator()))

    "로또 구매 테스트" {
        forAll(
            // given
            row("0원을 내면 0개를 반환한다.", Payment(Number(0)), 0),
            row("5000원을 내면 5개를 반환한다.", Payment(Number(5000)), 5),
            row("5500원을 내면 5개를 반환한다.", Payment(Number(5500)), 5)
        ) { title, payment, expectedSize ->
            // when
            val actual = lottoShop.buyLotto(payment)
            // then
            actual.size shouldBe expectedSize
        }
    }
})
