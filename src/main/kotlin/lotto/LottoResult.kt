package lotto

class LottoResult {
    private val prizeList = mutableListOf<Prize>()

    fun add(prize: Prize) {
        prizeList.add(prize)
    }

    fun getTotalPrizeMoney(): Int {
        return prizeList.sumOf { it.money }
    }

    fun getFirstPrize(): List<Prize> {
        return prizeList.filter { it == Prize.FIRST }
    }

    fun getSecondPrize(): List<Prize> {
        return prizeList.filter { it == Prize.SECOND }
    }

    fun getThirdPrize(): List<Prize> {
        return prizeList.filter { it == Prize.THIRD }
    }

    fun getFourthPrize(): List<Prize> {
        return prizeList.filter { it == Prize.FOURTH }
    }

    fun getNonePrize(): List<Prize> {
        return prizeList.filter { it == Prize.NONE }
    }

}
