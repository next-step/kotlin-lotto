package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class LottoNumberTest : AnnotationSpec() {

    fun `로또 번호는 1보다 작거나 45보다 클 수 없음`() {
        LottoNumber(7).number shouldBe 7
        val winNumber = Lottery(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber((it)) })
        shouldThrow<IllegalArgumentException> {
            LottoNumber(0)
        }
        shouldThrow<IllegalArgumentException> {
            LottoNumber(46)
        }
    }
}
