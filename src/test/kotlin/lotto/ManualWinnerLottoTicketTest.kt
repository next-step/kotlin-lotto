package lotto

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockkObject
import lotto.util.ExceptionMessage
import lotto.util.Reader
import java.lang.IllegalArgumentException

internal class ManualWinnerLottoTicketTest : BehaviorSpec({
    mockkObject(Reader)
    Given("수동 입력으로 진행한 당첨 티켓이 ") {
        When("중복된 숫자를 포함한다면 ") {
            every { Reader.read() } returns "1, 2, 3, 4, 6, 6"
            Then("예외를 반환한다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    ManualWinnerLottoTicket()
                }
                exception.message shouldBe ExceptionMessage.LOTTO_NUMBER_SIZE_ERROR
            }
        }

        When("숫자가 6개가 아니라면 ") {
            every { Reader.read() } returns "1, 2, 3, 4, 5, 6, 7"
            Then("예외를 반환한다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    ManualWinnerLottoTicket()
                }
                exception.message shouldBe ExceptionMessage.LOTTO_NUMBER_SIZE_ERROR
            }

            every { Reader.read() } returns "1, 2, 3, 4, 5"
            Then("예외를 반환한다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    ManualWinnerLottoTicket()
                }
                exception.message shouldBe ExceptionMessage.LOTTO_NUMBER_SIZE_ERROR
            }
        }

        When("정상적이라면 ") {
            every { Reader.read() } returns "1, 2, 3, 4, 5, 6"
            Then("정상적으로 생성한다.") {
                shouldNotThrowAny {
                    ManualWinnerLottoTicket()
                }
            }
        }
    }
})
