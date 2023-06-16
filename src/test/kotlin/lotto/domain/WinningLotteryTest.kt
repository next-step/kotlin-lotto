package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.throwable.shouldHaveMessage
import lotto.mockLottoNumbers
import lotto.model.LottoErrorCode

class WinningLotteryTest : StringSpec({

    "당첨 복권을 생성할 때 당첨 번호와 보너스볼이 겹치면 포함되면 안 된다는 에러가 발생한다." {
        val numbers = mockLottoNumbers(1, 2, 3, 4, 5, 6)
        val bonusBall = LottoNumber(number = 3)

        val exception = shouldThrow<IllegalStateException> {
            WinningLottery(
                numbers = numbers,
                bonusBall = bonusBall,
            )
        }

        exception shouldHaveMessage LottoErrorCode.MUST_NOT_BE_INCLUDE_WINNING_NUMBER.message("$bonusBall $numbers")
    }
})
