package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockkObject
import lotto.util.ExceptionMessage
import lotto.util.Reader
import java.lang.IllegalArgumentException

internal class WinnerLottoTicketTest : BehaviorSpec({
    Given("보너스 볼에 ") {
        mockkObject(Reader)
        When("당첨 티켓에 있는 번호가 들어온다면 ") {
            every { Reader.read() } returnsMany(listOf("1, 2, 3, 4, 5, 6", "1"))
            Then("예외를 던진다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    WinnerLottoTicket(
                        LottoManualGenerateStrategy(),
                        BonusManualGenerateStrategy()
                    )
                }
                exception.message shouldBe ExceptionMessage.BONUS_NUMBER_NOT_DUPLICATE_ERROR
            }
        }

        When("당첨 티켓에 있는 번호가 들어오지 않는다면 ") {
            every { Reader.read() } returnsMany(listOf("1, 2, 3, 4, 5, 6", "7"))
            Then("정상적으로 생성한다.") {
                WinnerLottoTicket(
                    LottoManualGenerateStrategy(),
                    BonusManualGenerateStrategy()
                )
            }
        }
    }
})
