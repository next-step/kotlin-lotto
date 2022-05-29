package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.extension.autoOf
import lotto.extension.manualOf

internal class PurchaseRequestTest : StringSpec({

    "금액과 수동 로또번호 목록을 받아 인스턴스를 생성한다" {
        val lottoNumbers = Lotto.manualOf(1, 2, 3, 4, 5, 6)
        val request = PurchaseRequest(Money(1000), listOf(lottoNumbers))

        request.money.amount shouldBe 1000
        request.manualLottos shouldBe listOf(lottoNumbers)
    }

    "자동 로또를 제공하면 에러가 발생한다" {
        val lottoNumbers = Lotto.autoOf(1, 2, 3, 4, 5, 6)

        shouldThrow<java.lang.IllegalArgumentException> {
            PurchaseRequest(Money(1000), listOf(lottoNumbers))
        }
    }
})
