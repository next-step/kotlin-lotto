package lotto.step4

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.step4.domain.LottoNumber
import lotto.step4.domain.NumberPicker

class NumberPickerTest : FunSpec({
    test("번호를 6개 뽑는다.") {
        // given
        val givenNumbers =
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6),
            )

        val numberPicker =
            object : NumberPicker {
                override fun pick(): List<LottoNumber> {
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
