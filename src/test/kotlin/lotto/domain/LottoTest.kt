package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

internal class LottoTest : FreeSpec({

    "숫자 리스트를 받아 Lotto 인스턴스를 생성한다" {
        val lotto = Lotto.autoOf(1, 2, 3, 4, 5, 6)

        lotto.numbers.map { it.value } shouldBe listOf(1, 2, 3, 4, 5, 6)
    }

    "자동발급 로또인 경우 isAuto 의 값은 true 이다" {
        val lotto = Lotto.autoOf(1, 2, 3, 4, 5, 6)

        lotto.isAuto.shouldBeTrue()
    }

    "수동발급 로또인 경우 isAuto 의 값은 false 이다" {
        val lotto = Lotto.manualOf(1, 2, 3, 4, 5, 6)

        lotto.isAuto.shouldBeFalse()
    }

    "에러 상황" - {
        listOf(
            listOf(),
            listOf(1),
            listOf(1, 2, 3, 4, 5, 6, 7),
        ).forEach {
            "입력 리스트가 크기가 ${it.size} 일 경우" {
                shouldThrow<IllegalArgumentException> {
                    Lotto.autoOf(it)
                }
            }
        }

        "중복된 값이 존재하는 경우" {
            shouldThrow<IllegalArgumentException> {
                Lotto.autoOf(1, 2, 3, 4, 6, 6)
            }
        }
    }
})
