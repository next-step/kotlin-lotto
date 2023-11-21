package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.WithDataTestName
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class LottoTicketIssuerTest : FunSpec({

    context("금액에 맞는 수량만큼 로또를 발급핸다.") {
        withData(
            IssueLottoByAutoTestData(1000L, 1000L, 1),
            IssueLottoByAutoTestData(1000L, 2000L, 2),
            IssueLottoByAutoTestData(1000L, 2900L, 2),
            IssueLottoByAutoTestData(2000L, 10000L, 5),
        ) { (lottoTicketPrice, money, lottoAmount) ->

            val lottoTicketIssuer = LottoTicketIssuer(lottoTicketPrice = lottoTicketPrice)

            lottoTicketIssuer.issueLottoByAuto(money).size shouldBe lottoAmount
        }
    }

    context("구입금액이 음수인 경우 IllegalArgumentException throw") {
        withData(
            nameFn = { "${it}원" },
            -10L, -3L, -1L,
        ) { purchaseMoney ->

            val lottoTicketIssuer = LottoTicketIssuer()

            shouldThrow<IllegalArgumentException> {
                lottoTicketIssuer.issueLottoByAuto(purchaseMoney)
            }
        }
    }
})

data class IssueLottoByAutoTestData(val lottoTicketPrice: Long, val money: Long, val lottoAmount: Int) : WithDataTestName {
    override fun dataTestName(): String = "로또 1장이 ${lottoTicketPrice}원일 때, ${money}원 => ${lottoAmount}개 발급"
}
