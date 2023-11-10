package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import lotto.lotto.Lotto
import lotto.lotto.LottoNumbers

class LottoTest : FunSpec({
    val lotto = Lotto()
    test("자동으로 생성된 번호는 6개이다") {
        val expected = 6

        lotto.numberList.count() shouldBe expected
    }

    test("생성된 번호는 겹치지 않는다") {
        val lottoSet = lotto.numberList.toSet()

        lotto.numberList.count() shouldBe lottoSet.count()
    }

    test("로또 생성시에 번호를 전달하면, 전달된 대로 생성한다") {
        val lottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6))
        val winningLotto = Lotto(lottoNumbers)
        val expected = listOf(1, 2, 3, 4, 5, 6)
        winningLotto.numberList shouldBe expected
    }

    test("로또 생성시에 중복 된 값을 넘겨주면 error를 맞는다") {
        shouldThrow<IllegalArgumentException> {
            LottoNumbers(listOf(1, 2, 3, 3, 4, 5))
        }
    }

    test("로또 생성시에 값을 6개가 아니게 넘겨주면 error를 맞는다") {
        shouldThrow<IllegalArgumentException> {
            LottoNumbers(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    context("전달된 숫자가 1~45 범위 내에 없습니다.") {
        withData(
            listOf(
                listOf(1, 2, 3, 4, 5, 46),
                listOf(0, 1, 2, 3, 4, 5),
            )
        ) { lottoList ->
            shouldThrow<IllegalArgumentException> {
                LottoNumbers(lottoList)
            }
        }
    }

    test("보너스 번호를 포함 하고 있지 않는 것을 확인") {
        val expected = 45
        val lottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6))
        val bonusContainedLotto = Lotto(numberList = lottoNumbers)
        bonusContainedLotto.isMatchedBonusBall(expected) shouldBe false
    }

    test("보너스 번호를 포함 하고 있는 것을 확인") {
        val expected = 45
        val lottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 45))
        val bonusContainedLotto = Lotto(numberList = lottoNumbers)
        bonusContainedLotto.isMatchedBonusBall(expected) shouldBe true
    }
})
