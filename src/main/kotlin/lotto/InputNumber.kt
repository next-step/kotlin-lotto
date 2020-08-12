package lotto

object InputNumber {
    fun buy(): Int {
        print("구입 금액을 입력해주세요.")
        return readLine()!!.toInt()
    }

    fun winningNumberInput(): List<Int> {
        val winningLottoNumber = readLine()!!.split(",").map { it.toInt() }
        require(winningLottoNumber.size == 6)
        return winningLottoNumber
    }
}

