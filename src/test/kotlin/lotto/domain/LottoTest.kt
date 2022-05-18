package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.exception.DuplicateLottoNumberException
import lotto.exception.InvalidLottoNumberException

class LottoTest : FunSpec({

    test("Lotto 숫자는 6개로 구성된다.") {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        lotto.numbers.size shouldBe 6

        shouldThrow<InvalidLottoNumberException> {
            Lotto(listOf())
            Lotto(listOf(1))
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    test("로또 숫자는 중복이 없어야 한다.") {
        shouldThrow<DuplicateLottoNumberException> {
            Lotto(listOf(1, 1, 1, 4, 5, 6))
        }
    }
})
