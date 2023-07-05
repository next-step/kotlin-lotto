package lottery.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class LotteryNumberTest : StringSpec({
    "로또 숫자의 크기는 1이상 이여야한다." {
        shouldThrow<IllegalArgumentException> {
            LotteryNumber.get(0)
        }
    }

    "로또 숫자의 크기는 45이하여야 한다." {
        shouldThrow<IllegalArgumentException> {
            LotteryNumber.get(46)
        }
    }
})
