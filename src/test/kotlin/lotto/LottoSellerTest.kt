package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

internal class LottoSellerTest : StringSpec({
    val sut = LottoSeller()

    "총 구입금액을 입력하면 구매할 수 있는 로또 갯수를 반환한다" {
        sut.sell(14000) shouldBe 14
    }

    "0 이하의 금액이 입력되면 예외를 발생시킨다" {
        table(
            headers("totalPrice"),
            row(0),
            row(-1)
        ).forAll {
            shouldThrow<IllegalArgumentException> {
                sut.sell(it)
            }
        }
    }
})
