package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.equality.shouldBeEqualToComparingFields
import io.kotest.matchers.shouldBe
import lotto.common.IntegerNumberList
import lotto.util.RandomNumberGenerator

class LottoShopTest : StringSpec({

    val lottoShop = LottoShop(LottoGenerator(RandomNumberGenerator()))

    "로또 구매 개수 검증 테스트" {
        forAll(
            // given
            row("0원을 내면 0개를 반환한다.", Payment(0), 0),
            row("5000원을 내면 5개를 반환한다.", Payment(5000), 5),
            row("5500원을 내면 5개를 반환한다.", Payment(5500), 5)
        ) { title, payment, expectedSize ->
            // when
            val actual = lottoShop.buyAutoLotto(payment)
            // then
            actual.size shouldBe expectedSize
        }
    }

    "수동 로또 구매 테스트" {
        val manualNumberList = IntegerNumberList(
            listOf(
                1,
                2,
                3,
                4,
                5,
                6
            )
        )
        val result = lottoShop.buyManualLotto(Payment(1000), listOf(manualNumberList))
        result[0] shouldBeEqualToComparingFields Lotto(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )
    }
})
