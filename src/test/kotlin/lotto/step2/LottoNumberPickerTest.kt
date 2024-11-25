package lotto.step2

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.step2.domain.LottoNumberPicker

class LottoNumberPickerTest : FunSpec({
    test("로또 번호를 6개 뽑는다.") {
        // given
        val lottoNumberPicker = LottoNumberPicker()

        // when
        val result = lottoNumberPicker.pick()

        // then
        result.size shouldBe 6
    }

    test("로또 번호는 1부터 45까지의 숫자이다.") {
        // given
        val lottoNumberPicker = LottoNumberPicker()

        // when
        val result = lottoNumberPicker.pick()

        // then
        result.forEach {
            it shouldBe (1..45).toList().find { number -> number == it }
        }
    }
})
