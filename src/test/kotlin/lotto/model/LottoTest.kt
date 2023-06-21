package lotto.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class LottoTest : StringSpec({

    "로또 번호는 6개 이다" {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }.toSet())
        lotto.numbers.size shouldBe 6
    }

    "로또 번호는 6개 아니면 예외가 발생한다" {
        shouldThrow<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5).map { LottoNumber(it) }.toSet()).numbers.size
        }
        shouldThrow<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7, 8).map { LottoNumber(it) }.toSet()).numbers.size
        }
    }

    "로또 번호는 1,2,3,4,5,6과 7,8,9,10,11,12 은 하나도 안맞았다" {
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }.toSet())
        val lotto2 = Lotto(listOf(7, 8, 9, 10, 11, 12).map { LottoNumber(it) }.toSet())
        val count = lotto1.matchingCount(lotto2)
        count shouldBe 0
    }

    "로또 번호는 1,2,3,4,5,6과 1,8,9,10,11,12 은 하나 맞았다" {
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }.toSet())
        val lotto2 = Lotto(listOf(1, 8, 9, 10, 11, 12).map { LottoNumber(it) }.toSet())
        val count = lotto1.matchingCount(lotto2)
        count shouldBe 1
    }

    "로또 번호는 1,2,3,4,5,6과 1,2,9,10,11,12 은 두개 맞았다" {
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }.toSet())
        val lotto2 = Lotto(listOf(1, 2, 9, 10, 11, 12).map { LottoNumber(it) }.toSet())
        val count = lotto1.matchingCount(lotto2)
        count shouldBe 2
    }

    "로또 번호는 1,2,3,4,5,6과 1,2,3,4,5,6 은 다 맞았다" {
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }.toSet())
        val lotto2 = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }.toSet())
        val count = lotto1.matchingCount(lotto2)
        count shouldBe 6
    }

    "로또 번호는 1,2,3,4,5,6은 보너스 1 포함한다" {
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }.toSet())
        val bonus = LottoNumber(1)
        val isBonus = lotto1.isBonus(bonus)
        isBonus.shouldBeTrue()
    }

    "로또 번호는 1,2,3,4,5,6은 보너스 7을 포함하지 않는다" {
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }.toSet())
        val bonus = LottoNumber(7)
        val isBonus = lotto1.isBonus(bonus)
        isBonus.shouldBeFalse()
    }
})
