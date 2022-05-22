package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.ints.shouldBeBetween
import io.kotest.matchers.types.shouldBeInstanceOf

internal class LottoIssuerTest : StringSpec({

    "로또를 생성할 수 있다" {
        val issuer = LottoIssuer()

        val lotto = issuer.issue()

        lotto.shouldBeInstanceOf<Lotto>()
    }

    "생성한 로또는 1에서 45 사이의 숫자를 가진다" {
        val issuer = LottoIssuer()

        val lotto = issuer.issue()

        lotto.numbers.forAll {
            it.shouldBeBetween(1, 45)
        }
    }
})
