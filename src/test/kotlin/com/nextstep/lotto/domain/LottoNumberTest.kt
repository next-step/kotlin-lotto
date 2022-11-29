package com.nextstep.lotto.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class LottoNumberTest : FunSpec({
    context("LottoNumber") {
        test("LottoNumber는 1부터 45 사이의 숫자로 초기화 된다.") {
            (1..45).toList().forAll { input ->
                shouldNotThrow<RuntimeException> { LottoNumber.from(input) }
            }
        }

        test("LottoNumber는 1부터 45 사이 이외의 숫자로는 초기화할 수 없다.") {
            (46..100).toList().forAll { input ->
                val exception = shouldThrow<RuntimeException> { LottoNumber.from(input) }
                exception.message shouldBe "로또 번호는 1 ~ 45 사이여야 합니다."
            }
        }
    }
})
