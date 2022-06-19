package camp.nextstep.lotto.number

import java.util.function.Predicate

class LottoNumbers(val lottoNumbers: List<LottoNumber>) {

    val size = lottoNumbers.size

    operator fun get(index: Int): LottoNumber {
        return lottoNumbers[index]
    }

    fun none(predicate: (LottoNumber) -> Boolean): Boolean {
        return lottoNumbers.none(predicate)
    }

    fun contains(number: LottoNumber): Boolean {
        return lottoNumbers.contains(number)
    }

    fun count(predicate: Predicate<LottoNumber>): Int {
        return lottoNumbers.count { predicate.test(it) }
    }

    fun sortedByNaturalOrder(): LottoNumbers {
        return LottoNumbers(lottoNumbers.sortedBy { it.value })
    }

    fun toSet(): Set<LottoNumber> {
        return lottoNumbers.toSet()
    }
}
