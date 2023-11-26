package lotto2.application

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto2.domain.LottoMoney
import lotto2.domain.LottoNumber
import lotto2.domain.LottoNumbers

class LottoShopTest : StringSpec({

    "자동 로또를 3개를 구매할 때, 구매 금액이 2000원이면 예외가 발생한다." {
        val 구매금액 = LottoMoney(2000)
        val 구매수량 = 3

        shouldThrow<IllegalArgumentException> {
            LottoShop.buyAutoTickets(구매금액, 구매수량)
        }
    }

    "자동 로또를 3개를 구매할 때, 구매 금액이 3000원 이상이면 로또 티켓 3장을 반환한다." {
        val 구매금액 = LottoMoney(3000)
        val 구매수량 = 3

        val autoTickets = LottoShop.buyAutoTickets(구매금액, 구매수량)

        autoTickets.size shouldBe 구매수량
    }

    "수동 로또를 3개를 구매할 때, 구매 금액이 2000원이면 예외가 발생한다." {
        val 구매금액 = LottoMoney(2000)
        val 수동로또번호목록 = listOf(
            LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }),
            LottoNumbers(listOf(1, 3, 5, 7, 9, 11).map { LottoNumber(it) }),
            LottoNumbers(listOf(45, 43, 41, 39, 37, 35).map { LottoNumber(it) })
        )

        shouldThrow<IllegalArgumentException> {
            LottoShop.buyManualTicket(구매금액, 수동로또번호목록)
        }
    }

    "수동 로또를 3개를 구매할 때, 구매 금액이 3000원 이상이면 로또 티켓 3장을 반환한다." {
        val 구매금액 = LottoMoney(3000)
        val 수동로또번호목록 = listOf(
            LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }),
            LottoNumbers(listOf(1, 3, 5, 7, 9, 11).map { LottoNumber(it) }),
            LottoNumbers(listOf(45, 43, 41, 39, 37, 35).map { LottoNumber(it) })
        )

        val autoTickets = LottoShop.buyManualTicket(구매금액, 수동로또번호목록)

        autoTickets.size shouldBe 수동로또번호목록.size
    }
})
