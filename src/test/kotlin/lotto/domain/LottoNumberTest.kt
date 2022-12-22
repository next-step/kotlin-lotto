package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import java.lang.IllegalArgumentException

class LottoNumberTest : DescribeSpec({
    it("로또 넘버는 1부터 45까지의 숫자 중 하나만 선택하여 생성할 수 있다.") {
        val number = 45

        LottoNumber(number)
    }

    it("로또 넘버가 주어진 범위를 넘어설 경우 IllegalArgumentException을 throw한다.") {
        val number = 46

        shouldThrow<IllegalArgumentException> {
            LottoNumber(number)
        }
    }
})
