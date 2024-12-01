package lotto.step4

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.step4.domain.LottoNumberPicker

class LottoNumberPickerTest : FunSpec({
    test("로또 번호를 6개 뽑는다.") {
        // given
        val lottoNumberPicker = LottoNumberPicker()

        // when
        val result = lottoNumberPicker.pick()

        // then
        result.size shouldBe 6
    }
})
