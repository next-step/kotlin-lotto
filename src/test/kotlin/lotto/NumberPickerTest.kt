package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.NumberPicker

class LottoNumberGeneratorTest : FunSpec({
    test("로또 구매할때 번호를 6개 뽑는다.") {
        // given
        // 1 ~ 45 중에 6개를 출력한다.
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
    }
})
