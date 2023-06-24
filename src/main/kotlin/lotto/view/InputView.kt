package lotto.view

import lotto.domain.LottoNumber

object InputView {
    fun getPurchaseAmount(): Int {
        println("구입 금액을 입력해 주세요.")
        val result = readln().toInt()
        require(result > 0) { "구입 금액은 0보다 커야합니다." }
        return result
    }

    fun getNumberOfManualLotto(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val result = readln().toInt()
        require(result > 0) { "로또 수는 0보다 커야합니다." }
        return result
    }

    fun getManualLottos(count: Int): List<List<LottoNumber>> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return List(count) { getManualLotto() }
    }

    private fun getManualLotto(): List<LottoNumber> {
        val input = readln()
        return parseLottoNumbers(input)
    }

    private fun parseLottoNumbers(input: String) = input.split(",").map { LottoNumber.of(it) }

    fun getWinningNumbers(): List<LottoNumber> {
        println("지난주 당첨 번호를 입력해 주세요.")
        val result = readln()
        return parseLottoNumbers(result)
    }

    fun getBonusNumber(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        val result = readln()
        return LottoNumber.of(result)
    }
}
