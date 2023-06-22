package lotto.view

object InputView {

    fun inputPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun inputLottoWinningNumbers(): Set<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln().toNumbers()
    }

    fun inputLottoBonusNumbers(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readln().toInt()
    }

    fun inputSelfLottoNumbers(): List<Set<Int>> {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val count = readln().toIntOrNull() ?: 0
        return if (count > 0) {
            println("수동으로 구매할 번호를 입력해 주세요.")
            List(count) {
                readln().toNumbers()
            }
        } else {
            emptyList()
        }
    }
}

private const val DELIMITER = ","
fun String.toNumbers() = this.split(DELIMITER).map { it.toInt() }.toSet()
