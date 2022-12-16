package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.types.shouldBeInstanceOf

class LottoNumberTest : FunSpec({
    context("로또 번호 생성") {
        test("번호는 6개의 숫자로 이루어진다.") {
            val sut = LottoNumber.generate()
            sut.values.shouldBeInstanceOf<List<Int>>()
            sut.values shouldHaveSize 6
        }
    }
})
