package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Winner

object InputView {
    const val WINER_TEXT_DELIMITER = ","

    fun getCash(): Int {
        println("구매금액을 입력해 주세요.")
        return readPositiveNumber()
    }

    private fun readPositiveNumber(): Int {
        val str = readLine()
        if (str.isNullOrEmpty() || !isPositiveNumber(str)) {
            println("잘못된 입력입니다. 다시 입력해주세요.")
            return readPositiveNumber()
        }
        return str.toInt()
    }

    fun getWinner(): Winner {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val lotto = readLotto()
        println("보너스 볼을 입력해 주세요.")
        val bonusNumber = readBonusNumber()

        return Winner(lotto, bonusNumber)
    }

    private fun readBonusNumber(): LottoNumber {
        return LottoNumber(readPositiveNumber())
    }

    private fun readLotto(): Lotto {
        val str = readLine()
        if (isInvalidLottoString(str)) {
            println("잘못된 입력입니다. 다시 입력해주세요.")
            return readLotto()
        }

        return Lotto(str!!.split(WINER_TEXT_DELIMITER).map { LottoNumber(it.trim().toInt()) })
    }

    private fun isInvalidLottoString(str: String?): Boolean {
        return str.isNullOrEmpty() ||
            str.split(WINER_TEXT_DELIMITER).size != 6 ||
            !str.split(WINER_TEXT_DELIMITER).map { it.trim() }.all { isPositiveNumber(it) }
    }

    private fun isPositiveNumber(str: String): Boolean {
        return str.all { it.isDigit() }
    }

    fun getNumberOfManual(limit: Int): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val number = readPositiveNumber()
        if (number > limit) {
            println("최대 $limit 개의 로또만 구입 가능합니다.")
            return getNumberOfManual(limit)
        }
        return number
    }

    fun getManualLotto(count: Int): List<Lotto> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return (1..count).map { readLotto() }
    }
}
