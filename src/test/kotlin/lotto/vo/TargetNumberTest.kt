package lotto.vo

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import lotto.domain.vo.TargetNumber

class TargetNumberTest : FreeSpec({
    "추첨 번호를 생성할 수 있다" {
        val targetNumber = TargetNumber(value = 1)
        targetNumber.shouldNotBeNull()
    }

    "추첨 번호는 정해진 범위의 값이 아닌 경우 오류가 발생한다" {
        shouldThrow<IllegalArgumentException> { TargetNumber(value = 46) }
    }
})
