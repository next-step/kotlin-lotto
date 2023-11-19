package lotto

object InputView {

    fun inputMoney(): Amount {
        println("구입금액을 입력해 주세요.")
        return Amount(readln().toInt())
    }

    fun inputPastWinningNumbers(): List<LottoNumber> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln().split(",").map { LottoNumber.of(it.toInt()) }
    }
}
