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
        return prizeList.filter { it == Prize.First }
    }

    fun getSecondPrize(): List<Prize> {
        return prizeList.filter { it == Prize.Second }
    }

    fun getThirdPrize(): List<Prize> {
        return prizeList.filter { it == Prize.Third }
    }

    fun getFourthPrize(): List<Prize> {
        return prizeList.filter { it == Prize.Fourth }
    }

    fun getNonePrize(): List<Prize> {
        return prizeList.filter { it == Prize.None }
    }

}
