package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.types.shouldBeInstanceOf

internal class LottoIssuerTest : StringSpec({

    "로또를 생성할 수 있다" {
        val issuer = LottoIssuer()

        val lotto = issuer.issue()

        lotto.shouldBeInstanceOf<Lotto>()
    }
})
