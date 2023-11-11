package lotto.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoTest : StringSpec({

    "로또 번호가 6개가 아니면 예외가 발생한다." {
        listOf(0, 1, 2, 3, 4, 5).forEach { count ->
            // given
            val numbers = List(count) { 1 }

            // expected
            shouldThrowWithMessage<IllegalArgumentException>("로또 번호는 6개여야 합니다.") {
                Lotto.from(numbers)
            }
        }
    }

    "로또 번호가 중복이면 예외가 발생한다." {
        // given
        val numbers = listOf(1, 1, 2, 3, 4, 5)

        // expected
        shouldThrowWithMessage<IllegalArgumentException>("로또 번호는 중복되지 않아야 합니다.") {
            Lotto.from(numbers)
        }
    }

    "두 로또 번호 사이의 중복된 개수를 구한다." {
        // given
        val lotto = Lotto.from(listOf(1, 2, 3, 4, 5, 6))
        val otherLotto = Lotto.from(listOf(2, 5, 6, 7, 8, 10))
        val bonusBall = LottoNumber.from(11)

        // when
        val count = lotto.calculateMatchCount(otherLotto, bonusBall)

        // then
        count shouldBe 3
    }

    "두 로또 번호 사이의 중복된 개수를 구할 때 보너스 볼이 존재하지만, 중복된 개수가 5라면 1을 추가하지 않는다." {
        listOf(1, 2, 3, 4, 5, 6).forEach { number ->
            // given
            val lotto = Lotto.from(listOf(1, 2, 3, 4, 5, 6))
            val otherLotto = Lotto.from(listOf(2, 3, 4, 5, 6, 10))
            val bonusBall = LottoNumber.from(number)

            // when
            val count = lotto.calculateMatchCount(otherLotto, bonusBall)

            // then
            count shouldBe 5
        }
    }

    "두 로또 번호 사이의 중복된 개수를 구할 때 보너스 볼이 존재하면서, 중복된 개수가 5가 아니라면 1 추가한 값을 반환한다." {
        forAll(
            row(listOf(1, 2, 3, 4, 7, 8), 5),
            row(listOf(1, 2, 3, 7, 8, 9), 4),
            row(listOf(1, 2, 7, 8, 9, 10), 3),
            row(listOf(1, 7, 8, 9, 10, 11), 2),
            row(listOf(7, 8, 9, 10, 11, 12), 1),
        ) { other, expected ->

            // given
            val lotto = Lotto.from(listOf(1, 2, 3, 4, 5, 6))
            val otherLotto = Lotto.from(other)
            val bonusBall = LottoNumber.from(5)

            // when
            val actual = lotto.calculateMatchCount(otherLotto, bonusBall)

            // then
            actual shouldBe expected
        }
    }

    "보너스 볼을 가지고 있으면 true, 아니면 false를 반환한다." {
        forAll(
            row(3, true),
            row(7, false),
        ) { number, expected ->
            // given
            val lotto = Lotto.from(listOf(1, 2, 3, 4, 5, 6))
            val bonusBall = LottoNumber.from(number)
            // when
            val actual = lotto.hasBonusBall(bonusBall)

            // then
            actual shouldBe expected
        }
    }
},)
