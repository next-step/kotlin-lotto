package stringcalculator

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe

/**
 * @see InputNumbers
 */
class InputNumbersTest : ExpectSpec({

    context("객체 생성") {
        val input = listOf("15", "57")

        expect("문자로 된 숫자 리스트를 입력하면 각각 InputNumber 객체로 만들고 해당 리스트를 가진다.") {
            val inputNumbers = InputNumbers.from(input)

            inputNumbers.values.map { inputNumber ->
                inputNumber.value
            } shouldBe listOf(15, 57)
        }
    }

    context("fun addAll()") {
        val input = listOf("15", "57")
        val inputNumbers = InputNumbers.from(input)
        expect("모든 값을 더해서 반환한다") {
            inputNumbers.addAll() shouldBe 72
        }
    }
})
