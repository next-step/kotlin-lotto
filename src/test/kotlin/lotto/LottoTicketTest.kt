package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec

internal class LottoTicketTest : FunSpec({
    test("6자리의 숫자가 아닌 경우 예외가 발생한다.") {
        // given
        val lottoNumbers: Set<LottoNumber> = setOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
        )

        // when then
        shouldThrow<IllegalArgumentException> {
            LottoTicket(lottoNumbers)
        }
    }

    test("6자리 숫자는 중복을 허용하지 않는다.") {
        // given
        val lottoNumbers: Set<LottoNumber> = setOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(5),
        )

        // when then
        shouldThrow<IllegalArgumentException> {
            LottoTicket(lottoNumbers)
        }
    }
})
