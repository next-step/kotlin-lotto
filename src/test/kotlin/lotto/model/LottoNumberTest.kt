package lotto.model

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class LottoNumberTest : StringSpec({

    "LottoNumber 는 1~46 사이의 수 이어야한다" {
        shouldNotThrow<IllegalArgumentException> {
            (1..46).forEach { LottoNumber(it) }
        }
    }

    "LottoNumber 는 1~46 범위에 벗어나는 경우 IllegalArgumentException throw" {
        shouldThrow<IllegalArgumentException> {
            LottoNumber(-1)
        }
        shouldThrow<IllegalArgumentException> {
            LottoNumber(0)
        }
        shouldThrow<IllegalArgumentException> {
            LottoNumber(47)
        }
        shouldThrow<IllegalArgumentException> {
            LottoNumber(50)
        }
    }

//    "LottoNumberRandomStrategy 전략 주입시, 랜덤한 LottoNumber 가 생성 되어야 한다" {
//        shouldNotThrow<IllegalArgumentException> {
//            (1..100).forEach { _ ->
//                val actual = LottoNumber(LottoNumbersRandomStrategy)
//                actual.value shouldBeIn (1..46).toSet()
//            }
//        }
//    }
//
//    "LottoNumberRandomWithExceptStrategy 전략 주입시, 특정 숫자를 제외한 나머지 숫자들 중에서 랜덤 하게 LottoNumber 가 생성 되어야 한다" {
//        shouldNotThrow<IllegalArgumentException> {
//            (1..100).forEach { _ ->
//                val actual = LottoNumber(
//                    LottoNumbersRandomWithExceptStrategy(setOf(11, 12, 22, 23, 33, 34, 44, 45))
//                )
//                actual.value shouldBeIn (1..46).toSet()
//                actual.value shouldNotBeIn setOf(11, 12, 22, 23, 33, 34, 44, 45)
//            }
//        }
//    }
})
