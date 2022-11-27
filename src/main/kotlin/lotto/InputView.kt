package lotto

class InputView {
    fun inputPrice(): Int {
        println("구입금액을 입력해 주세요.")
        val inputPrice = readln()
        val lottoPrice = 1000
        val price = inputPrice.toInt() / lottoPrice
        println("${price}개를 구매했습니다.")
        return price
    }

    fun inputLastWeekWinningNumbers(): WinningLottoNumbers {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        val inputLastWeekWinningNumbers = readln()
        val parse = Parser().parse(inputLastWeekWinningNumbers).toMutableList()
        return WinningLottoNumbers(parse)
    }
}