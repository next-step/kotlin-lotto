package lotto.step2

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.step2.domain.NumberPicker

class NumberPickerTest : FunSpec({
    test("번호를 6개 뽑는다.") {
        // given
        val givenPickedNumbers = listOf(1, 2, 3, 4, 5, 6)

        val numberPicker =
            object : NumberPicker {
                override fun pick(): List<Int> {
                    return givenPickedNumbers
                }
            }
        // when
        val result = numberPicker.pick()

        // then
        result shouldBe givenPickedNumbers
        result.size shouldBe 6
    }
})
