package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.model.vo.WinningLottoNumberList

/**
 * 지난 주 당첨 로또 번호 테스트
 * */
class WinningLottoNumberListTest : FunSpec({

    test("로또 당첨 번호 리스트 생성시 []을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            WinningLottoNumberList.valueOf("1, 2, 3, 4, 5")
        }
    }

    test("로또 당첨 번호 리스트 생성시 [1, 2, 3, 4, 5]을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            WinningLottoNumberList.valueOf("1, 2, 3, 4, 5")
        }
    }

    test("로또 당첨 번호 리스트 생성시 [1, 2, 3, 4, 5, 5]을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            WinningLottoNumberList.valueOf("1, 2, 3, 4, 5, 5")
        }
    }

    test("로또 당첨 번호 리스트 생성시 [1, 2, 3, 4, 5, 6, 7]을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            WinningLottoNumberList.valueOf("1, 2, 3, 4, 5, 6, 7")
        }
    }

    test("로또 당첨 번호 리스트 생성시 [0, 1, 2, 3, 4, 5]을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            WinningLottoNumberList.valueOf("0, 1, 2, 3, 4, 5")
        }
    }

    test("로또 당첨 번호 리스트 생성시 [41, 42, 43, 44, 45, 46]을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            WinningLottoNumberList.valueOf("41, 42, 43, 44, 45, 46")
        }
    }

    test("로또 당첨 번호 리스트 생성시 [1, 2, 3, 4, 5, 6]을 넣을 경우 지난 주 당첨 로또 번호 리스트에 [1, 2, 3, 4, 5, 6]이 저장 되어야 한다.") {
        val winningLottoNumberList = WinningLottoNumberList.valueOf("1, 2, 3, 4, 5, 6")
        winningLottoNumberList.winningNumberList[0].number shouldBe 1
        winningLottoNumberList.winningNumberList[1].number shouldBe 2
        winningLottoNumberList.winningNumberList[2].number shouldBe 3
        winningLottoNumberList.winningNumberList[3].number shouldBe 4
        winningLottoNumberList.winningNumberList[4].number shouldBe 5
        winningLottoNumberList.winningNumberList[5].number shouldBe 6
    }
})
