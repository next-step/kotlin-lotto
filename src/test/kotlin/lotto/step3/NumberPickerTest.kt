package lotto.step3

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.step3.domain.NumberPicker

class NumberPickerTest : FunSpec({
    test("번호를 6개 뽑는다.") {
        // given
        val givenNumbers = listOf(1, 2, 3, 4, 5, 6)

        val numberPicker =
            object : NumberPicker {
                override fun pick(): List<Int> {
                    return givenNumbers
                }
            }
        // when
        val result = numberPicker.pick()

        // then
        result shouldBe givenNumbers
        result.size shouldBe 6
    }
})
