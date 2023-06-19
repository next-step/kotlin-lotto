package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class MoneyKoTest : StringSpec({

    "천원부터 십만원까지 범위를 벗어나면 에러" {
        listOf(-1, 999, 100001).forAll {
            shouldThrow<IllegalArgumentException> {
                Money(it)
            }
        }
    }

    "천원부터 십만원까지 구매 성공" {
        listOf(1000, 100000).forAll {
            Money(it) shouldBe Money(it)
        }
    }

    "금액 당 구매할 수 있는 로또 개수 확인" {
        mapOf(
            1000 to 1,
            100000 to 100,
            5000 to 5,
            30000 to 30,
        ).forAll { (money, count) ->
            Money(money).countLotto() shouldBe count
        }
    }
})
