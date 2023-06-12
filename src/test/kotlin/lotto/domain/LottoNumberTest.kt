package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeSameInstanceAs

class LottoNumberTest : FunSpec({
    test("유효한 로또 번호를 전달하면 로또 번호 객체를 반환한다.") {
        (LottoNumber.MIN_VALUE..LottoNumber.MAX_VALUE).forEach {
            val actual = LottoNumber.valueOf(it)

            actual.number shouldBe it
        }
    }

    test("유효하지 않은 로또 번호를 전달하면 예외를 던진다.") {
        listOf(-1, 0, 46, 47).forEach {
            shouldThrow<IllegalArgumentException> { LottoNumber.valueOf(it) }
        }
    }

    test("로또 번호를 캐싱되어 동등성과 동일성 모두 만족한다.") {
        (LottoNumber.MIN_VALUE..LottoNumber.MAX_VALUE).forEach {
            val firstActual = LottoNumber.valueOf(it)
            val secondActual = LottoNumber.valueOf(it)

            firstActual shouldBe secondActual
            firstActual shouldBeSameInstanceAs secondActual
        }
    }
})
