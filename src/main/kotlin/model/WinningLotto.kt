package model

class WinningLotto(override val number: List<LottoNumber>, val bonusNumber: Int) : BasicLotto {
    fun matchResult(value: Lotto): Pair<Int, Boolean> {
        return number.count { value.number.contains(it) } to value.number.contains(LottoNumber(bonusNumber))
    }

    fun rank(value: Lotto): Rank {
        val matchResult = matchResult(value)
        return Rank.valueOf(matchResult.first, matchResult.second)
    }
}
