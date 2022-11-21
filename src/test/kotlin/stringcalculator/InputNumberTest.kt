package stringcalculator

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.ExpectSpec

/**
 * @see InputNumber
 */
class InputNumberTest : ExpectSpec({

    context("객체 생성") {
        expect("양의 정수 문자열을 입력하면 정상적으로 객체 생성된다.") {
            val input = "13"

            shouldNotThrowAny { InputNumber(input) }
        }

        expect("음의 정수 문자열을 입력하면 에러를 반환한다.") {
            val input = "-13"

            shouldThrowExactly<RuntimeException> { InputNumber(input) }
        }
    }
})
