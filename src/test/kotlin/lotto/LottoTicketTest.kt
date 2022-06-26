package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

internal class LottoTicketTest : FunSpec({
    test("6자리의 숫자가 아닌 경우 예외가 발생한다.") {
        // given
        val lottoNumbers: Set<LottoNumber> = setOf(
            LottoNumber.of(1),
            LottoNumber.of(2),
            LottoNumber.of(3),
            LottoNumber.of(4),
            LottoNumber.of(5),
        )

        // when then
        shouldThrow<IllegalArgumentException> {
            LottoTicket(lottoNumbers)
        }
    }

    test("6자리 숫자는 중복을 허용하지 않는다.") {
        // given
        val lottoNumbers: Set<LottoNumber> = setOf(
            LottoNumber.of(1),
            LottoNumber.of(2),
            LottoNumber.of(3),
            LottoNumber.of(4),
            LottoNumber.of(5),
            LottoNumber.of(5),
        )

        // when then
        shouldThrow<IllegalArgumentException> {
            LottoTicket(lottoNumbers)
        }
    }

    test("contains 함수를 호출해서, LottoTicket 내에 로또 번호가 있으면 true를 반환한다.") {
        // given
        val lottoTicket: LottoTicket = LottoTicketFixture.simpleLottoTicket(1, 2, 3, 4, 5, 6)

        // when
        val result: Boolean = lottoTicket.contains(LottoNumber.of(1))

        // then
        result.shouldBeTrue()
    }

    test("contains 함수를 호출해서, LottoTicket 내에 로또 번호가 없으면 false를 반환한다.") {
        // given
        val lottoTicket: LottoTicket = LottoTicketFixture.simpleLottoTicket()

        // when
        val result: Boolean = lottoTicket.contains(LottoNumber.of(7))

        // then
        result.shouldBeFalse()
    }
})
