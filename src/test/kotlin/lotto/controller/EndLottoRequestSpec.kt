package lotto.controller

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class EndLottoRequestSpec : FunSpec({
    test("우승자 번호 입력으로 로또 종료 요청이 생성된다") {
        val input = "1, 2, 3"

        val result = EndLottoRequest.from(input)

        result.winningNumbers shouldBe listOf(1, 2, 3)
    }

    test("', '를 구분자로 구분했을 때 숫자가 아닌 입력값이라면 요청 생성에 실패한다") {
        val input = "1,2, 3"

        shouldThrow<IllegalArgumentException> {
            EndLottoRequest.from(input)
        }
    }
})
