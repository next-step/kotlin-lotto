package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockkObject
import lotto.domain.WinnerLottoTicket.Companion.BONUS_NUMBER_NOT_DUPLICATE_ERROR
import lotto.util.Reader
import java.lang.IllegalArgumentException

internal class WinnerLottoTicketTest : BehaviorSpec({
    Given("보너스 볼에 ") {
        mockkObject(Reader)
        val lottoNumbers = setOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )
        When("당첨 티켓에 있는 번호가 들어온다면 ") {
            every { Reader.read() } returnsMany(listOf("1, 2, 3, 4, 5, 6", "1"))
            Then("예외를 던진다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    WinnerLottoTicket(
                        winnerBonusNumber = LottoNumber(1),
                        winnerLottoNumbers = LottoTicket(lottoNumbers)
                    )
                }
                exception.message shouldBe BONUS_NUMBER_NOT_DUPLICATE_ERROR
            }
        }

        When("당첨 티켓에 있는 번호가 들어오지 않는다면 ") {
            every { Reader.read() } returnsMany(listOf("1, 2, 3, 4, 5, 6", "7"))
            Then("정상적으로 생성한다.") {
                WinnerLottoTicket(
                    winnerBonusNumber = LottoNumber(7),
                    winnerLottoNumbers = LottoTicket(lottoNumbers)
                )
            }
        }
    }
})
