package lotto.domain

import java.lang.IllegalArgumentException

class LottoMachine{

    fun checkLottoResult(lotto: Lotto, winningNumbers: String): LottoResult {
        val parsedWinningNumbers = getParsedWinningNumbers(winningNumbers)
        val lottoResult = lotto.getAllSameNumberCount(parsedWinningNumbers)
            .mapNotNull { LottoRank.of(it) }
            .groupingBy { it }
            .fold(0) { acc, _ -> acc + 1 }
        return LottoResult(lottoResult)
    }

    private fun getParsedWinningNumbers(numbers: String): List<Int> {
        val result = numbers.split(", ").mapNotNull { it.toIntOrNull() }
        if (result.size != 6) {
            throw IllegalArgumentException("당첨 번호를 ', ' 기준으로 6개의 숫자를 입력하여 주세요.")
        }
        return result
    }
}
