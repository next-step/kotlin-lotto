package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoShopTest:StringSpec({

    "금액을 입력하면 로또 티켓의 수가 반환된다."{
        LottoShop.getTicketCount(10000) shouldBe 10
    }

    "잘못된 금액을 입력하면 예외가 발생한다."{
        shouldThrow<IllegalArgumentException> {
            LottoShop.getTicketCount(10030)
        }.message shouldBe "1000원 단위로 입력해주세요."

    }
})
