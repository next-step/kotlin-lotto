package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf

internal class IssuerTest : StringSpec({

    "로또를 생성할 수 있다" {
        val lotto = Issuer.issue()

        lotto.shouldBeInstanceOf<Lotto>()
    }

    "생성한 로또 숫자는 오름차순으로 정렬된다 " {
        repeat(1000) {
            val lotto = Issuer.issue()

            lotto.numbers.map { it.value } shouldBe lotto.numbers.map { it.value }.sorted()
        }
    }
})
