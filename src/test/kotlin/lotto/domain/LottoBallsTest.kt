package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoBallsTest : StringSpec({
    "로또 볼들에 로또 볼이 몇 개 있는지 체크할 수 있다." {
        forAll(
            row(listOf(1, 2, 3, 4, 5, 6), 6),
            row(listOf(1, 2, 3, 4, 5), 5),
            row(listOf(1, 2, 3, 4), 4),
            row(listOf(1, 2, 3), 3),
            row(listOf(1, 2), 2),
            row(listOf(1), 1),
            row(listOf(), 0),
        ) { numbers, expected ->
            val lottoBalls = LottoBalls(numbers.map { LottoBall(it) }.toList())
            lottoBalls.checkBallSize(expected)
        }
    }

    "로또 볼들에 중복된 로또 볼이 있는지 체크할 수 있다." {
        forAll(
            row(listOf(1, 1, 3, 4, 5, 6)),
            row(listOf(1, 2, 3, 4, 4, 6)),
            row(listOf(1, 2, 5, 5, 5, 6)),
        ) { numbers ->
            val lottoBalls = LottoBalls(numbers.map { LottoBall(it) }.toList())
            val exception =
                shouldThrowExactly<IllegalArgumentException> {
                    lottoBalls.checkIsUniqueBalls()
                }
            exception.message shouldBe "로또 번호는 중복되지 않아야 합니다."
        }
    }

    "다른 로또 볼들과 비교해 같은 번호를 몇 개 가지고 있는지 반환할 수 있다." {
        forAll(
            row(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 4, 5, 6), 6),
            row(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 4, 5, 7), 5),
            row(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 4, 7, 8), 4),
            row(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 7, 8, 9), 3),
            row(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 7, 8, 9, 10), 2),
            row(listOf(1, 2, 3, 4, 5, 6), listOf(1, 7, 8, 9, 10, 11), 1),
            row(listOf(1, 2, 3, 4, 5, 6), listOf(7, 8, 9, 10, 11, 12), 0),
        ) { numbers1, numbers2, expected ->
            val lottoBalls1 = LottoBalls(numbers1.map { LottoBall(it) }.toList())
            val lottoBalls2 = LottoBalls(numbers2.map { LottoBall(it) }.toList())
            lottoBalls1.extractMatchCount(lottoBalls2) shouldBe expected
        }
    }
})
