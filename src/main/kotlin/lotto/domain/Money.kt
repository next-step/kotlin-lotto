package lotto.domain

class Money(string: String?) {

    init {
        checkNullBlank(string)
    }

    val money = checkUnit(changeInt(string!!))

    private fun checkNullBlank(string: String?): String {
        if (string.isNullOrBlank()) {
            throw IllegalArgumentException("null값과 공백값은 입력할수없습니다.")
        }
        return string
    }

    private fun changeInt(string: String): Int {
        try {
            return string.toInt()
        } catch (e: Exception) {
            throw IllegalArgumentException("숫자만 입력해주세요")
        }
    }

    private fun checkUnit(int: Int): Int {
        if (int < 1000) {
            throw IllegalArgumentException("돈은 1000원 이상 입력해주세요")
        }
        return int - int % 1000
    }

    fun getRateOfReturn(rank: Rank): Double {
        val ranking = PrizeMoney.values()
        var totalPrizeMoney = 0
        ranking.forEach {
            totalPrizeMoney += it.totalMoney(rank.ranks.getValue(it))
        }
        return totalPrizeMoney / money.toDouble()
    }
}
