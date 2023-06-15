package lotto.view

object InputView {
    fun getPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readInt()
    }

    private tailrec fun readInt(): Int {
        val enteredInt = readln().toIntOrNull()
        if (enteredInt != null) return enteredInt
        println("다시 입력해 주세요.")
        return readInt()
    }
}
