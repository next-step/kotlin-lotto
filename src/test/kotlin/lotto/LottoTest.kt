package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoCreateMachine
import lotto.domain.model.vo.BuyPrice
import lotto.domain.model.vo.WinningLottoNumberList


class LottoTest : FunSpec({
    test("구입금액에 유효하지 않은 문자열인 \"\" 입력시 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            BuyPrice.valueOf("")
        }
    }

    test("구입금액에 유효하지 않은 문자열인 \"만원\" 입력시 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            BuyPrice.valueOf("만원")
        }
    }

    test("구입금액에 \"0\" 입력시 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            BuyPrice.valueOf("0")
        }
    }

    test("구입금액에 \"900\" 입력시 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            BuyPrice.valueOf("900")
        }
    }

    test("구입금액에 \"1500\" 입력시 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            BuyPrice.valueOf("1500")
        }
    }

    test("구입금액에 \"10001\" 입력시 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            BuyPrice.valueOf("10001")
        }
    }

    test("구입금액에 \"1000\" 입력시 로또를 1개를 가지고 있어야 한다.") {
        val lottoList = LottoCreateMachine.buyLottoList(BuyPrice.valueOf("1000"))
        lottoList.size shouldBe 1
    }

    test("구입금액에 \"10000\" 입력시 로또를 10개를 가지고 있어야 한다.") {
        val lottoList = LottoCreateMachine.buyLottoList(BuyPrice.valueOf("10000"))
        lottoList.size shouldBe 10
    }

    test("지난 주 당첨 번호에 \"1, 2, 3, 4, 5\" 입력시 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            WinningLottoNumberList.valueOf("1, 2, 3, 4, 5")
        }
    }

    test("지난 주 당첨 번호에 \"1, 2, 3, 4, 5, 5\" 입력시 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            WinningLottoNumberList.valueOf("1, 2, 3, 4, 5, 5")
        }
    }

    test("지난 주 당첨 번호에 \"1, 2, 3, 4, 5, 6, 7\" 입력시 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            WinningLottoNumberList.valueOf("1, 2, 3, 4, 5, 6, 7")
        }
    }

    test("지난 주 당첨 번호에 \"0, 1, 2, 3, 4, 5\" 입력시 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            WinningLottoNumberList.valueOf("0, 1, 2, 3, 4, 5")
        }
    }

    test("지난 주 당첨 번호에 \"41, 42, 43, 44, 45, 46\" 입력시 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            WinningLottoNumberList.valueOf("41, 42, 43, 44, 45, 46")
        }
    }

    test("지난 주 당첨 번호에 \"1, 2, 3, 4, 5, 6\" 입력시 지난 주 당첨 번호에 1, 2, 3, 4, 5, 6이 저장 되어야 한다.") {
        val winningLottoNumberList = WinningLottoNumberList.valueOf("1, 2, 3, 4, 5, 6")
        winningLottoNumberList.winningNumberList[0].number shouldBe 1
        winningLottoNumberList.winningNumberList[1].number shouldBe 2
        winningLottoNumberList.winningNumberList[2].number shouldBe 3
        winningLottoNumberList.winningNumberList[3].number shouldBe 4
        winningLottoNumberList.winningNumberList[4].number shouldBe 5
        winningLottoNumberList.winningNumberList[5].number shouldBe 6
    }
})
