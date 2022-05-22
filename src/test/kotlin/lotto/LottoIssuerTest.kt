package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.ints.shouldBeBetween
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf

internal class LottoIssuerTest : StringSpec({

    "로또를 생성할 수 있다" {
        val lotto = LottoIssuer.issue()

        lotto.shouldBeInstanceOf<Lotto>()
    }

    "생성한 로또는 1에서 45 사이의 숫자를 가진다" {
        repeat(1000) {
            val lotto = LottoIssuer.issue()

            lotto.numbers.forAll {
                it.shouldBeBetween(1, 45)
            }
        }
    }

    "생성한 로또 숫자는 오름차순으로 정렬된다 " {
        repeat(1000) {
            val lotto = LottoIssuer.issue()

            lotto.numbers shouldBe lotto.numbers.sorted()
        }
    }
})
