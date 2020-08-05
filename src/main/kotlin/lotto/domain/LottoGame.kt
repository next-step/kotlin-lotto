package lotto.domain

import java.lang.IllegalArgumentException
import java.lang.NumberFormatException
import java.lang.StringBuilder
import java.math.BigDecimal
import java.util.regex.Pattern

const val COUNT_OF_NUMBERS = 6
private const val MAX_NUMBER = 45
private const val MIN_NUMBER = 1
const val PRICE_OF_LOTTO = 1000
private const val NUMBER_RANGE = "(4[0-5]|[1-3][0-9]|[1-9])"

class LottoGame(gameMoney: String) {
    private val lottoNumbers: MutableList<List<Number>> = mutableListOf()
    private var prizes: MutableList<Lotto> = mutableListOf()
    private var totalPrizeMoney: Int = 0
    var count: Int = 0
        private set
    var profitRate: Double = 0.0
        private set

    private var prizeNumbers: List<Number> = listOf()

    init {
        checkGameMoneyValidation(gameMoney)
        Prize.values().filter { it.prizeMoney > 0 }
            .forEach { prizes.add(Lotto(it)) }
    }

    fun execute(prizeNumberString: String): List<Lotto> {
        prizeNumbers = checkPrizeNumbersValidation(prizeNumberString)
        lottoNumbers.forEach { checkMatch(it) }
        calculateProfitRate()
        return prizes
    }

    fun createLotto(): MutableList<List<Number>> {
        repeat(count) {
            lottoNumbers.add((MIN_NUMBER..MAX_NUMBER).shuffled().subList(0, COUNT_OF_NUMBERS).sorted())
        }
        return lottoNumbers
    }

    private fun checkMatch(lottoNumbers: List<Number>) {
        var count = 0
        lottoNumbers.forEach { if (prizeNumbers.contains(it)) count++ }
        val prizeMoney = Prize.getPrizeMoney(count)
        if (prizeMoney > 0) {
            val selectedLotto = prizes.find { it.getCountOfMatch() == count }
            selectedLotto!!.addCount()
            totalPrizeMoney += selectedLotto.getPrizeMoney()
        }
    }

    private fun calculateProfitRate() {
        profitRate = totalPrizeMoney.toBigDecimal()
            .divide((count * PRICE_OF_LOTTO).toBigDecimal(), 2, BigDecimal.ROUND_HALF_EVEN)
            .stripTrailingZeros().toDouble()
    }

    @Throws(NumberFormatException::class)
    private fun checkGameMoneyValidation(gameMoney: String) {
        count = gameMoney.toInt() / PRICE_OF_LOTTO
        require(gameMoney.toInt() >= PRICE_OF_LOTTO) {
            throw IllegalArgumentException("$PRICE_OF_LOTTO 보다 큰 숫자를 입력해주세요.")
        }
    }

    @Throws(IllegalArgumentException::class)
    private fun checkPrizeNumbersValidation(prizeNumberString: String): List<Number> {
        val numberPattern = StringBuilder()
        for (i in 2..COUNT_OF_NUMBERS)
            numberPattern.append(NUMBER_RANGE).append(",")
        numberPattern.append(NUMBER_RANGE)

        val pattern = Pattern.compile(numberPattern.toString())

        if (!pattern.matcher(prizeNumberString).matches()) {
            throw IllegalArgumentException("1~45 사이의 숫자와 `,`로 만 값을 입력해 주세요.")
        }
        val prizeNumbers = prizeNumberString.split(",").map { it.toInt() }.toHashSet().toList()
        if (prizeNumbers.size != COUNT_OF_NUMBERS) {
            throw IllegalArgumentException("중복되지 않은 숫자 6개를 입력해주세요.")
        }
        return prizeNumbers
    }
}
