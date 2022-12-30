package lotto.view

object InputView {

    fun getPurchaseFee(): Int {
        println("구입금액을 입력해 주세요.")
        return try {
            readln().toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자를 입력해주세요")
        }
    }

    fun getWinNumbers(): String {
        println()
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln()
    }

    fun getBonusNumbers(): String {
        println()
        println("보너스 볼을 입력해 주세요.")
        return readln()
    }

    fun getManualCount(): Int {
        println()
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return try {
            readln().toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자를 입력해주세요")
        }
    }

    fun getManualNumbers(count: Int): List<String> {
        println()
        return if (count != 0) {
            println("수동으로 구매할 번호를 입력해 주세요.")
            buildList { repeat(count) { add(readln()) } }
        } else {
            emptyList()
        }
    }
}
