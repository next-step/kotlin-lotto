package lotto.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoTest : StringSpec({

    "로또 번호가 6개가 아니면 예외가 발생한다." {
        listOf(0, 1, 2, 3, 4, 5).forEach { count ->
            // given
            val numbers = List(count) { it }

            // expected
            shouldThrowWithMessage<IllegalArgumentException>("로또 번호는 6개여야 합니다.") {
                Lotto(numbers)
            }
        }
    }

    "로또 번호가 중복이면 예외가 발생한다." {
        // given
        val numbers = listOf(1, 1, 2, 3, 4, 5)

        // expected
        shouldThrowWithMessage<IllegalArgumentException>("로또 번호는 중복되지 않아야 합니다.") {
            Lotto(numbers)
        }
    }

    "두 로또 번호 사이의 중복된 개수를 구한다." {
        // given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val otherLotto = Lotto(listOf(2, 5, 6, 7, 8, 10))

        // when
        val count = lotto.matchCount(otherLotto)

        // then
        count shouldBe 2
    }
})
