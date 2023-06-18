package lotto.view

object InputView {

    private const val NUMBER_SEPARATOR = ","

    fun getPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readInt()
    }

    fun getManualLottoCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readInt()
    }

    fun getManualLotto(count: Int): List<Set<Int>> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return List(count) {
            getNumbers()
        }
    }

    fun getBonusNumber(): Int {
        println("보너스 볼을 입력해주세요.")
        return readInt()
    }

    fun getLottoNumbersOfLastWeek(): Set<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return getNumbers()
    }

    private fun getNumbers(): Set<Int> {
        return readln()
            .split(NUMBER_SEPARATOR)
            .mapNotNull {
                it.trim()
                    .toIntOrNull()
            }.toSet()
    }

    private tailrec fun readInt(): Int {
        val enteredInt = readln().toIntOrNull()
        if (enteredInt != null) return enteredInt
        println("다시 입력해 주세요.")
        return readInt()
    }
}
