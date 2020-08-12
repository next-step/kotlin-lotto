package lotto

object InputNumber {
    fun buy(): Int {
        println("구입 금액을 입력해주세요.")
        return readLine()!!.toInt()
    }

    fun winningNumberInput(): List<Int> {
        println("지난주 당첨번호를 입력해 주세요.")
        val winningLottoNumber = readLine()!!.split(",").map { it.toInt() }
        require(winningLottoNumber.size == 6)
        return winningLottoNumber
    }
}
