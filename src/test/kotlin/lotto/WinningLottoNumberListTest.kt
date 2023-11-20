package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.model.vo.LottoNumber
import lotto.domain.model.vo.WinningLottoNumbers

/**
 * 지난 주 당첨 로또 번호 테스트
 * */
class WinningLottoNumberListTest : FunSpec({

    test("로또 당첨 번호 리스트 생성시 []을, 보너스 번호에 ``을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            WinningLottoNumbers.of("", "")
        }
    }

    test("로또 당첨 번호 리스트 생성시 [1, 2, 3, 4, 5]을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            WinningLottoNumbers.of("1, 2, 3, 4, 5")
        }
    }

    test("로또 당첨 번호 리스트 생성시 [1, 2, 3, 4, 5, 5]을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            WinningLottoNumbers.of("1, 2, 3, 4, 5, 5")
        }
    }

    test("로또 당첨 번호 리스트 생성시 [1, 2, 3, 4, 5, 6, 7]을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            WinningLottoNumbers.of("1, 2, 3, 4, 5, 6, 7")
        }
    }

    test("로또 당첨 번호 리스트 생성시 [0, 1, 2, 3, 4, 5]을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            WinningLottoNumbers.of("0, 1, 2, 3, 4, 5")
        }
    }

    test("로또 당첨 번호 리스트 생성시 [41, 42, 43, 44, 45, 46]을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            WinningLottoNumbers.of("41, 42, 43, 44, 45, 46")
        }
    }

    test("로또 당첨 번호 리스트 생성시 [1, 2, 3, 4, 5, 6]을 넣을 경우 지난 주 당첨 로또 번호 리스트에 [1, 2, 3, 4, 5, 6]이 저장 되어야 한다.") {
        val winningLottoNumbers = WinningLottoNumbers.of("1, 2, 3, 4, 5, 6")
        winningLottoNumbers.winningNumbers.contains(LottoNumber.valueOf(1)) shouldBe true
        winningLottoNumbers.winningNumbers.contains(LottoNumber.valueOf(2)) shouldBe true
        winningLottoNumbers.winningNumbers.contains(LottoNumber.valueOf(3)) shouldBe true
        winningLottoNumbers.winningNumbers.contains(LottoNumber.valueOf(4)) shouldBe true
        winningLottoNumbers.winningNumbers.contains(LottoNumber.valueOf(5)) shouldBe true
        winningLottoNumbers.winningNumbers.contains(LottoNumber.valueOf(6)) shouldBe true
    }
})
