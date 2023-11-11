package me.parker.nextstep.kotlinlotto.domain

data class LottoNumber(val number: Int) {

    init {
        require(number in 1..45) { "로또 번호는 1 ~ 45 사이만 가능합니다." }
    }

    constructor(rule: LottoNumberGenerationRule) : this(rule.generate())

    override fun toString(): String {
        return "$number"
    }
}

interface LottoNumberGenerationRule {

    fun generate(): Int
}

class RandomLottoNumberGenerationRule : LottoNumberGenerationRule {

    override fun generate(): Int {
        return (1..45).random()
    }
}

class ManualLottoNumberGenerationRule(private val number: Int) : LottoNumberGenerationRule {

    override fun generate(): Int {
        return number
    }
}
