package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

internal class WinNumberTest : FreeSpec({

    "숫자 목록과 보너스 번호를 받아 인스턴스를 생성한다" {
        val winNumbers = WinNumbers.of(listOf(1, 2, 3, 4, 5, 6), 7)

        winNumbers.value.map { it.value } shouldBe listOf(1, 2, 3, 4, 5, 6)
        winNumbers.bonus shouldBe LottoNumber(7)
    }

    "숫자 목록에 중복된 값이 존재하면 에러가 발생한다" {
        shouldThrow<IllegalArgumentException> {
            WinNumbers.of(listOf(1, 2, 3, 4, 4, 6), 7)
        }
    }

    "숫자 목록과 보너스 숫자에 중복된 값이 존재하면 에러가 발생한다" {
        shouldThrow<IllegalArgumentException> {
            WinNumbers.of(listOf(1, 2, 3, 4, 5, 6), 3)
        }
    }

    "주어진 로또와 일치하는 숫자의 개수를 반환한다" - {
        val winNumbers = WinNumbers.of(listOf(1, 2, 3, 4, 5, 6), 7)

        listOf(
            Lotto.autoOf(1, 2, 3, 4, 5, 6) to 6,
            Lotto.autoOf(1, 2, 3, 4, 5, 7) to 5,
            Lotto.autoOf(1, 2, 3, 4, 7, 8) to 4,
            Lotto.autoOf(1, 2, 3, 7, 8, 9) to 3,
            Lotto.autoOf(5, 6, 7, 8, 9, 10) to 2,
            Lotto.autoOf(6, 7, 8, 9, 10, 11) to 1,
            Lotto.autoOf(45, 7, 8, 9, 10, 11) to 0,
        ).forEach { (lotto, count) ->
            "$count 개 일치하는 경우" {
                winNumbers.matchCount(lotto) shouldBe count
            }
        }
    }

    "보너스 일치 여부를 반환한다" {
        val winNumbers = WinNumbers.of(listOf(1, 2, 3, 4, 5, 6), 7)

        winNumbers.hasBonus(Lotto.autoOf(1, 2, 3, 4, 5, 6)) shouldBe false
        winNumbers.hasBonus(Lotto.autoOf(1, 2, 3, 4, 5, 7)) shouldBe true
    }
})
