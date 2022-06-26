package lotto.view

object InputView {
    fun getPurchaseAmount(): Long {
        println("구입금액을 입력해 주세요.")
        return convertToLong(readLine())
    }

    fun getManualLottoCount(): Int {
        println("\n수동으로 구매할 로또 수를 입력해 주세요.")
        return convertToInt(readLine())
    }

    fun getManualLottoNumbers(count: Int): List<List<Int>> {
        println("\n수동으로 구매할 번호를 입력해 주세요.")
        return (0 until count).map {
            convertToListInt(readLine())
        }
    }

    fun getWinningNumbers(): List<Int> {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        return convertToListInt(readLine())
    }

    fun getBonusNumber(): Int {
        println("\n보너스 볼을 입력해 주세요.")
        return convertToInt(readLine())
    }

    private fun convertToInt(numberStr: String?): Int {
        numberStr.checkNullOrBlank()
        return numberStr!!.toNumericInt()
    }

    private fun convertToLong(numberStr: String?): Long {
        numberStr.checkNullOrBlank()
        return numberStr!!.toNumericLong()
    }

    private fun convertToListInt(numberStr: String?): List<Int> {
        numberStr.checkNullOrBlank()
        return numberStr!!.split(",").map { it.toNumericInt() }
    }
}

fun String?.checkNullOrBlank() = require(!this.isNullOrBlank()) { "입력값이 비어있어요." }

fun String.toNumericInt(): Int {
    val number = this.trim().toIntOrNull() ?: throw IllegalArgumentException("잘못된 숫자 입력입니다.")
    require(number >= 0) { "0이상의 숫자만 입력해 주세요. given: $this" }
    return number
}

fun String.toNumericLong(): Long {
    val number = this.trim().toLongOrNull() ?: throw IllegalArgumentException("잘못된 숫자 입력입니다.")
    require(number >= 0L) { "0이상의 숫자만 입력해 주세요. given: $this" }
    return number
}
