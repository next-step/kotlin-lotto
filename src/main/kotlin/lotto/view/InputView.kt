package lotto.view

object InputView {

    fun inputLottoPrice(): Long {
        val lottoPrice = readln()

        return lottoPrice.toLongOrNull()
            ?: run {
                println("로또 가격은 숫자만 가능합니다.")
                inputLottoPrice()
            }
    }
}
