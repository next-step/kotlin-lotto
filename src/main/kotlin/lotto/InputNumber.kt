package lotto

import java.lang.IllegalArgumentException

object InputNumber {

    fun buy(): Int {
        println("구입 금액을 입력해주세요.")
        val price = readLine()!!.toInt()
        if (price < 1000) {
            throw IllegalArgumentException("1000원 이상부터 구매가 가능합니다.")
        } else {
            return price / 1000
        }
    }

    fun buyHandLotto():Int{
        println("수동으로 구매할 번호를 입력하세요")
        return readLine()!!.toInt()
    }

    fun winningNumberInput(): List<Int> {
        println("지난주 당첨번호를 입력해 주세요.")
        val winningLottoNumber = readLine()!!.split(",").map { it.toInt() }
        require(winningLottoNumber.size == 6)
        return winningLottoNumber
    }

    fun bonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readLine()!!.toInt()
    }
}
