package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.domin.Lotto
import lotto.util.LottoNumberGenerator

class LottoTest : FreeSpec({

    "issuanceCount" - {

        "주어진 금액에 알맞게 로또 발행 수를 반환해야한다." {
            val payment = 1000
            val lottoNumber = LottoNumberGenerator.Fake(listOf(1, 2, 3, 4, 5, 6))
            Lotto(payment, lottoNumber).issuanceCount() shouldBe 1
        }
    }

    "issuance" - {

        "중복되지 않는 6숫자를 갖는 로또가 나와야한다." {
            val payment = 2000
            val fakeNumber = listOf(1, 2, 3, 4, 5, 6)
            val lottoNumberGenerator = LottoNumberGenerator.Fake(fakeNumber)
            Lotto(payment, lottoNumberGenerator).issuance() shouldBe fakeNumber
        }
    }
})
