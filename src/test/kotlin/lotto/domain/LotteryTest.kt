package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.inspectors.shouldForAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.doubles.shouldBeLessThan
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf

class LotteryTest : AnnotationSpec() {

    @Test
    fun `당첨결과의 경우 중복이 올 수 없고 정해진 범위내의 숫자만 가능`() {
        shouldThrow<IllegalArgumentException> {
            Lottery(listOf(1, 2, 2, 2, 3, 4).map { LottoNumber(it) })
        }
    }

    @Test
    fun `당첨 숫자는 6개 이어야함`() {
        shouldThrow<IllegalArgumentException> {
            Lottery(listOf(1, 2, 3, 4, 5).map { LottoNumber(it) })
        }
    }
}
