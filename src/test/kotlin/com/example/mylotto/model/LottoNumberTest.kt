package com.example.mylotto.model

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec

class LottoNumberTest :
    FunSpec({
        test("success") {
            (1..45).forEach {
                shouldNotThrowAny { LottoNumber(it) }
            }
        }

        test("should throw an exception for numbers outside 1 to 45 range") {
            listOf(-1, 0, 46, 100).forEach {
                shouldThrow<IllegalArgumentException> { LottoNumber(it) }
            }
        }
    })
