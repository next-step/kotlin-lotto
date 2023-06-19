package lotto

import lotto.vo.LottoNumber

class Lotto(
    val lottoNumbers: Set<LottoNumber>,
) {
    init {
        require(lottoNumbers.size == 6) { "로또 번호는 중복 없이 6개만 입력 가능합니다." }
    }

    fun countMatchingNumbersFrom(winningNumbers: List<LottoNumber>): Int {
        var count = 0

        winningNumbers.forEach { winningNumber ->
            if (lottoNumbers.contains(winningNumber)) count++
        }

        return count
    }

    companion object {

        fun from(numbers: Collection<LottoNumber>): Lotto {
            return Lotto(numbers.toSet())
        }
    }
}
