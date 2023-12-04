package lotto

import lotto.domain.model.LottoNumber
import lotto.domain.model.LottoNumbers
import lotto.domain.model.WinningLottoNumbers
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe

/**
 * 지난 주 당첨 로또 번호 테스트
 * */
class WinningLottoNumberListTest : FunSpec({

    test("로또 당첨 번호 리스트 생성시 []을, 보너스 번호에 `1`을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            WinningLottoNumbers.of(LottoNumbers(setOf()), LottoNumber.valueOf(1))
        }
    }

    test("로또 당첨 번호 리스트 생성시 []을, 보너스 번호에 `13`을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            WinningLottoNumbers.of(LottoNumbers(setOf()), LottoNumber.valueOf(13))
        }
    }

    test("로또 당첨 번호 리스트 생성시 [1, 2, 3, 4, 5]을, 보너스 번호에 `13`을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            val lottoNumbers = LottoNumbers.valueOf(setOf(1, 2, 3, 4, 5))
            WinningLottoNumbers.of(LottoNumbers(lottoNumbers.toSet()), LottoNumber.valueOf(13))
        }
    }

    test("로또 당첨 번호 리스트 생성시 [1, 2, 3, 4, 5, 5]을, 보너스 번호에 `13`을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            val lottoNumbers = LottoNumbers.valueOf(setOf(1, 2, 3, 4, 5, 5))
            WinningLottoNumbers.of(LottoNumbers(lottoNumbers.toSet()), LottoNumber.valueOf(13))
        }
    }

    test("로또 당첨 번호 리스트 생성시 [1, 2, 3, 4, 5, 6, 7]을, 보너스 번호에 `13`을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            val lottoNumbers = LottoNumbers.valueOf(setOf(1, 2, 3, 4, 5, 6, 7))
            WinningLottoNumbers.of(LottoNumbers(lottoNumbers.toSet()), LottoNumber.valueOf(13))
        }
    }

    test("로또 당첨 번호 리스트 생성시 [0, 1, 2, 3, 4, 5]을, 보너스 번호에 `13`을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            val lottoNumbers = LottoNumbers.valueOf(setOf(0, 1, 2, 3, 4, 5))
            WinningLottoNumbers.of(LottoNumbers(lottoNumbers.toSet()), LottoNumber.valueOf(13))
        }
    }

    test("로또 당첨 번호 리스트 생성시 [41, 42, 43, 44, 45, 46]을, 보너스 번호에 `13`을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            val lottoNumbers = LottoNumbers.valueOf(setOf(41, 42, 43, 44, 45, 46))
            WinningLottoNumbers.of(LottoNumbers(lottoNumbers.toSet()), LottoNumber.valueOf(13))
        }
    }

    test("로또 당첨 번호 리스트 생성시 [41, 42, 43, 44, 45]을, 보너스 번호에 `46`을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            val lottoNumbers = LottoNumbers.valueOf(setOf(41, 42, 43, 44, 45))
            WinningLottoNumbers.of(LottoNumbers(lottoNumbers.toSet()), LottoNumber.valueOf(46))
        }
    }

    test("로또 당첨 번호 리스트 생성시 [1, 2, 3, 4, 5, 6]을, 보너스 번호에 `13`을 넣을 경우 지난 주 당첨 로또 번호 리스트에 [1, 2, 3, 4, 5, 6]이, 보너스 번호에 `13`이 저장 되어야 한다.") {

        val winningLottoNumbers = WinningLottoNumbers.of(LottoNumbers.valueOf(setOf(1, 2, 3, 4, 5, 6)), LottoNumber.valueOf(13))

        winningLottoNumbers.winningLottoNumbers shouldContainExactly LottoNumbers.valueOf(setOf(1, 2, 3, 4, 5, 6))
        winningLottoNumbers.winningBonusNumber shouldBe LottoNumber.valueOf(13)
    }
})
