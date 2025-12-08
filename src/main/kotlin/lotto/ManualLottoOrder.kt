package lotto

class ManualLottoOrder(manualCount: ManualCount, val lottos: List<Lotto>) {
    val usedMoney: Money

    init {
        require(lottos.size == manualCount.count) {
            "수동 로또 개수와 입력된 로또 개수가 일치하지 않습니다."
        }
        val manualMoney = manualCount.count * LottoShop.LOTTO_UNIT_PRICE
        usedMoney = Money(manualMoney)
    }

    constructor(manualCount: ManualCount, manualLottoNumbers: String?) : this(
        manualCount,
        parseAndValidate(manualLottoNumbers),
    )

    companion object {
        private const val ERROR_MESSAGE_INVALID = "올바른 로또 번호를 입력하세요"

        fun create(manualCount: ManualCount): ManualLottoOrder {
            while (true) {
                try {
                    val manualLottoNumbers =
                        if (manualCount.count > 0) {
                            println("수동으로 구매할 로또 번호를 입력해 주세요.")
                            (1..manualCount.count).joinToString("\n") { readln() }
                        } else {
                            null
                        }
                    return ManualLottoOrder(manualCount, manualLottoNumbers)
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                }
            }
        }

        private fun parseAndValidate(manualLottoNumbers: String?): List<Lotto> {
            if (manualLottoNumbers == null || manualLottoNumbers.isBlank()) {
                return emptyList()
            }

            val lines = manualLottoNumbers.trim().split("\n")

            return lines.mapIndexed { index, line ->
                try {
                    val numbers =
                        line
                            .trim()
                            .split(" ")
                            .filter { it.isNotBlank() }
                            .map { LottoNumber(it) }
                    Lotto(numbers)
                } catch (e: Exception) {
                    throw IllegalArgumentException("${index + 1}번째 줄: ${ERROR_MESSAGE_INVALID}", e)
                }
            }
        }
    }
}
