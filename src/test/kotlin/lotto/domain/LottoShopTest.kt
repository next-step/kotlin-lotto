package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.equality.shouldBeEqualToComparingFields
import io.kotest.matchers.shouldBe
import lotto.common.IntegerNumber
import lotto.common.IntegerNumberList
import lotto.util.RandomNumberGenerator

class LottoShopTest : StringSpec({

    val lottoShop = LottoShop(LottoGenerator(RandomNumberGenerator()))

    "로또 구매 개수 검증 테스트" {
        forAll(
            // given
            row("0원을 내면 0개를 반환한다.", Payment(IntegerNumber(0)), 0),
            row("5000원을 내면 5개를 반환한다.", Payment(IntegerNumber(5000)), 5),
            row("5500원을 내면 5개를 반환한다.", Payment(IntegerNumber(5500)), 5)
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
                IntegerNumber(1),
                IntegerNumber(2),
                IntegerNumber(3),
                IntegerNumber(4),
                IntegerNumber(5),
                IntegerNumber(6)
            )
        )
        val result = lottoShop.buyManualLotto(Payment(IntegerNumber(1000)), listOf(manualNumberList))
        result[0] shouldBeEqualToComparingFields Lotto(
            listOf(
                LottoNumber(IntegerNumber(1)),
                LottoNumber(IntegerNumber(2)),
                LottoNumber(IntegerNumber(3)),
                LottoNumber(IntegerNumber(4)),
                LottoNumber(IntegerNumber(5)),
                LottoNumber(IntegerNumber(6))
            )
        )
    }
})
