package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.WithDataTestName
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class LottoTicketIssuerTest : FunSpec({

    lateinit var lottoTicketIssuer: LottoTicketIssuer

    beforeTest {
        lottoTicketIssuer = LottoTicketIssuer()
    }

    context("금액에 맞는 수량만큼 로또를 발급핸다.") {
        withData(
            nameFn = { "${it.money}원 => ${it.lottoAmount}개" },
            IssueLottoByAutoTestData(1000L, 1),
            IssueLottoByAutoTestData(2000L, 2),
            IssueLottoByAutoTestData(2900L, 2),
            IssueLottoByAutoTestData(10000L, 10),
        ) { (money, lottoAmount) ->
            lottoTicketIssuer.issueLottoByAuto(money).size shouldBe lottoAmount
        }
    }

    context("구입금액이 음수인 경우 IllegalArgumentException throw") {
        withData(
            nameFn = { "${it}원" },
            -10L, -3L, -1L,
        ) { purchaseMoney ->
            shouldThrow<IllegalArgumentException> {
                lottoTicketIssuer.issueLottoByAuto(purchaseMoney)
            }
        }
    }
})

data class IssueLottoByAutoTestData(val money: Long, val lottoAmount: Int) : WithDataTestName {
    override fun dataTestName(): String = "${money}원 => : ${lottoAmount}개"
}
