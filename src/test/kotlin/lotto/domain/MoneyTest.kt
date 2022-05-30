package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.throwable.shouldHaveMessage
import lotto.dto.UserMoneyInputDto

class MoneyTest : DescribeSpec({
    it("음수인 경우 에러 발생") {
        // given
        val moneyByString = "-10"

        // then
        shouldThrowExactly<IllegalArgumentException> {
            UserMoneyInputDto(moneyByString)
        }.shouldHaveMessage("$moneyByString 금액은 설정할수 없습니다. 0 이상에 금액을 입력해주세요")
    }
})
