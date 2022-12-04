package lotto.domain

class WinningMachine(private val winLotto: Lotto) {

    fun match(lottos: List<Lotto>): Map<Int, MutableList<Lotto>> {

        val statistic: Map<Int, MutableList<Lotto>> = initStatistic()

        for(lotto in lottos) {
            val count = judge(lotto, winLotto)
            statistic[count]?.add(lotto)
        }

        return statistic.filter { (key, _) -> key >= WIN_LOTTO_NUM_COUNT }
    }

    private fun initStatistic(): Map<Int, MutableList<Lotto>> {
        return mutableMapOf(
            1 to mutableListOf(),
            2 to mutableListOf(),
            3 to mutableListOf(),
            4 to mutableListOf(),
            5 to mutableListOf(),
            6 to mutableListOf(),)
    }

    private fun judge(lotto: Lotto, winLotto: Lotto): Int {
        var count = 0
        for(num in winLotto) {
            count += judge(lotto, num)
        }
        return count
    }

    private fun judge(lotto: Lotto, num: LottoNum): Int {
        return if(lotto.contains(num)) 1 else 0
    }

    companion object {
        const val WIN_LOTTO_NUM_COUNT = 3
    }
}