package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoFactoryTest : FunSpec({
    test("로또 생성기는 6개의 숫자를 골라 로또 한 장을 생성한다.") {
        val lottoList = LottoFactory.generateLottoList(LottoCount(1)).first()
        lottoList.value.size shouldBe 6
    }


    test("로또 생성기는 숫자 N을 입력받아 N개의 로또를 생성한다.") {
        val lottoList = LottoFactory.generateLottoList(LottoCount(10))
        lottoList.size shouldBe 10
    }

    test("로또 생성기는 숫자 6 * N개를 입력받아 N개의 로또를 생성한다.") {
        val numbers = listOf(
            setOf(1, 2, 3, 4, 5, 6),
            setOf(2, 3, 4, 5, 6, 7),
            setOf(3, 4, 5, 6, 7, 8)
        )
        val lottoList = LottoFactory.generateLottoList(numbers)
        lottoList.size shouldBe 3
    }

    test("로또 생성기는 하나의 로또에 대해 숫자 6개를 입력받지 않을 경우 예외가 발생한다") {
        val numbers = listOf(
            setOf(1),
            setOf(1, 2),
            setOf(1, 2, 3),
            setOf(1, 2, 3, 4),
            setOf(1, 2, 3, 4, 5),
            setOf(1, 2, 3, 4, 5, 6, 7)
        )
        shouldThrow<IllegalArgumentException> { LottoFactory.generateLottoList(numbers) }
    }

    test("로또 생성기는 하나의 로또에 대해 1~45가 아닌 숫자를 입력 받을 경우 예외가 발생한다") {
        val numbers = listOf(
            setOf(-1),
            setOf(1, 2, 3, 4, 5, -6),
            setOf(1, 2, 3, 4, 5, 46),
        )
        shouldThrow<IllegalArgumentException> { LottoFactory.generateLottoList(numbers) }
    }

    test("로또 생성기는 하나의 로또에 대해 중복된 숫자를 입력 받을 경우 예외가 발생한다") {
        val numbers = listOf(
            setOf(1, 2, 3, 4, 5, 5),
            setOf(1, 2, 3, 4, 45, 45),
        )
        shouldThrow<IllegalArgumentException> { LottoFactory.generateLottoList(numbers) }
    }
})
