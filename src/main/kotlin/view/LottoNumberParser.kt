package view

import domain.lotto.LottoNumbers

object LottoNumberParser {
    fun parse(input: String): LottoNumberParsedResult {
        if (input.isBlank()) {
            return InvalidManualNumbers("빈 문자열입니다. 다시 입력해 주세요.")
        }

        val parsedInts = parseIntList(input).filterNotNull()

        if (parsedInts.size != LottoNumbers.SIZE) {
            return InvalidManualNumbers("잘못된 로또번호입니다. 1부터 45 사이 숫자 여섯 개를 입력해 주세요.")
        }

        return ParsedManualNumbers(parsedInts)
    }

    private fun parseIntList(input: String) = input.split(",").map { it.trim().toIntOrNull() }
        .toSet()
}
