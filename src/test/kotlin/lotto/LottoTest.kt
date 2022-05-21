package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class LottoTest : FreeSpec({

    "issuance" - {

        "주어진 금액에 알맞게 로또 발행 수를 반환해야한다." {
            val payment = 1000
            val lottoNumber = LottoNumberGenerator.Fake(listOf(1, 2, 3, 4, 5, 6))
            Lotto(payment, lottoNumber).issuanceCount() shouldBe 1
        }
    }
})
