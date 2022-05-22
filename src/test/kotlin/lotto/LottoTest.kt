package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

internal class LottoTest : FreeSpec({

    "숫자 리스트를 받아 Lotto 인스턴스를 생성한다" {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        lotto.numbers shouldBe listOf(1, 2, 3, 4, 5, 6)
    }

    "에러 상황" - {
        listOf(
            listOf(),
            listOf(1),
            listOf(1, 2, 3, 4, 5, 6, 7),
        ).forEach {
            "입력 리스트가 크기가 ${it.size} 일 경우" {
                shouldThrow<IllegalArgumentException> {
                    Lotto(it)
                }
            }
        }

        "중복된 값이 존재하는 경우" {
            shouldThrow<IllegalArgumentException> {
                Lotto(listOf(1, 2, 3, 4, 6, 6))
            }
        }
    }
})
