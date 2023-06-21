package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.collections.shouldHaveSize
import java.lang.IllegalArgumentException

internal class LottoSellerTest : StringSpec({
    val lottoPrice = 1000
    val sut = LottoSeller(LottoFactory, lottoPrice)

    "총 구입금액을 입력하면 금액에 맞춰 로또를 생성해서 반환한다" {
        sut.sell(14000) shouldHaveSize 14
    }

    "로또의 가격보다 적은 구매금액을 입력받으면 예외를 발생시킨다" {
        table(
            headers("totalPrice"),
            row(0),
            row(-1),
            row(lottoPrice - 1)
        ).forAll {
            shouldThrow<IllegalArgumentException> {
                sut.sell(it)
            }
        }
    }

    "로또의 가격이 나누어 떨어지지 않으면 예외를 발생시킨다" {
        shouldThrow<IllegalArgumentException> {
            sut.sell(1100)
        }
    }
})
