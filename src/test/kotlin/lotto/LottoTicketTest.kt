package lotto

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoTicketTest {

    @Test
    fun `로또에 6개의 번호가 없을 경우`() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy {
                LottoTicket(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2)
                    )
                )
            }
            .withMessage("로또 번호는 6자리여야합니다.")
    }

    @Test
    fun `로또에 중복된 번호가 있을 경우`() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy {
                LottoTicket(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(4),
                        LottoNumber(6)
                    )
                )
            }
            .withMessage("로또 번호는 중복불가능합니다")
    }
}
