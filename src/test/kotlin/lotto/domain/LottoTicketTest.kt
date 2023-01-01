package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import lotto.utils.LottoNumberTestUtils
import java.lang.IllegalArgumentException

class LottoTicketTest : StringSpec({
    "로또는 6개의 로또 숫자를 가지고 있어요" {
        val numbers = LottoNumberTestUtils.lottoNumbers(1, 2, 3, 4, 5)
        shouldThrow<IllegalArgumentException> {
            LottoTicket(numbers)
        }
    }
})
