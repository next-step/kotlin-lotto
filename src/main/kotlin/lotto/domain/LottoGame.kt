package lotto.domain

class LottoGame(private var money: Money) {

    fun purchaseManualLottoes(numberOfManual: Int, stringManualNumbers: List<List<String>>): Lottoes {
        checkEnoughMoney(numberOfManual)
        money.spendMoney(LOTTO_COST * numberOfManual)
        val manualNumbers = stringManualNumbers.map { strings ->
            convertStringToInt(strings)
        }

        val lottoes = manualNumbers.map { LottoTicket.generateManual(it) }
        return Lottoes(lottoes)
    }

    fun purchaseAutoLottoes(): Lottoes {
        val quantity = (money.currentMoney / LOTTO_COST).toInt()
        money.spendAllMoney()

        val lottoes = (1..quantity).map {
            generateAutoLotto()
        }

        return Lottoes(lottoes)
    }

    private fun generateAutoLotto(): LottoTicket {
        val numbers = (LottoNumber.MIN_LOTTO_NUMBER..LottoNumber.MAX_LOTTO_NUMBER)
            .shuffled()
            .take(LottoTicket.LENGTH_OF_LOTTO)
            .sorted()

        return LottoTicket(
            numbers.map { number ->
                LottoNumber.from(number)
            }.toSet()
        )
    }

    private fun checkEnoughMoney(numberOfManual: Int) {
        if (numberOfManual * LOTTO_COST > money.currentMoney) throw IllegalStateException("사고자 하는 수량이 현재 가진 돈보다 많습니다.")
    }

    private fun convertStringToInt(strings: List<String>): List<Int> {
        return strings.map {
            it.toInt()
        }
    }

    companion object {
        const val LOTTO_COST = 1000
    }
}
