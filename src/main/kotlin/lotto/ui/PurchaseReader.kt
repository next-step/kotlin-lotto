package lotto.ui

object PurchaseReader {

    private const val DELIMITER = ","
    fun auto(): Int {
        println("구매금액을 입력해 주세요.")
        val purchaseFee = readln()
        return purchaseFee.toInt()
    }
    fun manual(): List<List<Int>> {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val count = readln().toInt()

        println("수동으로 구매할 번호를 입력해 주세요.")
        return (0 until count).map {
            readln().split(DELIMITER)
                .map { it.trim() }
                .map { it.toInt() }
        }
    }
}
