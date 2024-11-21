package lotto.domain

interface LottoRankCondition {
    fun match(matchCount: Int, isBonusMatched: Boolean): Boolean
}

class NoneCondition : LottoRankCondition {
    override fun match(matchCount: Int, isBonusMatched: Boolean): Boolean {
        return matchCount < 3
    }
}

class FifthCondition : LottoRankCondition {
    override fun match(matchCount: Int, isBonusMatched: Boolean): Boolean {
        return matchCount == 3
    }
}

class FourthCondition : LottoRankCondition {
    override fun match(matchCount: Int, isBonusMatched: Boolean): Boolean {
        return matchCount == 4
    }
}

class ThirdCondition : LottoRankCondition {
    override fun match(matchCount: Int, isBonusMatched: Boolean): Boolean {
        return matchCount == 5 && !isBonusMatched
    }
}

class SecondCondition : LottoRankCondition {
    override fun match(matchCount: Int, isBonusMatched: Boolean): Boolean {
        return matchCount == 5 && isBonusMatched
    }
}

class FirstCondition : LottoRankCondition {
    override fun match(matchCount: Int, isBonusMatched: Boolean): Boolean {
        return matchCount == 6
    }
}
