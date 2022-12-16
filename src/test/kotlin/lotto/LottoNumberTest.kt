package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldBeSortedWith
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.types.shouldBeInstanceOf

class LottoNumberTest : FunSpec({
    context("로또 번호 생성") {
        test("번호는 6개의 숫자로 이루어진다.") {
            val sut = LottoNumber.generate()
            sut.numbers.shouldBeInstanceOf<List<Int>>()
            sut.numbers shouldHaveSize 6
        }

        test("각 숫자는 1 ~ 45 사이의 숫자로 생성된다.") {
            repeat(100) {
                val sut = LottoNumber.generate()
                sut.numbers.forEach { value ->
                    value shouldBeInRange (1..45)
                }
            }
        }

        test("번호는 오름차순으로 정렬되어 있다.") {
            val sut = LottoNumber.generate()
            sut.numbers shouldBeSortedWith { a, b -> a - b }
        }

        test("번호는 중복된 숫자를 가질 수 없다.") {
            repeat(100) {
                val sut = LottoNumber.generate()
                sut.numbers.toSet() shouldHaveSize 6
            }
        }
    }
})
