package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.throwable.shouldHaveMessage

class LottoTicketNumberTest : DescribeSpec({
    describe("validation") {
        it("최소 숫자 보다 낮은 값을 넣으면 에러가 발생한다") {
            // given
            val failedNumber = 0

            // then
            shouldThrowExactly<IllegalArgumentException> {
                LottoTicketNumber(failedNumber)
            }.shouldHaveMessage("로또 숫자는 최소 1 이상 45 이하에 값을 넣을수 있습니다")
        }

        it("최대 숫자 보다 큰 값을 넣으면 에러가 발생한다") {
            // given
            val failedNumber = 46

            // then
            shouldThrowExactly<IllegalArgumentException> {
                LottoTicketNumber(failedNumber)
            }.shouldHaveMessage("로또 숫자는 최소 1 이상 45 이하에 값을 넣을수 있습니다")
        }
    }
})
