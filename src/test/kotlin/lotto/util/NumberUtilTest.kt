package lotto.util

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto.common.DoubleNumber

class NumberUtilTest : StringSpec({

    "소숫점 지정 자리수 이하 버림 테스트" {
        forAll(
            // given
            row(DoubleNumber(1.2345), DoubleNumber(0.0), DoubleNumber(1.0)),
            row(DoubleNumber(1.2345), DoubleNumber(3.0), DoubleNumber(1.234)),
            row(DoubleNumber(1.2345), DoubleNumber(-1.0), DoubleNumber(1.2345))
        ) { number, decimalPlace, expectedResult ->
            // when
            val actualResult = NumberUtil.floor(number, decimalPlace)
            // then
            actualResult shouldBe expectedResult
        }
    }
})
