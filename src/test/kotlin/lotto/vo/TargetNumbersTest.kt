package lotto.vo

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import lotto.domain.vo.TargetNumber
import lotto.domain.vo.TargetNumbers

class TargetNumbersTest : FreeSpec({
    "추첨 번호 목록을 생성할 수 있다." {
        val list = setOf(TargetNumber(1), TargetNumber(2), TargetNumber(3), TargetNumber(4), TargetNumber(5), TargetNumber(6))
        val targetNumbers = TargetNumbers(targetNumbers = list)
        targetNumbers.shouldNotBeNull()
    }

    "추첨 번호 목록의 크기는 사전에 정의한 사이즈가 아니면 생성시 에러가 난다." {
        val listOfSizeOne = setOf(TargetNumber(1))
        shouldThrow<IllegalArgumentException> { TargetNumbers(targetNumbers = listOfSizeOne) }
    }
})
