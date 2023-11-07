package lotto

class LottoMachine {

    fun create(money: Int = 1000): List<Any> {
        val size = money / 1000
        return (0 until size).map { it }
    }
}
