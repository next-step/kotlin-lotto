package lotto.domain

class WinningMachine(private val winLotto: Lotto) {

    fun match(lottos: List<Lotto>): Statistics {

        val statistic = Statistics()

        for(lotto in lottos) {
            val count = judge(lotto, winLotto)
            statistic.add(count, lotto)
        }

        return statistic
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

}