package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldInclude

class LottoGameTest : StringSpec({

    "로또 구매 금액 입력 시 구입 티켓 수량은 구입 금액/1000 으로 계산한다." {
        forAll(
            row(2000, 2),
            row(5200, 5),
            row(53000, 53)
        ) { purchaseAmount, expect ->
            LottoGame(purchaseAmount).ticketQuantity shouldBe expect
        }
    }

    "로또 구매 금액이 1000원 미만이면 예외가 발생한다" {
        forAll(
            row(900),
            row(990),
            row(500)
        ) { purchaseAmount ->
            shouldThrow<IllegalArgumentException> {
                LottoGame(purchaseAmount)
            }.message shouldInclude "구매금액은 1000원 이상이어야 합니다."
        }
    }
})
