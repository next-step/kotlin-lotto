package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.ints.shouldBeLessThan
import io.kotest.matchers.shouldBe
import lotto.error.InvalidLottoNumberException

class LottoNumberGeneratorSpec : FunSpec({
    context("로또 번호 생성") {
        val number = LottoNumberGenerator.createFrom()

        test("생성된 숫자는 1이상 45이하") {
            number.value.forEach {
                1..45 shouldContain it
            }
        }

        test("생성된 숫자는 6개의 숫자") {
            number.value.size shouldBe 6
        }

        test("생성된 숫자는 서로 다른 숫자") {
            number.value.size shouldBe number.value.toSet().size
        }

        test("생성된 숫자는 오름차순으로 구성") {
            number.value.zipWithNext { before, next -> before shouldBeLessThan next }
        }
    }
})
