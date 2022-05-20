package lotto

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import stringaddcalculator.lotto.LottoBundle

class LottoBundleSpecs : DescribeSpec({

    describe("로또 뭉치는") {
        it("주어진 로또의 개수가 0개라면 예외를 발생시킨다") {
            shouldThrowExactly<IllegalArgumentException> {
                LottoBundle(emptyList())
            }
        }
    }
})
