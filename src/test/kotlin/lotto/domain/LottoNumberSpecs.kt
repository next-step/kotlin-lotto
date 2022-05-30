package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll

class LottoNumberSpecs : DescribeSpec({
    describe("로또 번호는") {
        context("1 ~ 45 범위를 벗어난 숫자가 주어지면") {
            val numbers = listOf(0, 46)
            it("예외를 발생시킨다") {
                numbers.forAll {
                    shouldThrowExactly<IllegalArgumentException> {
                        LottoNumber.of(it)
                    }
                }
            }
        }
    }
})
